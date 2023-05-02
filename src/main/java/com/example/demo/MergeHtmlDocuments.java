package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class MergeHtmlDocuments {
    public static void main(String[] args) throws IOException {
    	String firstFile ="D:\\RC-IIBtoACE-Report-Merge\\recommendations.html";
    	String secondFile = "D:\\RC-IIBtoACE-Report-Merge\\recommendations2.html";
        // Load the first HTML document and extract the style tag
		/*
		 * File firstHtmlFile = new File(firstFile); Document firstHtmlDoc =
		 * Jsoup.parse(firstHtmlFile, "UTF-8"); Element styleTag =
		 * firstHtmlDoc.head().selectFirst("style");
		 * 
		 * // Create a new merged HTML document with the style tag Document
		 * mergedHtmlDoc = Document.createShell("");
		 * mergedHtmlDoc.head().appendChild(styleTag.clone());
		 * 
		 * // Load and merge all the body tags from the HTML documents File[] htmlFiles
		 * = {new File(firstFile), new File(secondFile)}; for (File htmlFile :
		 * htmlFiles) { Document htmlDoc = Jsoup.parse(htmlFile, "UTF-8"); Element body
		 * = htmlDoc.body().clone(); mergedHtmlDoc.body().appendChild(body); }
		 * 
		 * // Write the merged HTML document to a file File mergedHtmlFile = new
		 * File("D:\\merged.html"); FileWriter writer = new FileWriter(mergedHtmlFile);
		 * writer.write(mergedHtmlDoc.html()); writer.close();
		 */
    	
    	/*File inputHTML = new File(HTML);
    	Document document = Jsoup.parse(inputHTML, "UTF-8");
    	document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
    	try (OutputStream outputStream = new FileOutputStream(outputPdf)) {
    	    ITextRenderer renderer = new ITextRenderer();
    	    SharedContext sharedContext = renderer.getSharedContext();
    	    sharedContext.setPrint(true);
    	    sharedContext.setInteractive(false);
    	    renderer.setDocumentFromString(xhtml.html());
    	    renderer.layout();
    	    renderer.createPDF(outputStream);*/
    	//}
    	
    	try {
    		//HtmlToPdf.coverUsingFlyingSaucer(firstFile, "D:\\output.pdf");
    		
    		HtmlToPdf.convertUsingSeleium(firstFile, "D:\\output.pdf");
    	}catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    }
}

