package bsl.org.test.heal.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HTMlParser {

	public static void main(String[] args) {
		 Document html;
		 String EMPTY = "";
		 WebPageParser webParser = new WebPageParser();
		 List<String> lstElements = new ArrayList<String>();
		 
		/* lstElements.add("Sign in#Click");
		 lstElements.add("Search#TypeText");
		 lstElements.add("Go#Click");*/
		 
		 lstElements.add("username#TypeText");
		 lstElements.add("password#TypeText");
		 lstElements.add("Login#Click");
		 

		 try { 
			 html = webParser.getHtmlSource("http://demo.testfire.net/login.jsp");  //https://demo.testfire.net/login.jsp
			 Elements allElements = html.getAllElements();

			 XPathUtil xpath = new XPathUtil();
			 
			 for(String strElement : lstElements) {
				 String[] strElements = strElement.split("#");
				 String strLabel = strElements[0].toLowerCase();
				 String strAction = strElements[1].toLowerCase();				 
				 
				 for (Element element : allElements) {
					 if(strAction.equalsIgnoreCase(IUtilConstant.CLICK)) {
						 
						String strElementOwnTest = element.ownText();
						
				        if(strElementOwnTest.equalsIgnoreCase(strLabel)) {

				        	System.out.println("*****************************************************");
				        	System.out.println(strLabel + " XPath: " + xpath.getXPath(element, false));
				        	System.out.println("*****************************************************");
				        	
				        }else {
				        	String strValueAttr = element.attr("value").trim().toLowerCase();
				        	String strLabelToSearch = strLabel.trim().toLowerCase();
				        	if(strValueAttr.equalsIgnoreCase(strLabelToSearch)) {
				        		System.out.println("*****************************************************");
					        	System.out.println(strLabel + " XPath: " + xpath.getXPath(element, false));
					        	System.out.println("*****************************************************");
				        	}
				        	
				        }
					 }	else if(strAction.equalsIgnoreCase(IUtilConstant.TYPETEXT)) {

						 boolean isFound = false;
						 String strRetrievedText = element.ownText();
						 strRetrievedText = strRetrievedText.trim().toLowerCase();
						 if(strRetrievedText.indexOf(IUtilConstant.COLON) >= 0) {
							 
							 int iColonPosition = strRetrievedText.indexOf(IUtilConstant.COLON);
							 strRetrievedText = strRetrievedText.substring(0, iColonPosition);
						 }
						 String strElementToSearch = strLabel.toLowerCase();
						 
						 if(strRetrievedText.equalsIgnoreCase(strElementToSearch)) {
							
							 Element nextElement = element.nextElementSibling();
							 String strTagName = nextElement.tagName().trim().toLowerCase();
							 
							 if(strTagName.equalsIgnoreCase(IUtilConstant.INPUTELEMENT)) {
								 isFound = true;
							 }else {
								 Elements childElements = nextElement.children();
								 for(Element childElement: childElements) {
									 strTagName = childElement.tagName().trim().toLowerCase();
									 if(strTagName.equalsIgnoreCase(IUtilConstant.INPUTELEMENT)) {
										 nextElement = childElement;
										 isFound = true;
										 break;
									 }
								 }
								
							 }
							 if(isFound) {
								 System.out.println("#####################################################");
								 System.out.println(strLabel + " XPath: " + xpath.getXPath(nextElement, false));
								 System.out.println("#####################################################");
							 }else {
								 System.out.println("Input Element not found associated to " + strElementToSearch );
							 }
							 
						 }
						
					 }
				 }
				 
				 /*for (Element element : inputElements) {
					 String strElementText = element.outerHtml().toLowerCase();
					 strLabel = strLabel.toLowerCase();
					
					 if(strElementText.indexOf(strLabel) > 0) {
						 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						 System.out.println(strLabel + " XPath: " + xpath.getXPath(element, false));
						 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					 }
				 }*/
			 }
	
			
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		 
	}

}

// css=html > body > #header > #frmSearch > table > tbody > tr > td:nth-of-type(1) > #LoginLink > font
// /html/body/div[1]/form/table/tbody/tr[1]/td[2]/a[1]/font

/*
System.out.println("element.nodeName: " + element.nodeName());
System.out.println("element.ownTest: " + element.ownText());
String currentElement = element.outerHtml();
System.out.println( "element.outerHTML:  " + currentElement);

System.out.println( "element.Id:  " + element.id());
System.out.println( "element.cssSelector:  " + element.cssSelector());
System.out.println( "element.parentNode:  " +element.parentNode());
System.out.println( "element.parent:  " +element.parent());
System.out.println( "element.parents:  " +element.parents());
String title = html.title(); 
System.out.println(title);
*/

/*
String strusername = "username#TypeText";
String strPassword = "password#TypeText";
String strLogin = "Login#Click";
*/
/*
String strSignIn = "Sign in#Click";
String strSearch = "Search#TypeText";
String strGo = "Go#Click";
*/