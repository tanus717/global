package com.DataMigration.DB;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

public class ElasticInsertion {

	public static void insertIntoElastic(String id, String insertjson, String collectionName) {
		try {

			String Rooturl = "https://search-hitech-tuxhxhzzt4sw2d5sak3l6e2mny.ap-south-1.es.amazonaws.com";
			URL url = new URL(Rooturl);
			URI UOrig = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(),
					url.getQuery(), null);

			RestClient restClient = RestClient.builder(new HttpHost(UOrig.getHost(), 80))
					.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
						public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder arg0) {
							return arg0.disableAuthCaching();
						}
					}).build();

			HttpEntity entity = new NStringEntity(insertjson, ContentType.APPLICATION_JSON);
			Response indexResponse = restClient.performRequest("PUT", "/" + collectionName + "/doc/" + id + "",
					Collections.<String, String>emptyMap(), entity);
			EntityUtils.toString(indexResponse.getEntity());

			restClient.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
