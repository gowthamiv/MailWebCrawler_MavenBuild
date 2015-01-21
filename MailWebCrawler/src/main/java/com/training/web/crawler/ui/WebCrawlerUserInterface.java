package com.training.web.crawler.ui;

import com.training.web.crawler.handlers.WebCrawlerHandler;

public class WebCrawlerUserInterface {

	public static void main(String[] args) {
		System.out.println("This is a Web Crawler for Downloading mails");
		
		//Call to the crawler handler
		WebCrawlerHandler.downloadMails();
	}

}
