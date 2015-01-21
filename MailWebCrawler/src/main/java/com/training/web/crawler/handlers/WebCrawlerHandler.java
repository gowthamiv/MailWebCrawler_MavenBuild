package com.training.web.crawler.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class WebCrawlerHandler {
	
	public static final String MainURLString = "http://mail-archives.apache.org/mod_mbox/maven-users/";
	public static final int year = 2014;

	public static void downloadMails(){
		Map<String, Boolean> urlMap = new LinkedHashMap<String, Boolean>();
		urlMap.put(MainURLString, true);
		try {
			URL url = new URL(MainURLString);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = null;
			String entirePage = "";
			while((line=bufferedReader.readLine())!=null){
				entirePage += line;
			}
			entirePage = entirePage.replaceAll("\\s+", " ");
			System.out.println(entirePage);
			String[] stringArray = entirePage.split("<a href=\"");
			for(String string : stringArray){
				int temp = string.indexOf("\"");
				urlMap.put(string.substring(0, temp), false);
				System.out.println(string.substring(0, temp));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void crawlUrls(String singlePage){
		
	}
	
	public static void crawlMails(){
		
	}*/
}
