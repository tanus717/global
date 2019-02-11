package com.amar.email_body;

import java.io.FileWriter;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONException;

import org.springframework.web.client.RestTemplate;

import com.DataMigration.DB.ElasticInsertionAPI;
import com.DataMigration.DB.GetValue;
import com.DataMigration.DB.MongoConnections;
//import com.amar.candidate.InsertCandidate;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;

public class InsertEmail_Body {
	
	static final Logger LOGGER = Logger.getLogger(InsertEmail_Body.class);
	
	public static void InsertEmail_Body_Data(ObjectId objectId) throws ParseException{
    
		RestTemplate restTemplate = new RestTemplate();
		
	try {
		MongoCollection<Document> collection = MongoConnections.getEmail_BodyCollection();

		BasicDBObject query = new BasicDBObject();
//		query.put("objectId", objectId.toString());
		query.put("_id", objectId);

		FindIterable<Document> document = collection.find(query);

		for (Document doc : document) {

			//String json = com.mongodb.util.JSON.serialize(doc).trim();
//			JSONObject insertjson = new JSONObject(json);
			//JSONObject insertjson = new JSONObject(doc.toJson());
			
			//System.out.println("insertjson::::"+insertjson);
			String lastModified = "";
			String createdDate = "";
			
			doc.remove("_id");
			
			
			
			
			/*insertjson.remove("_id");
			insertjson.remove("modifiedUserId");
			insertjson.remove("createdBy");
			insertjson.remove("createdUserId");*/
		    doc.append("_id", objectId);
		    
			//insertjson.put("id", ""+doc.get("_id"));
		
			if(doc.get("createdUserId") != null){
			   String createdById=(String) doc.get("createdUserId");
			   if(createdById.length()==36){
				  // System.out.println("Hiiiiiii");
	                    String APIurl = GetValue.getHitechURLapi()+"/api/CandidateViews/GetUserNameOnUserId?userid="+createdById;
					    String output= restTemplate.getForObject(APIurl, String.class);
						output = output.replace("\"", "");
					    System.out.println(output);
						doc.put("createdBy",output);
						
					
			   }else{
				    doc.put("createdBy",doc.get("createdUserId"));
				   //insertjson.put("createdBy", "" + doc.get("createdUserId"));
			   }
				
			  
			 }
			 doc.remove("createdUserId");
			 doc.remove("modifiedUserId");
			
			
			//String cvSentDate = "";
			
			// added by amar
			
			/*if(insertjson.has("resume")){
				  
//				 System.out.println("resumeeee::::"+insertjson.get("resume"));
				
				 JSONObject resume = new JSONObject();
				 
				 resume = (JSONObject) insertjson.get("resume");
				 
				 //System.out.println("jsonn:::--------:::::"+resume.get("$binary"));
				 
				 insertjson.put("resume",resume.get("$binary"));
				
			}*/
			 
			if(doc.containsKey("modifiedDate")){
				if(!doc.get("modifiedDate").equals("")&&doc.get("modifiedDate")!=null)
				{
				String format=DateFormat.getFormat(doc.getString("modifiedDate"));
                doc.append("modifiedDate", Date.from(Instant.parse(format)));
				//Instant.parse(format)
				System.out.println(doc.get("modifiedDate"));}
				else {
					doc.remove("modifiedDate");
				}
				
				/*String format=DateFormat.getFormat(doc.getString("modifiedDate"));
				System.out.println("format : "+format);
				BasicDBObject tem= new BasicDBObject("date", Instant.parse(format));
				doc.put("modifiedDate",Instant.parse(format));
				System.out.println(doc.get("modifiedDate"));
				doc.put("modifiedDate",ISODateTimeFormat(Instant.parse(format)));
				System.out.println(doc.get("modifiedDate"));*/
				 //Instant.ofEpochMilli
				//insertjson.put("modifiedDate", dateFormater(lastModified,"yyyy-MM-dd'T'HH:mm:ss.000'Z'","yyyy-MM-dd HH:mm:ss", lastModified, doc.get("_id").toString()));
			}
			
			 if(doc.containsKey("createdDate")){
				 if(!doc.get("createdDate").equals("")&&doc.get("createdDate")!=null)
					{
				 String format=DateFormat.getFormat(doc.getString("createdDate"));
					
				 doc.put("createdDate",Date.from(Instant.parse(format)));
					}
				 else {
						doc.remove("createdDate");
					}
				 
				 
//	            createdDate = insertjson.getString("createdDate");
//				insertjson.put("createdDate", dateFormater(createdDate,"yyyy-MM-dd'T'HH:mm:ss.000'Z'","yyyy-MM-dd HH:mm:ss", createdDate, doc.get("_id").toString()));
			} 
			
			/*if(insertjson.has("statusChangeDate")){
				statusChangeDate = insertjson.getString("statusChangeDate");
				insertjson.put("statusChangeDate", dateFormater(statusChangeDate,"yyyy-MM-dd'T'HH:mm:ss.000'Z'","yyyy-MM-dd HH:mm:ss"));
			}
			
			if(insertjson.has("cvSentDate")){
				cvSentDate = insertjson.getString("cvSentDate");
				insertjson.put("cvSentDate", dateFormater(cvSentDate,"yyyy-MM-dd'T'HH:mm:ss.000'Z'","yyyy-MM-dd HH:mm:ss"));
			}*/
			
			//comented by amar
			//insertjson.put("collection_index", GetConnections.getElasticAttachCollection());

			//System.out.println("insertjson:::" + doc.get("createdDate"));

			//ElasticInsertionAPI.postData(insertjson.toString());
			
			//ElasticInsertionAPI.postAttachData(insertjson.toString());
			/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            System.out.println("Data passed to DRF API______"+dtf.format(now));*/
//			 MongoCollection<Document> collectiontest = GetConnection2.getLiveConnectionEmailBody(); 
			 MongoCollection<Document> insertcollection = MongoConnections.getInsertEmailBody_Collection();
			// System.out.println(doc);
			
			 insertcollection.insertOne(doc);
			 wirteEmail(objectId.toString(), "D:\\sucess.txt");
			 
			 //DBObject obj = (DBObject) JSON.parse("insertjson");
			 
			 
         //   ElasticInsertionAPI.postEmailBody_Data(insertjson.toString(), dtf.format(now),  doc.get("_id").toString());
			

		}
	} catch (Exception e) {
		e.printStackTrace();
		//LOGGER.info("ERROR ID:::::::::::"+objectId);
		wirteEmail(objectId.toString(), "D:\\error.txt");
		System.out.println("working");
		//LOGGER.log(Level.ERROR, "Exception occur"+e.getMessage());
	}

	}

	/*private static Object ISODateTimeFormat(Instant parse) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
/*	public static String dateFormater(String dateFromJSON, String expectedFormat, String oldFormat,String fieldname,String id) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
	    Date date = null;
	    String convertedDate = null;
	    try {
	        date = dateFormat.parse(dateFromJSON);
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(expectedFormat);
	        convertedDate = simpleDateFormat.format(date);
	        
//	        System.out.println("convertedDate::::"+convertedDate);
	        
	    } catch (Exception e) {
	    	 e.printStackTrace();
		     LOGGER.log(Level.ERROR, "Exception occur:" + fieldname + "  " + id, e);
	    }

	    return convertedDate;
	}*/
	public static void wirteEmail(String ObjectId,String file) {
		try {
//			FileWriter fw = new FileWriter("E:\\DataMigration_22-11-2018(3).txt", true);
			FileWriter fw = new FileWriter(file, true);
			fw.write("$oid:::___" +ObjectId+"\r\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
