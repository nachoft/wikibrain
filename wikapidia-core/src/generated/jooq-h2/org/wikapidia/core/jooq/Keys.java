/**
 * This class is generated by jOOQ
 */
package org.wikapidia.core.jooq;

/**
 * This class is generated by jOOQ.
 *
 * A class modelling foreign key relationships between tables of the <code>PUBLIC</code> 
 * schema
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "3.0.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.Identity<org.wikapidia.core.jooq.tables.records.LinkRecord, java.lang.Long> IDENTITY_LINK = Identities0.IDENTITY_LINK;
	public static final org.jooq.Identity<org.wikapidia.core.jooq.tables.records.ConceptRecord, java.lang.Long> IDENTITY_CONCEPT = Identities0.IDENTITY_CONCEPT;
	public static final org.jooq.Identity<org.wikapidia.core.jooq.tables.records.LocalPageRecord, java.lang.Long> IDENTITY_LOCAL_PAGE = Identities0.IDENTITY_LOCAL_PAGE;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<org.wikapidia.core.jooq.tables.records.ArticleRecord> CONSTRAINT_F = UniqueKeys0.CONSTRAINT_F;
	public static final org.jooq.UniqueKey<org.wikapidia.core.jooq.tables.records.LinkRecord> CONSTRAINT_2 = UniqueKeys0.CONSTRAINT_2;
	public static final org.jooq.UniqueKey<org.wikapidia.core.jooq.tables.records.ConceptRecord> CONSTRAINT_6 = UniqueKeys0.CONSTRAINT_6;
	public static final org.jooq.UniqueKey<org.wikapidia.core.jooq.tables.records.LocalPageRecord> CONSTRAINT_6C = UniqueKeys0.CONSTRAINT_6C;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends org.jooq.impl.AbstractKeys {
		public static org.jooq.Identity<org.wikapidia.core.jooq.tables.records.LinkRecord, java.lang.Long> IDENTITY_LINK = createIdentity(org.wikapidia.core.jooq.tables.Link.LINK, org.wikapidia.core.jooq.tables.Link.LINK.ID);
		public static org.jooq.Identity<org.wikapidia.core.jooq.tables.records.ConceptRecord, java.lang.Long> IDENTITY_CONCEPT = createIdentity(org.wikapidia.core.jooq.tables.Concept.CONCEPT, org.wikapidia.core.jooq.tables.Concept.CONCEPT.ID);
		public static org.jooq.Identity<org.wikapidia.core.jooq.tables.records.LocalPageRecord, java.lang.Long> IDENTITY_LOCAL_PAGE = createIdentity(org.wikapidia.core.jooq.tables.LocalPage.LOCAL_PAGE, org.wikapidia.core.jooq.tables.LocalPage.LOCAL_PAGE.ID);
	}

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<org.wikapidia.core.jooq.tables.records.ArticleRecord> CONSTRAINT_F = createUniqueKey(org.wikapidia.core.jooq.tables.Article.ARTICLE, org.wikapidia.core.jooq.tables.Article.ARTICLE.ID);
		public static final org.jooq.UniqueKey<org.wikapidia.core.jooq.tables.records.LinkRecord> CONSTRAINT_2 = createUniqueKey(org.wikapidia.core.jooq.tables.Link.LINK, org.wikapidia.core.jooq.tables.Link.LINK.ID);
		public static final org.jooq.UniqueKey<org.wikapidia.core.jooq.tables.records.ConceptRecord> CONSTRAINT_6 = createUniqueKey(org.wikapidia.core.jooq.tables.Concept.CONCEPT, org.wikapidia.core.jooq.tables.Concept.CONCEPT.ID);
		public static final org.jooq.UniqueKey<org.wikapidia.core.jooq.tables.records.LocalPageRecord> CONSTRAINT_6C = createUniqueKey(org.wikapidia.core.jooq.tables.LocalPage.LOCAL_PAGE, org.wikapidia.core.jooq.tables.LocalPage.LOCAL_PAGE.ID);
	}
}