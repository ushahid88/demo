package com.example.demo;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MergeHtml{
    public static void main(String[] args) throws IOException {
    	
    	        // Load the HTML file as a JSoup document
    	        File htmlFile = new File("D:\\RC-IIBtoACE-Report-Merge\\recommendations.html");
    	        Document document = Jsoup.parse(htmlFile, "UTF-8");

    	        // Get the body element of the document
    	        Element body = document.body();

    	        // Get all elements in the body element
    	        Elements elements = body.getAllElements();

    	        // Print out the tag name of each element
    	        for (Element element : elements) {
    	            System.out.println(element.toString());
    	        }
    	    
    	

    }
}
