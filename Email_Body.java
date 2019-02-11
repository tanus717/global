package com.amar.email_body;

import java.io.FileWriter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.DataMigration.DB.MongoConnections;
import com.amar.attach.InsertAttached;
import com.amar.candidateaudit.InsertCandidateAudit;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class Email_Body {

	static String file = "E:\\Email_Body_11-02-2019.txt";
	static Logger LOGGER = Logger.getLogger(Email_Body.class.getName());
	public static void main(String[] args) {
	
		/*_id:::5b811f7b3b3ce9298060b3a2
		Data passed to DRF API______2019/01/23 10:40:50
		Data Inserted by DRF API______2019/01/23 10:41:02
		Total Time Taken:::::::::::0H:0M:12S
		_id:::5b811f823b3ce9298060b3a3
		Data passed to DRF API______2019/01/23 10:41:02
		Data Inserted by DRF API______2019/01/23 10:41:18
		Total Time Taken:::::::::::0H:0M:16S
		_id:::5b811f883b3ce9298060b3a4
		Data passed to DRF API______2019/01/23 10:41:18
		Data Inserted by DRF API______2019/01/23 10:41:25
		Total Time Taken:::::::::::0H:0M:7S
		_id:::5b811f8d3b3ce9298060b3a5
		Data passed to DRF API______2019/01/23 10:41:25
		Data Inserted by DRF API______2019/01/23 10:41:39
		Total Time Taken:::::::::::0H:0M:14S
		_id:::5b811f943b3ce9298060b3a6
		Data passed to DRF API______2019/01/23 10:41:39
		Data Inserted by DRF API______2019/01/23 10:41:46
		Total Time Taken:::::::::::0H:0M:7S
		_id:::5b811f9a3b3ce9298060b3a7
		Data passed to DRF API______2019/01/23 10:41:46*/
//		String fromid  = "5aa8f72ec0237a2f9fac5083";
//		String fromid  = "5b811f8d3b3ce9298060b3a5";
		String fromid  = "5aa8f72ec0237a2f9fac5083";
		String toid = "amar";
			
			String Object_Id = "blank_id";
			
//			String ObjectId = "";
			ObjectId id = new ObjectId();
			try {
				
//				int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
				/*String textUri = "mongodb://Hitech:role!123@ganga/CandidateDB";
				uri = new MongoClientURI(textUri);
				final MongoClient mongoClient = new MongoClient(uri);
				db = mongoClient.getDatabase("CandidateDB");
				collection = db.getCollection("DynamicCandidateAudit");*/

				MongoCollection<Document> collection = MongoConnections.getEmail_BodyCollection();
				
				//ObjectId id = new ObjectId();
				
				ObjectId id1 = new ObjectId(fromid);
				
				/*Document document_id = new Document();
				document_id.append("_id", id1);
				String a = "";*/
				
				/*while (!fromdate.equals(todate)) {

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date dateFrom = dateFormat.parse(fromdate);

					String firstDate = dateFormat.format(dateFrom.getTime() + MILLIS_IN_DAY);*/
	                String next="";
				
				
					do {
						
						BasicDBObject query = new BasicDBObject();
						//query.put("lastUpdated", new BasicDBObject("$gte", fromdate).append("$lte", firstDate));
	            
						
						if(next.equals("done")){
							query.put("_id", new BasicDBObject("$gt", id1));
							
						}else{
							query.put("_id", new BasicDBObject("$gte", id1));
						}
					    
						next="done";
						
//						id1 = (ObjectId) document_id.get("_id");
//						query.put("_id", new BasicDBObject("$lte",id1));
						
						
//					    query.put("email", new BasicDBObject("$lt","lalithavishu@rediffmail.com"));
						
						/*if(a.equals("")){
							
							id1 = (ObjectId) document_id.get("_id");
							query.put("_id", new BasicDBObject("$lt",id1));
						}
						a="amar";*/
						
						//query.put("_id", new BasicDBObject("$lt","iddddd"));
						 
						/*if (!ObjectId.equals("blank_Id")){
							query.put("_id", new BasicDBObject("$lt", id));
						}*/
							
						System.out.println(query);
						
						// FindIterable<Document> document =collection.find(query).sort(new BasicDBObject("email", -1))
						FindIterable<Document> document = collection.find(query).sort(new BasicDBObject("_id", 1)).limit(1);
//						ObjectId = "blank_Id";
						
						for (Document doc : document) {
							
//							ObjectId = doc.getString("objectID");
							
							id = (ObjectId) doc.get("_id");
						       
							//wirteEmail(x);
							
							System.out.println("_id:::" + doc.get("_id"));
							
							InsertEmail_Body.InsertEmail_Body_Data(id);
							
							
							
							
						}
						
						id1=id;
						
					} while (!toid.equals(id.toString()));

					//fromdate = firstDate;
				//}

//				mongoClient.close();
				// }
			} catch (Exception e) {
				
				e.printStackTrace();
				//LOGGER.info(mQuery);
				//wirteEmail1(email, id);
				//LOGGER.info("ERROR ID:::::"+id);
				//LOGGER.log(Level.ERROR, "Exception occur", e);
				// LOGGER.log(Level.ERROR, "Exception occur", e);
				// LOGGER.log(Level.ERROR, "Could not access to the server due to {}, try {}/{}", 
				           // new Object[]{e.getMessage(), i, maxTries}
//				LOGGER.error(e.getMessage());
			}
		
        
		
	}
	
	public static void wirteEmail(String ObjectId) {
		try {
//			FileWriter fw = new FileWriter("E:\\DataMigration_22-11-2018(3).txt", true);
			FileWriter fw = new FileWriter(file, true);
			fw.write("id:::___" +ObjectId+"\r\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
