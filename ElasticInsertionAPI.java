package com.DataMigration.DB;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;

import com.amar.candidate.Candidate;

public class ElasticInsertionAPI {

	  static final Logger LOGGER = Logger.getLogger(ElasticInsertionAPI.class);
	
	public static void postData(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/Dynamic/");
			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";

			byte[] authbytes = Authentication.getBytes();
			byte[] base64authBytes = Base64.encodeBase64(authbytes);

			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
			post.addHeader("Authorization", "Basic " + base64Creds);
			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	public static void postDataLocal(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
//			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/Dynamic/");
			
			//HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/Candidate/");
			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/Candidate/");
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";

//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);

//			String base64Creds = new String(base64authBytes);

			//System.out.println("finaljson:::::::"+json);
			
			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");
			post.addHeader("token","eyJraWQiOiJNVjRUaWpMYW14MlFMaUJleEdWdTA2U29pcWU5RkRjZ2hycnVYMTNhZHNFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJlNmNmM2IwYS1iZDRiLTRkZDMtODYzZC01YWY5NDMwNjNjZmUiLCJldmVudF9pZCI6ImI2ZDQ1YmQwLWY0NjMtMTFlOC1iNmI1LTc1MzY3ZGZkMjM5NiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NDM1NTY5NzQsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfbjNxdHl5UHI3IiwiZXhwIjoxNTQzNTYwNTc0LCJpYXQiOjE1NDM1NTY5NzQsImp0aSI6IjUzMzJjZDZkLTFmNzEtNDBhNC1hMzczLWJhNTkzNWU1ZGNkMSIsImNsaWVudF9pZCI6Iml1c2VzYTFzZ2RiMjBydjdqbG9qdTd1b2siLCJ1c2VybmFtZSI6ImFtYXIifQ.H9TghpRm9loMPLHj6MBoORAx1vXbWylcPf_A1LA9fhwrBZ87lN-nO2fXg2dlEFhZIw2oUDKtn0yuwj134Y_vZPUittLRUoF2JzIUxEykR58LfgqRcaeUFobXeysIrQ8hjiTtNNmIVX5yPulMC66xVgzCeOnXx0BaE7x0ByxwCbfR471JAO-rWnmWwGTjzt_TeJWueRtkSzR_9wXTyQORwhbWsgmwncJ4_PNrLAJSR1Kw1So89a3hCnCrDytdBOQk4XGj4QPtNLopzqI3rCAzeoyHpczHZ1hXNOm5YfeBloqiOhcrx3V7xoZ9VDrhTLsmCp4C9e8xG0TKEKDvMHPNAQ");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	public static void postEmailBody_Data(String json,String id) throws ParseException {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
//			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/Dynamic/");
			
			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/EmailBody/");
			//https://jobs.globalhuntindia.com/api/Candidate/
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";

//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);

//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
			post.addHeader("token", "");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");

			post.setEntity(new StringEntity(json, "UTF-8"));

	      	 client.execute(post);
			 System.out.println("Inserted at : +"+LocalDateTime.now());
			 /*  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   System.out.println("Data Inserted by DRF API______"+dtf.format(now));  */
//			  LOGGER.info("Data Inserted by DRF API______"+dtf.format(now));
			   
			  /* SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			   Date date1 = format.parse(date);
			   Date date2 = format.parse(dtf.format(now));
			   long diff = date2.getTime() - date1.getTime(); 
			   
			   long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;*/
			   
		//	   System.out.println("Total Time Taken:::::::::::"+date);
//			   LOGGER.info("Total Time Taken:::::::::::"+diffHours+"H:"+diffMinutes+"M:"+diffSeconds+"S");
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();
			LOGGER.log(Level.ERROR, "Exception occur:" + id, e);

		}

	}
	
	
	
	
	
	public static void postCandidateData(String json,String date,String id) throws ParseException {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
//			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/Dynamic/");
			
			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/Candidate/");
			//https://jobs.globalhuntindia.com/api/Candidate/
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";

//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);

//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   System.out.println("Data Inserted by DRF API______"+dtf.format(now));  
//			  LOGGER.info("Data Inserted by DRF API______"+dtf.format(now));
			   
			   SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			   Date date1 = format.parse(date);
			   Date date2 = format.parse(dtf.format(now));
			   long diff = date2.getTime() - date1.getTime(); 
			   
			   long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
			   
			   System.out.println("Total Time Taken:::::::::::"+diffHours+"H:"+diffMinutes+"M:"+diffSeconds+"S");
//			   LOGGER.info("Total Time Taken:::::::::::"+diffHours+"H:"+diffMinutes+"M:"+diffSeconds+"S");
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();
			LOGGER.log(Level.ERROR, "Exception occur:" + id, e);

		}

	}
	
	public static void postCandidateAuditData(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/CandidateAudit/");
			 //"CandidateAudit": "https://jobs.globalhuntindia.com/api/CandidateAudit/",
			
			//https:// jobs.globalhuntindia.com/api/CandidateAudit/
			
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	public static void postCandidateAuditDataLocal(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			//HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/CandidateAudit/");
			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/CandidateAudit/");
			
			//https:// jobs.globalhuntindia.com/api/CandidateAudit/
			
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");
			post.addHeader("token","eyJraWQiOiJNVjRUaWpMYW14MlFMaUJleEdWdTA2U29pcWU5RkRjZ2hycnVYMTNhZHNFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJlNmNmM2IwYS1iZDRiLTRkZDMtODYzZC01YWY5NDMwNjNjZmUiLCJldmVudF9pZCI6ImI2ZDQ1YmQwLWY0NjMtMTFlOC1iNmI1LTc1MzY3ZGZkMjM5NiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NDM1NTY5NzQsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfbjNxdHl5UHI3IiwiZXhwIjoxNTQzNTYwNTc0LCJpYXQiOjE1NDM1NTY5NzQsImp0aSI6IjUzMzJjZDZkLTFmNzEtNDBhNC1hMzczLWJhNTkzNWU1ZGNkMSIsImNsaWVudF9pZCI6Iml1c2VzYTFzZ2RiMjBydjdqbG9qdTd1b2siLCJ1c2VybmFtZSI6ImFtYXIifQ.H9TghpRm9loMPLHj6MBoORAx1vXbWylcPf_A1LA9fhwrBZ87lN-nO2fXg2dlEFhZIw2oUDKtn0yuwj134Y_vZPUittLRUoF2JzIUxEykR58LfgqRcaeUFobXeysIrQ8hjiTtNNmIVX5yPulMC66xVgzCeOnXx0BaE7x0ByxwCbfR471JAO-rWnmWwGTjzt_TeJWueRtkSzR_9wXTyQORwhbWsgmwncJ4_PNrLAJSR1Kw1So89a3hCnCrDytdBOQk4XGj4QPtNLopzqI3rCAzeoyHpczHZ1hXNOm5YfeBloqiOhcrx3V7xoZ9VDrhTLsmCp4C9e8xG0TKEKDvMHPNAQ");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	public static void postAudioCallData(String json) {
//              System.out.println("Hi audio call!!!!!!!!!!");
		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			//https:// jobs.globalhuntindia.com/api/ Attached /
			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/AudioCall/");
			//HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/AudioCall/");
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");
            //post.addHeader("token", "eyJraWQiOiJNVjRUaWpMYW14MlFMaUJleEdWdTA2U29pcWU5RkRjZ2hycnVYMTNhZHNFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJlNmNmM2IwYS1iZDRiLTRkZDMtODYzZC01YWY5NDMwNjNjZmUiLCJldmVudF9pZCI6IjlhY2ExNTdjLTA3NmYtMTFlOS04NDNiLTRiYmQzNDUwYzJmNiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NDU2NTExNTMsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfbjNxdHl5UHI3IiwiZXhwIjoxNTQ1NjU0NzUzLCJpYXQiOjE1NDU2NTExNTMsImp0aSI6IjY0MmE5YmI4LTk5NmEtNDY5My1hNWY2LTFjOGRjYmQxZDU2NCIsImNsaWVudF9pZCI6Iml1c2VzYTFzZ2RiMjBydjdqbG9qdTd1b2siLCJ1c2VybmFtZSI6ImFtYXIifQ.agPNgc-k_NCZF0-ENYkrzDoLm-pkL4pEff4ijZbtIh93F4fkomJ3n2Ta5OloKcd2STyGIN7_Lgee1HmhOKfaUdIkhUfZBh4RG2aUaI4RzJnriv6kpj30Popmokz2brKW_-T1mQ8hQdThMcJePyX8OHNX8Do8KVg4n1FtL9D7Mi5kXCEblyp2p6s_znzTwby2RkuZOAe33iC5Q_bqTMXF8ZRaUNnH-Uyn3qIBsqfs4ctGM9XgCH51uTfQb9CVBNJLv0tyFf2Qv6WNHQ3z6ggYmJO8wwBrgVTwYS7uRWrzrux3E1FkXJwdae0dedZ0Us7RFXdKAUloksIuTXUpGcBPeA");
			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	
	
	
	public static void postAttachData(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			//https:// jobs.globalhuntindia.com/api/ Attached /
			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/Attached/");
			
			
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	public static void postTemplateData(String json) {

		try {

			
			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			//https:// jobs.globalhuntindia.com/api/ Attached /
			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/Template/");
//			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/Template/");
			
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");
//			post.addHeader("token","eyJraWQiOiJNVjRUaWpMYW14MlFMaUJleEdWdTA2U29pcWU5RkRjZ2hycnVYMTNhZHNFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1ZWVmYmUxMy1hOTFhLTQ3NzYtYjQ5Yy1jNjRhOTU2OTU1MGIiLCJldmVudF9pZCI6ImQxOWU4MzAyLTA0NGQtMTFlOS04OGIxLTg5NDlhMTYwY2JiYiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NDUzMDY3ODgsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfbjNxdHl5UHI3IiwiZXhwIjoxNTQ1MzEwMzg4LCJpYXQiOjE1NDUzMDY3ODgsImp0aSI6IjU5MDM4NmI2LWI3MDYtNGYwNS04ZjNiLThiYWY0ZGExMDYwNyIsImNsaWVudF9pZCI6IjgzNnNpamZxODBqNmZhNTdhZnJhaHRhNzQiLCJ1c2VybmFtZSI6InJhc2htaSJ9.eP20tegMkwzMgdk1N3IUEwE6GcsN8OyajD9hiU5eBsG7Afffqp1B6Px8Ts5s-vROPEs3XhPuQDCzS31iOAfa4hY1D0PRO1Ky_e12wGNR_BqsSt97Au8EDmzdtZSrrEUxvQsMihOgWrh8QFLGvl8dat9W9gNklkECNuHqHylo-b7rMGlhqwyw--qFM6h25GzHglRz1MP3j2hkLOea30LIoVf-d7yBwmxaSQKlWga3IGcgS4VbSvR5v1GPU3DA34q4wvAndHZCsD_iG3aZYccO2IR0w0WJVe6W_am7B5oUhXjYo-Cby8BGO98twsL076tiVVdGx3tKvOVc_Jf_zsEYOw");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	public static void postDocumentDataLive(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			//https:// jobs.globalhuntindia.com/api/ Attached /
//			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/Template/");
		    //"CRMDocument": "https://jobs.globalhuntindia.com/api/CRMDocument/",
			//HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/CRMDocument/");
			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/CRMDocument/");
			
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");
			//post.addHeader("token","eyJraWQiOiJNVjRUaWpMYW14MlFMaUJleEdWdTA2U29pcWU5RkRjZ2hycnVYMTNhZHNFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1ZWVmYmUxMy1hOTFhLTQ3NzYtYjQ5Yy1jNjRhOTU2OTU1MGIiLCJldmVudF9pZCI6IjFjZDYzYjJkLTA0NGYtMTFlOS05OWE2LWQzOTFjMDlhNTM3NiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NDUzMDczNDQsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfbjNxdHl5UHI3IiwiZXhwIjoxNTQ1MzEwOTQ0LCJpYXQiOjE1NDUzMDczNDQsImp0aSI6IjkxOGJlN2JmLWVlODItNDAxMy1iMzUxLTYxNTM2OGU3YzdmMSIsImNsaWVudF9pZCI6IjgzNnNpamZxODBqNmZhNTdhZnJhaHRhNzQiLCJ1c2VybmFtZSI6InJhc2htaSJ9.Qanb36pAR2qOlVVOxqdXYePAbzBaz_f2odQcPyyksIykfP1dWttSKA9Xff7tC1x7_vCzHYp7eylULqAbLkg4FC26CuJHKuDV2ikjQrn9v8_sFHSMSGFmANPDgwkBWb76G3XwC50A60Q2ADL6EPIgkLV748_0y2-ywJPam7PRD5maUkNvqBy80vCzuQCij66erwVjOEZ-QNn5Ph4FPhqfvGzDiI9jgBgS6kl4t8p1VTQZCLzlSVfgRHJL9vo6Jp2gnusnoPYCDJ-C9QuQYzZ4m3cUUCsbut1MK81DoJ-XRzcznMX1gJaFR5awqRltB-UHP0-N5LcRQOWSYjqZXxEiBw");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	
	
	public static void postDocumentData(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			//https:// jobs.globalhuntindia.com/api/ Attached /
//			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/Template/");
			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/CRMDocument/");
			
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");
			post.addHeader("token","eyJraWQiOiJNVjRUaWpMYW14MlFMaUJleEdWdTA2U29pcWU5RkRjZ2hycnVYMTNhZHNFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1ZWVmYmUxMy1hOTFhLTQ3NzYtYjQ5Yy1jNjRhOTU2OTU1MGIiLCJldmVudF9pZCI6IjFjZDYzYjJkLTA0NGYtMTFlOS05OWE2LWQzOTFjMDlhNTM3NiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NDUzMDczNDQsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfbjNxdHl5UHI3IiwiZXhwIjoxNTQ1MzEwOTQ0LCJpYXQiOjE1NDUzMDczNDQsImp0aSI6IjkxOGJlN2JmLWVlODItNDAxMy1iMzUxLTYxNTM2OGU3YzdmMSIsImNsaWVudF9pZCI6IjgzNnNpamZxODBqNmZhNTdhZnJhaHRhNzQiLCJ1c2VybmFtZSI6InJhc2htaSJ9.Qanb36pAR2qOlVVOxqdXYePAbzBaz_f2odQcPyyksIykfP1dWttSKA9Xff7tC1x7_vCzHYp7eylULqAbLkg4FC26CuJHKuDV2ikjQrn9v8_sFHSMSGFmANPDgwkBWb76G3XwC50A60Q2ADL6EPIgkLV748_0y2-ywJPam7PRD5maUkNvqBy80vCzuQCij66erwVjOEZ-QNn5Ph4FPhqfvGzDiI9jgBgS6kl4t8p1VTQZCLzlSVfgRHJL9vo6Jp2gnusnoPYCDJ-C9QuQYzZ4m3cUUCsbut1MK81DoJ-XRzcznMX1gJaFR5awqRltB-UHP0-N5LcRQOWSYjqZXxEiBw");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	public static void postAttachDataLocal(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			//https:// jobs.globalhuntindia.com/api/ Attached /
			//HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/Attached/");
			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/Attached/");
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");
			post.addHeader("token","eyJraWQiOiJNVjRUaWpMYW14MlFMaUJleEdWdTA2U29pcWU5RkRjZ2hycnVYMTNhZHNFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJlNmNmM2IwYS1iZDRiLTRkZDMtODYzZC01YWY5NDMwNjNjZmUiLCJldmVudF9pZCI6ImI2ZDQ1YmQwLWY0NjMtMTFlOC1iNmI1LTc1MzY3ZGZkMjM5NiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NDM1NTY5NzQsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfbjNxdHl5UHI3IiwiZXhwIjoxNTQzNTYwNTc0LCJpYXQiOjE1NDM1NTY5NzQsImp0aSI6IjUzMzJjZDZkLTFmNzEtNDBhNC1hMzczLWJhNTkzNWU1ZGNkMSIsImNsaWVudF9pZCI6Iml1c2VzYTFzZ2RiMjBydjdqbG9qdTd1b2siLCJ1c2VybmFtZSI6ImFtYXIifQ.H9TghpRm9loMPLHj6MBoORAx1vXbWylcPf_A1LA9fhwrBZ87lN-nO2fXg2dlEFhZIw2oUDKtn0yuwj134Y_vZPUittLRUoF2JzIUxEykR58LfgqRcaeUFobXeysIrQ8hjiTtNNmIVX5yPulMC66xVgzCeOnXx0BaE7x0ByxwCbfR471JAO-rWnmWwGTjzt_TeJWueRtkSzR_9wXTyQORwhbWsgmwncJ4_PNrLAJSR1Kw1So89a3hCnCrDytdBOQk4XGj4QPtNLopzqI3rCAzeoyHpczHZ1hXNOm5YfeBloqiOhcrx3V7xoZ9VDrhTLsmCp4C9e8xG0TKEKDvMHPNAQ");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	public static void postAttachAuditData(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/AttachedAudit/");
			                             // https://jobs.globalhuntindia.com/api/AttachedAudit/",
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//https:// jobs.globalhuntindia.com/api/AttachAudit/
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	public static void postAttachAuditDataLocal(String json) {

		try {

			Properties prop = new Properties();
			String filepath = "/GetDBConnection.properties";
			InputStream input = null;
			input = GetValue.class.getResourceAsStream(filepath);
			prop.load(input);
			System.setProperty("javax.net.ssl.trustStore", prop.getProperty("ssl"));
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			HttpClient client = HttpClientBuilder.create().build();
			//HttpPost post = new HttpPost("https://jobs.globalhuntindia.com/api/AttachAudit/");
			HttpPost post = new HttpPost("https://awsdev.globalhuntindia.com/api/AttachAudit/");
//			String Authentication = "Alexa@Atlas8:AWS@Gl0balhunt";
//https:// jobs.globalhuntindia.com/api/AttachAudit/
//			byte[] authbytes = Authentication.getBytes();
//			byte[] base64authBytes = Base64.encodeBase64(authbytes);
//
//			String base64Creds = new String(base64authBytes);

			post.addHeader("Content-Type", "application/json");
//			post.addHeader("Authorization", "Basic " + base64Creds);
//			post.addHeader("Alexa@Atlas8", "AWS@Gl0balhunt");
			post.addHeader("token","eyJraWQiOiJNVjRUaWpMYW14MlFMaUJleEdWdTA2U29pcWU5RkRjZ2hycnVYMTNhZHNFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJlNmNmM2IwYS1iZDRiLTRkZDMtODYzZC01YWY5NDMwNjNjZmUiLCJldmVudF9pZCI6ImI2ZDQ1YmQwLWY0NjMtMTFlOC1iNmI1LTc1MzY3ZGZkMjM5NiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1NDM1NTY5NzQsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aC0xLmFtYXpvbmF3cy5jb21cL2FwLXNvdXRoLTFfbjNxdHl5UHI3IiwiZXhwIjoxNTQzNTYwNTc0LCJpYXQiOjE1NDM1NTY5NzQsImp0aSI6IjUzMzJjZDZkLTFmNzEtNDBhNC1hMzczLWJhNTkzNWU1ZGNkMSIsImNsaWVudF9pZCI6Iml1c2VzYTFzZ2RiMjBydjdqbG9qdTd1b2siLCJ1c2VybmFtZSI6ImFtYXIifQ.H9TghpRm9loMPLHj6MBoORAx1vXbWylcPf_A1LA9fhwrBZ87lN-nO2fXg2dlEFhZIw2oUDKtn0yuwj134Y_vZPUittLRUoF2JzIUxEykR58LfgqRcaeUFobXeysIrQ8hjiTtNNmIVX5yPulMC66xVgzCeOnXx0BaE7x0ByxwCbfR471JAO-rWnmWwGTjzt_TeJWueRtkSzR_9wXTyQORwhbWsgmwncJ4_PNrLAJSR1Kw1So89a3hCnCrDytdBOQk4XGj4QPtNLopzqI3rCAzeoyHpczHZ1hXNOm5YfeBloqiOhcrx3V7xoZ9VDrhTLsmCp4C9e8xG0TKEKDvMHPNAQ");

			post.setEntity(new StringEntity(json, "UTF-8"));

			client.execute(post);
			
//			HttpResponse response = client.execute(post);
//			System.out.println("response...."+response.toString());

		} catch (IOException e)

		{
			e.printStackTrace();

		}

	}
	
	
	
	
}
