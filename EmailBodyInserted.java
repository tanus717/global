package com.amar.email_body;

import java.text.ParseException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.DataMigration.DB.ElasticInsertionAPI;
import com.DataMigration.DB.MongoConnections;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class EmailBodyInserted {
	 static final Logger LOGGER = Logger.getLogger(EmailBodyInserted.class);
	static MongoCollection<Document> collection = MongoConnections.getInsertEmailBody_Collection();
	static DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
	static DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public static void main(String[] args) throws JSONException {

	//	ObjectId fromId = new ObjectId("5aaa10483b3cea12509ec947");
		ObjectId fromId = new ObjectId("5aaa11463b3cea12509ec9aa");
		inserted(fromId);
	}

	public static void inserted(ObjectId fromId) throws JSONException {
		BasicDBObject query = new BasicDBObject();
		FindIterable<Document> document = null;

		if (fromId != null) {
			query.put("_id", new BasicDBObject("$gt", fromId));
			document = collection.find(query).sort(new BasicDBObject("_id", 1)).limit(100);
		} else {
			document = collection.find().sort(new BasicDBObject("_id", 1)).limit(100);
		}
		for (Document doc : document) {
			String id = "" + doc.get("_id");

			JSONObject insertjson = new JSONObject(doc.toJson());
			insertjson.put("id", id);

			if (doc.get("createdDate") != null && !doc.get("createdDate").equals("")) {
				final ZonedDateTime parsed = ZonedDateTime.parse("" + doc.get("createdDate"), inputFormat);
				insertjson.put("createdDate", outputFormat.format(parsed));
			}
			if (doc.get("modifiedDate") != null && !doc.get("modifiedDate").equals("")) {
				final ZonedDateTime parsed = ZonedDateTime.parse("" + doc.get("modifiedDate"), inputFormat);
				insertjson.put("modifiedDate", outputFormat.format(parsed));
			}
			try {
				ElasticInsertionAPI.postEmailBody_Data(insertjson.toString(), doc.get("_id").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
            System.out.println("Id Inserted : "+fromId);
            LOGGER.info("Id Inserted : "+fromId);
			fromId = (ObjectId) doc.get("_id");
		}
		if (fromId != null) {
			inserted(fromId);
		}
	}
}
