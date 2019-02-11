package com.DataMigration.DB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetValue {

	static Properties prop = new Properties();
	static String filepath = "/GetDBConnection.properties";
	static InputStream input = null;

	
	
	public static String getInsert_emailbody_Collection() {
		String value = "";
		
		try{
			
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			value = prop.getProperty("Email_Body_Collection");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return value;
	}
	
	
	
	public static String getLinkedInCandidate_Collection() {
		String value = "";
		
		try{
			
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			value = prop.getProperty("LinkedInCandidate_Collection");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return value;
	}
	
	//AudioCall
	public static String getAudioCall_Collection() {
		String value = "";
		
		try{
			
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			value = prop.getProperty("Audio_Call");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return value;
	}
	
	

	public static String getHitechURLapi() {

		String value = "";

		try {

			// InputStream input = new FileInputStream(filepath);
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("HitechAPIurl");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * MongoConnection to get Data
	 */

	public static String getMongoGetConnection() {

		String value = "";

		try {

			// InputStream input = new FileInputStream(filepath);
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Mongo_Get_Connection");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Attached to get Data
	 */

	public static String getAttachCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Attach_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}
	
	
	/*
	 * Attached to get Data
	 */

	public static String getEmail_Body_Collection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("EmailBody_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}
	

	// document get data
	public static String getDocumentCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Document_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	// template get data
	public static String getTemplateCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Template_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	// get attachaudit collection
	public static String getAttachAuditCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Attach_Audit_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	// get candidate collection
	public static String getCandidateCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Candidate_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	// get candidateaudit collection
	public static String getCandidateAuditCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Candidate_Audit_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Candidate to get Data
	 */

	public static String getCandidateGetMongoCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Candidate_Get_MongoCollection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * AttachedResume to get Data
	 */

	public static String getAttachGetMongoCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Attach_Get_MongoCollection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Mongo insertion connection
	 */

	public static String getMongoInsertionConnection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Mongo_Insertion_Connection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Candidate insertion collection
	 */

	public static String getCandidateInsertionCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Candidate_Insertion_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Candidate audit insertion collection
	 */

	public static String getCandidateAuditInsertionCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Candidate_Audit_Insertion_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * ReferenceId insertion collection
	 */

	public static String getReferenceIdInsertionCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("ReferenceId_Insertion_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Attach insert collection
	 */

	public static String getAttachInsertionCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Attach_Insertion_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Attach audit insert collection
	 */

	public static String getAttachAuditInsertionCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Attach_Audit_Insertion_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Server or HostName of SQL connection
	 */

	public static String getSQLGetConnectionServer() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("SQL_Get_Connection_Server");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Username of SQL connection
	 */

	public static String getSQLGetConnectionUserName() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("SQL_Get_Connection_UserName");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Password of SQL connection
	 */

	public static String getSQLGetConnectionPassword() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("SQL_Get_Connection_Password");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * SQL DB name to get candidate audit
	 */

	public static String getCandidateAuditGetConnectionDBName() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Candidate_Audit_Get_Connection_DBName");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;

	}

	/*
	 * SQL DB name to get candidate audit
	 */

	public static String getCandidateAuditGetUserNameDBName() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Candidate_Audit_GetUserName_DBName");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}
	/*
	 * Attach SQL DB name to get attach data
	 */

	public static String getAttachGetConnectionDBName() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Attach_Get_Connection_DBName");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * HCResumeBank SQL DB name to get HCResumeBank data
	 */

	public static String getAttachHCResumeBankGetConnectionDBName() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Attach_HCResumeBank_Get_Connection_DBName");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Attach Audit SQL DB name to get attach audit data
	 */

	public static String getAttachAuditGetConnectionDBName() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("Attach_Audit_Get_Connection_DBName");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * AttachedResume to get Data
	 */

	public static String getLinkedInGetMongoCollection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("LinkedInCandidate_Get_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Mongo insertion connection
	 */

	public static String getLinkedInMongoInsertionConnection() {
		String value = "";

		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);

			value = prop.getProperty("LinkedIn_Candidate_Insertion_Collection");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}

	/*
	 * Elastic candidate collection
	 */

	public static String getElasticCandidateCollection() {
		String value = "";
		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			value = prop.getProperty("Elastic_Candidate_Collection");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	/*
	 * Elastic candidate Audit collection
	 */

	public static String getElasticCandidateAuditCollection() {
		String value = "";
		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			value = prop.getProperty("Elastic_Candidate_Audit_Collection");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	/*
	 * Elastic Attach collection
	 */

	public static String getElasticAttachCollection() {
		String value = "";
		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			value = prop.getProperty("Elastic_Attach_Collection");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	/*
	 * Elastic attach audit collection
	 */

	public static String getElasticAttachAuditCollection() {
		String value = "";
		try {
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			value = prop.getProperty("Elastic_Attach_Audit_Collection");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return value;
	}
}
