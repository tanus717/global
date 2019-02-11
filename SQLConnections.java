package com.DataMigration.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnections {

	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String adminURL = GetValue.getSQLGetConnectionServer();
	String username = GetValue.getSQLGetConnectionUserName();
	String password = GetValue.getSQLGetConnectionPassword();

	public static SQLConnections Instance = null;

	public SQLConnections() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static SQLConnections getInstance() {
		if (Instance == null) {
			Instance = new SQLConnections();
		}
		return Instance;
	}

	public Connection getDBConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(adminURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/*
	 * Attach data Candidates
	 */
	public static String getAttachSQLData(Integer candId) {

		String queryString = "SELECT AA.*,J.id AS jobId, J.name AS jobName, J.accountid AS accountId, J.accountname AS "
				+ "accountName, J.hrcontactid AS contactId, J.hrcontactname AS contactName FROM "
				+ GetValue.getAttachGetConnectionDBName() + ".dbo.attac_attach_resume AS " + "AA JOIN "
				+ GetValue.getAttachGetConnectionDBName()
				+ ".dbo.[jobs] AS J ON AA.job_id=J.id WHERE AA.ree_resume_id_c in('" + candId + "')AND AA.without_id=0";

		return queryString;
	}

	/*
	 * Attach data LinkedIn
	 */
	public static String getLinkedInAttachSQLData(Integer candId) {

		String queryString = "SELECT AA.*,J.id AS jobId, J.name AS jobName, J.accountid AS accountId, J.accountname AS "
				+ "accountName, J.hrcontactid AS contactId, J.hrcontactname AS contactName FROM "
				+ GetValue.getAttachGetConnectionDBName() + ".dbo.attac_attach_resume AS " + "AA JOIN "
				+ GetValue.getAttachGetConnectionDBName()
				+ ".dbo.[jobs] AS J ON AA.job_id=J.id WHERE AA.ree_resume_id_c in('" + candId + "')AND AA.without_id=1";

		return queryString;
	}

	/*
	 * Attach Audit Data
	 */
	public static String getAttachAuditSQLData(String id) {

		String queryString = "SELECT AAA.*, U.username FROM " + GetValue.getAttachAuditGetConnectionDBName()
				+ ".dbo.attacattachresumeaudit AS AAA LEFT Join HitechDB.dbo.users AS U ON AAA.createdby=U.id WHERE AAA.parentid='"
				+ id + "'";

		return queryString;
	}

	/*
	 * Attach HC Resume Bank
	 */

	public static String getAttachHCResume(String email) {

		String queryString = "SELECT id FROM " + GetValue.getAttachHCResumeBankGetConnectionDBName()
				+ ".dbo.hc_resume_bank WHERE EmailID='" + email + "'";

		return queryString;
	}

	/*
	 * Candidate Audit Data
	 */

	public static String getCandidateAudit(Integer canId) {

		String queryString = "SELECT AC.*, U.username FROM " + GetValue.getCandidateAuditGetConnectionDBName()
				+ ".dbo.oditCandidate AS AC LEFT Join HitechDB.dbo.users AS U ON AC.User_Name=U.id WHERE AC.User_id='"
				+ canId + "'";

		return queryString;
	}

	/*
	 * Candidate Audit Data
	 */

	public static String getCandidateAuditUserName(String id) {

		String queryString = "SELECT username FROM " + GetValue.getCandidateAuditGetUserNameDBName()
				+ ".dbo.users AS U WHERE U.id='" + id + "'";

		return queryString;
	}
}
