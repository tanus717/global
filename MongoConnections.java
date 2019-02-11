package com.DataMigration.DB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnections {

	static MongoClientURI getConnection = new MongoClientURI(GetValue.getMongoGetConnection());
	static MongoClient getMongoClient = new MongoClient(getConnection);
	static MongoDatabase databaseGet = getMongoClient.getDatabase("CandidateDB");
	
	static MongoClientURI insertConnection = new MongoClientURI(GetValue.getMongoInsertionConnection());
	static MongoClient insertMongoClient = new MongoClient(insertConnection);
	static MongoDatabase databaseInsert = insertMongoClient.getDatabase("CandidateDB");
	
	
	//InsertEmailBody
	public static MongoCollection<Document> getInsertEmailBody_Collection(){
		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseInsert.getCollection(GetValue.getInsert_emailbody_Collection());

		return collection;
	}
	

	
	public static MongoCollection<Document> getLinkedInCandidate_Collection(){
		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getLinkedInCandidate_Collection());

		return collection;
	}
	
	/*
	 * get Collection  document
	 */
	public static MongoCollection<Document> getDocumentCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getDocumentCollection());

		return collection;
	}

	
	/*
	 * get Collection  attach
	 */
	public static MongoCollection<Document> getAttachCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getAttachCollection());

		return collection;
	}
	
	 /*get Collection  EmailBody*/
	
	public static MongoCollection<Document> getEmail_BodyCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getEmail_Body_Collection());

		return collection;
	}

	
/*	get Collection Audio Call*/
	
	public static MongoCollection<Document> getAudioCallCollection(){
		
		MongoCollection<Document> collection = null;
		
		collection = databaseGet.getCollection(GetValue.getAudioCall_Collection());
		
		return collection;
		
	}
	

	
	/*
	 * get Collection attach audit
	 */
	public static MongoCollection<Document> getAttachAuditCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getAttachAuditCollection());

		return collection;
	}
	
	/*
	 * get Collection candidate
	 */
	public static MongoCollection<Document> getCandidateCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getCandidateCollection());

		return collection;
	}
	
	/*
	 * get Collection to candidate audit
	 */
	public static MongoCollection<Document> getCandidateAuditCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getCandidateAuditCollection());

		return collection;
	}
	
	/*
	 * get Collection to template
	 */
	public static MongoCollection<Document> getTemplateCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getTemplateCollection());

		return collection;
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * get Collection to fetch attach
	 */
	public static MongoCollection<Document> getAttachResumeCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;
		
		collection = databaseGet.getCollection(GetValue.getAttachGetMongoCollection());

		
		return collection;
	}

	/*
	 * get Collection to fetch candidate
	 */
	public static MongoCollection<Document> getInsertCandidateCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseGet.getCollection(GetValue.getCandidateGetMongoCollection());

		return collection;
	}

	/*
	 * get Collection to insert attach
	 */
	public static MongoCollection<Document> attachCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseInsert.getCollection(GetValue.getAttachInsertionCollection());

		return collection;
	}

	
	/*
	 * get Collection to insert attach audit
	 */
	public static MongoCollection<Document> attachAuditCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseInsert.getCollection(GetValue.getAttachAuditInsertionCollection());

		return collection;
	}

	/*
	 * get Collection to insert candidate
	 */
	public static MongoCollection<Document> candidateCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseInsert.getCollection(GetValue.getCandidateInsertionCollection());

		return collection;
	}

	/*
	 * get Collection to insert candidate audit
	 */
	public static MongoCollection<Document> candidateAuditCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseInsert.getCollection(GetValue.getCandidateAuditInsertionCollection());

		return collection;
	}

	/*
	 * get collection to insert reference ids
	 */
	public static MongoCollection<Document> refernceIdCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseInsert.getCollection(GetValue.getReferenceIdInsertionCollection());

		return collection;
	}
	
	/*
	 * get Collection to fetch LinkedIn Candidates
	 */
	public static MongoCollection<Document> getLinkedInCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseInsert.getCollection(GetValue.getLinkedInGetMongoCollection());

		return collection;
	}

	/*
	 * get Collection to insert LinkedIn candidates
	 */
	public static MongoCollection<Document> insertLinkedInCollection() {

		com.mongodb.client.MongoCollection<Document> collection = null;

		collection = databaseInsert.getCollection(GetValue.getLinkedInMongoInsertionConnection());

		return collection;
	}

}
