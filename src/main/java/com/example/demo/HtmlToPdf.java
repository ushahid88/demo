package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.PdfWriter;

public class HtmlToPdf {
	public static void convert(String inputHtmlPath, String outputPdfPath) throws Exception {
        Document document = new Document(PageSize.A4);
        OutputStream outputStream = new FileOutputStream(outputPdfPath);
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        FileInputStream inputStream = new FileInputStream(inputHtmlPath);
        InputStreamReader reader = new InputStreamReader(inputStream);
        HTMLWorker worker = new HTMLWorker(document);
        worker.parse(reader);
        document.close();
        writer.close();
        outputStream.close();
    }
	
	public static void convertUsingBrowser(String url, String outputPdfPath) throws Exception {
        // Create a new WebDriver instance using ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.navigate().to(url);

        // Set the page size to A4
        Document document = new Document(PageSize.A4);

        // Create a new PDF file
        FileOutputStream outputStream = new FileOutputStream(outputPdfPath);
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);

        // Open the document
        document.open();
        StyleSheet styleSheet = null;

        // Add the visible portion of the HTML page to the document
        driver.findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        driver.findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        driver.findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        document.add(new com.itextpdf.text.html.simpleparser.HTMLWorker(document).parseToList(new StringReader(driver.getPageSource()),styleSheet).get(0));

        // Close the document and the PDF writer
        document.close();
        writer.close();
        outputStream.close();

        // Close the web driver
        driver.quit();
    }
	
	public static void coverUsingFlyingSaucer(String inputFile, String outputFile) throws Exception{

	    OutputStream os = new FileOutputStream(new File(outputFile));
	    ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocument(new File(inputFile));
	    renderer.layout();
	    renderer.createPDF(os);
	    os.close();
	}
	
	public static void convertUsingSeleium(String url, String outputFile) throws Exception{
		System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    driver.get(url);
		    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    BufferedImage fullImg = ImageIO.read(screenshot);

		    // Create PDF file and write screenshot to it using a library like iText or Apache PDFBox
		    // ...

		    driver.quit();
	}
}
