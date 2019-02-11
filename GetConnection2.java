package com.amar.email_body;



import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GetConnection2 {
private static MongoClient mongoClient;



public static  MongoCollection<Document> getConnectionEmailBody()
{
	  String textUri =  "mongodb://Candidate:candi!123@192.168.1.240:27017/CandidateDB";//GetProperties.getUrlAPI(server);
      MongoClientURI uri = new MongoClientURI(textUri);
      mongoClient = new MongoClient(uri);
      MongoDatabase db = mongoClient.getDatabase( "CandidateDB"/*GetProperties.getmongoDb(database)*/);
      MongoCollection<Document> mongocollection = db.getCollection( "EmailBodyTest"/*GetProperties.getCollection(collection)*/);
	return mongocollection;
}

public static  MongoCollection<Document> getLiveConnectionEmailBody()
{
	  String textUri =  "mongodb://Candidate:candi!123@192.168.1.240:27017/CandidateDB";//GetProperties.getUrlAPI(server);
      MongoClientURI uri = new MongoClientURI(textUri);
      mongoClient = new MongoClient(uri);
      MongoDatabase db = mongoClient.getDatabase( "CandidateDB"/*GetProperties.getmongoDb(database)*/);
      MongoCollection<Document> mongocollection = db.getCollection( "EmailBodyTest"/*GetProperties.getCollection(collection)*/);
	return mongocollection;
}

}
