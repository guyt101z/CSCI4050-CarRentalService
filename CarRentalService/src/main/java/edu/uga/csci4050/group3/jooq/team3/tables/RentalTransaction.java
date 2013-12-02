/**
 * This class is generated by jOOQ
 */
package edu.uga.csci4050.group3.jooq.team3.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RentalTransaction extends org.jooq.impl.TableImpl<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord> {

	private static final long serialVersionUID = 1877622322;

	/**
	 * The singleton instance of <code>team3.RENTAL_TRANSACTION</code>
	 */
	public static final edu.uga.csci4050.group3.jooq.team3.tables.RentalTransaction RENTAL_TRANSACTION = new edu.uga.csci4050.group3.jooq.team3.tables.RentalTransaction();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord> getRecordType() {
		return edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord.class;
	}

	/**
	 * The column <code>team3.RENTAL_TRANSACTION.id</code>. 
	 */
	public final org.jooq.TableField<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this);

	/**
	 * The column <code>team3.RENTAL_TRANSACTION.uid</code>. 
	 */
	public final org.jooq.TableField<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord, java.lang.String> UID = createField("uid", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>team3.RENTAL_TRANSACTION.start_date</code>. 
	 */
	public final org.jooq.TableField<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord, java.lang.Integer> START_DATE = createField("start_date", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>team3.RENTAL_TRANSACTION.end_date</code>. 
	 */
	public final org.jooq.TableField<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord, java.lang.Integer> END_DATE = createField("end_date", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>team3.RENTAL_TRANSACTION.user</code>. 
	 */
	public final org.jooq.TableField<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord, java.lang.String> USER = createField("user", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>team3.RENTAL_TRANSACTION.vehicle</code>. 
	 */
	public final org.jooq.TableField<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord, java.lang.String> VEHICLE = createField("vehicle", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * Create a <code>team3.RENTAL_TRANSACTION</code> table reference
	 */
	public RentalTransaction() {
		super("RENTAL_TRANSACTION", edu.uga.csci4050.group3.jooq.team3.Team3.TEAM3);
	}

	/**
	 * Create an aliased <code>team3.RENTAL_TRANSACTION</code> table reference
	 */
	public RentalTransaction(java.lang.String alias) {
		super(alias, edu.uga.csci4050.group3.jooq.team3.Team3.TEAM3, edu.uga.csci4050.group3.jooq.team3.tables.RentalTransaction.RENTAL_TRANSACTION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord, java.lang.Integer> getIdentity() {
		return edu.uga.csci4050.group3.jooq.team3.Keys.IDENTITY_RENTAL_TRANSACTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord> getPrimaryKey() {
		return edu.uga.csci4050.group3.jooq.team3.Keys.KEY_RENTAL_TRANSACTION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<edu.uga.csci4050.group3.jooq.team3.tables.records.RentalTransactionRecord>>asList(edu.uga.csci4050.group3.jooq.team3.Keys.KEY_RENTAL_TRANSACTION_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public edu.uga.csci4050.group3.jooq.team3.tables.RentalTransaction as(java.lang.String alias) {
		return new edu.uga.csci4050.group3.jooq.team3.tables.RentalTransaction(alias);
	}
}