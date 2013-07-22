package org.wikapidia.sr;

import org.apache.commons.cli.*;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.PosixParser;
import org.wikapidia.conf.Configuration;
import org.wikapidia.conf.ConfigurationException;
import org.wikapidia.conf.Configurator;
import org.wikapidia.conf.DefaultOptionBuilder;
import org.wikapidia.core.cmd.Env;
import org.wikapidia.core.dao.DaoException;
import org.wikapidia.core.lang.Language;
import org.wikapidia.sr.utils.Dataset;
import org.wikapidia.sr.utils.DatasetDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Matt Lesciko
 * @author Ben Hillmann
 */
public class MetricTrainer {

    public static void main(String[] args) throws ConfigurationException, DaoException, IOException, ClassNotFoundException {
        Options options = new Options();

//        //Which normalizer to use
//        options.addOption(
//                new DefaultOptionBuilder()
//                        .withLongOpt("normalizer")
//                        .withDescription("specify which normalizer to use")
//                        .create("n"));
        //A list of universal algorithm ids

        options.addOption(
                new DefaultOptionBuilder()
                        .withLongOpt("universal")
                        .withDescription("set a universal metric")
                        .create("u"));

        options.addOption(
                new DefaultOptionBuilder()
                        .withLongOpt("algorithms")
                        .withDescription("the set of algorithm ids for universal pages to process, separated by commas")
                        .create("a"));
        //Number of Max Results(otherwise take from config)
        options.addOption(
                new DefaultOptionBuilder()
                        .withLongOpt("max-results")
                        .withDescription("the set of algorithms for universal pages to process, separated by commas")
                        .create("r"));
        //Specify the Dataset
        options.addOption(
                new DefaultOptionBuilder()
                        .withLongOpt("datasets")
                        .withDescription("the set of datasets to train on, separated by commas")
                        .create("d"));
        //Specify the Metrics
        options.addOption(
                new DefaultOptionBuilder()
                        .withLongOpt("metrics")
                        .withDescription("set a local metric")
                        .create("m"));

        Env.addStandardOptions(options);


        CommandLineParser parser = new PosixParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println("Invalid option usage: " + e.getMessage());
            new HelpFormatter().printHelp("MetricTrainer", options);
            return;
        }

        Env env = new Env(cmd);

        Configurator c = new Configurator(new Configuration());

        LocalSRMetric sr = c.get(LocalSRMetric.class);
        UniversalSRMetric usr = c.get(UniversalSRMetric.class);



        List<String> datasetConfig = c.getConf().get().getStringList("sr.dataset.names");

        if (datasetConfig.size()%2 != 0) {
            throw new ConfigurationException("Datasets must be paired with a matching language");
        }

        String datasetPath = c.getConf().get().getString("sr.dataset.path");
        String normalizerPath = c.getConf().get().getString("sr.normalizers.directory");

        List<Dataset> datasets = new ArrayList<Dataset>();
        DatasetDao datasetDao = new DatasetDao();

        for (int i = 0; i < datasetConfig.size();i+=2) {
            String language = datasetConfig.get(i);
            String datasetName = datasetConfig.get(i+1);
            datasets.add(datasetDao.read(Language.getByLangCode(language), datasetPath + datasetName));
        }

        for (Dataset dataset: datasets) {
            usr.trainSimilarity(dataset);
            usr.trainMostSimilar(dataset,100,null);
            sr.trainDefaultSimilarity(dataset);
            sr.trainDefaultMostSimilar(dataset,100,null);
            sr.trainSimilarity(dataset);
            sr.trainMostSimilar(dataset,100,null);
        }

        usr.write(normalizerPath);
        sr.write(normalizerPath);

        usr.read(normalizerPath);
        sr.read(normalizerPath);



        System.out.println(datasets.get(0));



    }
}
