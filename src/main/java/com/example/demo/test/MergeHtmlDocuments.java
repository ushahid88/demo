package com.example.demo.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MergeHtmlDocuments {
    public static void main(String[] args) throws IOException {
        // Load the first HTML document and extract the style tag
    	String firstFile ="D:\\RC-IIBtoACE-Report-Merge\\recommendations.html";
    	String secondFile = "D:\\RC-IIBtoACE-Report-Merge\\recommendations2.html";
    	String thirdFile = "D:\\RC-IIBtoACE-Report-Merge\\recommendations1.html";
        File firstHtmlFile = new File(firstFile);
        Document firstHtmlDoc = Jsoup.parse(firstHtmlFile, "UTF-8");
        Element styleTag = firstHtmlDoc.head().selectFirst("style");

        // Create a new merged HTML document with the style tag and a new body tag
        Document mergedHtmlDoc = Document.createShell("");
        mergedHtmlDoc.head().appendChild(styleTag.clone());
        Element mergedBody = mergedHtmlDoc.createElement("body");
        mergedHtmlDoc.body().appendChild(mergedBody);

        // Load and merge all the body tags from the HTML documents
        File[] htmlFiles = {new File(firstFile),new File(secondFile),new File(thirdFile)};
        for (File htmlFile : htmlFiles) {
            Document htmlDoc = Jsoup.parse(htmlFile, "UTF-8");
            Element body = htmlDoc.body();
            for (Element child : body.children()) {
                mergedBody.appendChild(child.clone());
            }
        }

        // Write the merged HTML document to a file
        File mergedHtmlFile = new File("D:\\mergeee.html");
        FileWriter writer = new FileWriter(mergedHtmlFile);
        writer.write(mergedHtmlDoc.html());
        writer.close();
    }
}

