package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {

	public static void main(String[] args) {
		try {
			/*
			 * KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			 * generator.initialize(2048); KeyPair pair = generator.generateKeyPair();
			 * PrivateKey privateKey = pair.getPrivate(); PublicKey publicKey =
			 * pair.getPublic();
			 */
			
			/*
			 * Document mergedDoc = new Document(""); File input = new
			 * File("D:\\RC-IIBtoACE-Report-Merge\\recommendations2.html"); Document
			 * report1Doc = Jsoup.parse(input, "UTF-8", "");
			 * 
			 * File input2 = new File("D:\\RC-IIBtoACE-Report-Merge\\recommendations.html");
			 * Document report1Doc2 = Jsoup.parse(input2, "UTF-8", "");
			 * 
			 * Element report1Body = report1Doc.body();
			 * //mergedDoc.body().appendChild(report1Body);
			 * 
			 * Element report2Body = report1Doc2.body();
			 * mergedDoc.body().appendChild(report1Body).appendChild(report2Body);
			 * 
			 * File output = new File("D://merged_report.html"); FileOutputStream fos = new
			 * FileOutputStream(output); OutputStreamWriter osw = new
			 * OutputStreamWriter(fos, "UTF-8"); osw.write(mergedDoc.outerHtml());
			 * osw.close();
			 */
			BigDecimal v1 = new BigDecimal(23.33);
			BigInteger v2 = v1.multiply(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(1.15)).toBigInteger();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
