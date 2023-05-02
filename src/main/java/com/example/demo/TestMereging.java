package com.example.demo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestMereging {

    public static void main(String[] args) {
        String report1FilePath = "D:\\RC-IIBtoACE-Report-Merge\\recommendations2.html";
        String report2FilePath = "D:\\RC-IIBtoACE-Report-Merge\\recommendations.html";
        String mergedReportFilePath = "D:\\merged-report2.pdf";
        try {
			//HtmlToPdf.convert(report2FilePath, mergedReportFilePath);
        	HtmlToPdf.convertUsingBrowser("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwip4JatrbP-AhVOhv0HHSA-DAcQPAgJ", mergedReportFilePath);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        

/*        try {
            // Read the contents of the first HTML report file
            BufferedReader report1Reader = new BufferedReader(new FileReader(report1FilePath));
            String report1Content = "";
            String line;
            while ((line = report1Reader.readLine()) != null) {
                report1Content += line;
            }
            report1Reader.close();

            // Read the contents of the second HTML report file
            BufferedReader report2Reader = new BufferedReader(new FileReader(report2FilePath));
            String report2Content = "";
            while ((line = report2Reader.readLine()) != null) {
                report2Content += line;
            }
            report2Reader.close();

            // Create a new HTML string that merges the two reports
            String mergedReportContent = "<html><body>"+report1Content + report2Content+"</body></html>";

            // Extract the CSS styles from both reports and merge them into a single CSS string
            String report1Css = extractCssStyles(report1Content);
            String report2Css = extractCssStyles(report2Content);
            String mergedCss = report1Css + report2Css;

            // Insert the merged CSS string into the head section of the new HTML string
            int headIndex = mergedReportContent.indexOf("</head>");
            if (headIndex != -1) {
                mergedReportContent = mergedReportContent.substring(0, headIndex) + "<style>" + mergedCss + "</style>" + mergedReportContent.substring(headIndex);
            }

            // Write the new HTML string to a file
            FileWriter mergedReportWriter = new FileWriter(mergedReportFilePath);
            mergedReportWriter.write(mergedReportContent);
            mergedReportWriter.close();

            System.out.println("Merged report written to file: " + mergedReportFilePath);
        } catch (IOException e) {
            System.out.println("Error merging HTML reports: " + e.getMessage());
        }
    }

    private static String extractCssStyles(String html) {
        String css = "";
        int startIndex = html.indexOf("<style>");
        int endIndex = html.indexOf("</style>");
        if (startIndex != -1 && endIndex != -1) {
            css = html.substring(startIndex + 7, endIndex);
        }
        return css;
    }*/
    }
}
