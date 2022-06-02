package bsl.org.test.heal.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NodeTest {

	public static void main(String[] args) {
		Document html;
		String EMPTY = "";
		String strHtml = "<html><body><form> <label for='tstSearch'>Search</label><input type='text' name='query' id='query' accesskey='S'><input type='submit' value='Go'> <br>/<table><tr><td>UserName:</td><td><input type='text' name='name' id='uname'></td></tr><tr><td> Password: </td><td> <input type='password' name='pwd' id='upwd'></td></tr></table></form></body></html>";
		String str1 = "username:";
		int iPos = str1.indexOf(":");
		str1 = str1.substring(0, iPos);
		System.out.println(str1);
		
		String example = "<td> <input type='text' id='uid' name='uid' value='' style='width: 150px;'> </td>";
		Element element = new Element(example);
		System.out.println("Element: " + element);
		XPathUtil util = new XPathUtil();
		util.getElement(element, "input");
		/*try {
			html = Jsoup.parse(example);
			Elements elements = html.getAllElements();
			for (Element element : elements) {
				System.out.println("Element: " + element);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}*/
				
		/*try {
			//html = Jsoup.connect("http://demo.testfire.net/").get();
			html = Jsoup.parse(strHtml);
			Elements allElements = html.getAllElements();
			 Elements inputElements = html.getElementsByTag("INPUT");
			 
				 for (Element element : allElements) {
					 System.out.println("outerHTML: " + element.outerHtml());
					
					// if(element.outerHtml().toLowerCase().indexOf("html") < 0) {
						 //System.out.println("Prevous Node is: " + element.previousElementSibling());
						 //System.out.println("NodeName: " + element.nodeName());
						 //System.out.println("TagName: " + element.tagName());
					 System.out.println("Next Element: " + element.nextElementSibling());
						 //System.out.println("Prevous Node is: " + element.before(element));
						 
					 //}
					
					 System.out.println("element.ownText: " + element.ownText());
					
					 System.out.println("------------------------------");
				 }
		}catch(Exception e) {
			e.printStackTrace();
		}*/

	}

}
//System.out.println(element.nodeName() + " ID: " + element.id());
// String strId = element.id();
 
/* if(strId.equalsIgnoreCase("")) {
	 System.out.println("ID is not present");
 }else {
	 System.out.println("ID is present");
 }
 String strElementNameVal = element.attr("name");
 if(strElementNameVal.equalsIgnoreCase("")) {
	 System.out.println("NAME attr is not present");
 }else {
	 System.out.println("NAME attr is present");
 }
  //System.out.println(element.nodeName() + " NAME: " + element.attr("name"));
//System.out.println("element.nodeName: " + element.nodeName());
 */
//String currentElement = element.outerHtml();
//System.out.println( "element.outerHTML:  " + currentElement);

//System.out.println( "element.Id:  " + element.id());
//System.out.println( "element.cssSelector:  " + element.cssSelector());
// System.out.println( "element.parentNode:  " +element.parentNode());
//System.out.println( "element.parent:  " +element.parent());
//System.out.println( "element.parents:  " +element.parents());
// String title = html.title(); 
//System.out.println(title);