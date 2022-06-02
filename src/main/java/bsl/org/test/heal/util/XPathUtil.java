package bsl.org.test.heal.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class XPathUtil {

	public String getXPath(Element element, boolean absolute) {
		boolean isBreak = false;
		List<String> lstNodes = new ArrayList<String>();
		
		String strXPath = IUtilConstant.EMPTY;
		Element currentElement = element;	
		
		if(element == null) {
			strXPath = "";
		}

		while(currentElement != null) {
			
			String strNode = getNode(currentElement,absolute);
			if(!strNode.equalsIgnoreCase(IUtilConstant.EMPTY)) {
				lstNodes.add(strNode);	
				
				if(strNode.indexOf(IUtilConstant.ID) >= 0 || strNode.indexOf(IUtilConstant.NAME) >= 0) {
					isBreak = true;
				}
			}
			
			if(!isBreak){
				currentElement = currentElement.parent();
			}else {
				currentElement = null;
			}
		}
		if(!absolute) {
		
			String strResultXPath = joininReverse(lstNodes, IUtilConstant.DELEMETER);
			if(strResultXPath.indexOf(IUtilConstant.HTMLELEMENT) >= 0) {
				strXPath = new StringBuilder(IUtilConstant.HTMLELEMENT).append(joininReverse(lstNodes, IUtilConstant.DELEMETER)).toString();
			}else {
				strXPath = strResultXPath.replace(IUtilConstant.HTML_N_BODY_ELEMENT, IUtilConstant.RELATIVEPATH);
			}
			
		}else {
			strXPath = joininReverse(lstNodes, IUtilConstant.DELEMETER);
		}
		return strXPath;
	}
	
	private String getNode(Element element,boolean absolute) {
		String strNode;
		String strNodeExpr = element.tagName().toLowerCase();
	
		boolean isBreak = false;
		boolean isContinue = true;
	
		if(strNodeExpr.equalsIgnoreCase(IUtilConstant.EMPTY)) {
			strNode = IUtilConstant.EMPTY;
		}
		
		if(!absolute) {
			String strElementName;
			String strElementId;
			strElementName = getElementname(element);
			strElementId = getElementId(element);
			
			if(!strElementId.equalsIgnoreCase(IUtilConstant.EMPTY)) {				
				strNodeExpr = new StringBuilder(strNodeExpr).append("[@id='").append(strElementId).append("']").toString();
				isContinue=false;
			}else if(!strElementName.equalsIgnoreCase(IUtilConstant.EMPTY)) {				
				strNodeExpr = new StringBuilder(strNodeExpr).append("[@id='").append(strElementName).append("']").toString();
				isContinue=false;
			}
			
			if(isContinue) {
				int iRank = 1;
				Element nodeDom = element;
				Element psDom = nodeDom.previousElementSibling();
				while(psDom != null) {
					if(psDom.nodeName().equalsIgnoreCase(element.tagName())) {
						iRank = iRank + 1;
					}
					psDom = psDom.previousElementSibling();
				}
				
				if(iRank > 1) {
					strNodeExpr = strNodeExpr + "[" + String.valueOf(iRank).trim() + "]";
				}else {
					Element nsDom = nodeDom.nextElementSibling();
					while(nsDom != null) {
						if(nsDom.nodeName().equalsIgnoreCase(nsDom.tagName())) {
							strNodeExpr = strNodeExpr + "[1]";
							isBreak = true;
						}
						if(isBreak) {
							nsDom = null;
						}else {
							nsDom = nsDom.nextElementSibling();
						}
					}
				}	
			}	
		}
		return strNodeExpr;
	}
	
	private String joininReverse(List<String> lstNodes, String strDelimeter) {
		String strActXPath = IUtilConstant.EMPTY;
		int iSiblingPos = lstNodes.size()-1;
		
		for(;iSiblingPos >= 0; iSiblingPos--) {
			if(!lstNodes.get(iSiblingPos).equalsIgnoreCase(IUtilConstant.EMPTY)) {
				strActXPath = new StringBuilder(strActXPath).append(strDelimeter).append(lstNodes.get(iSiblingPos)).toString();
			}
		}
		strActXPath = new StringBuilder(strDelimeter).append(strActXPath).toString();
		return strActXPath;
	}
	
	private String getElementname(Element element) {
	
		String strElementName;
		String strHtml = element.outerHtml().toLowerCase();
		if(strHtml.indexOf(IUtilConstant.NAMEATTRIBUTE, 1) >= 1) {
			strElementName = IUtilConstant.EMPTY;
		}else {
			strElementName = element.attr(IUtilConstant.NAMEATTRIBUTE);
		}
		return strElementName.toLowerCase();
	}
	
	private String getElementId(Element element) {
		
		String strElementId;
		strElementId = element.id();
				
		return strElementId.toLowerCase();
	}
	
	public void getElement(Element element, String elementType) {
		String strElement = element.outerHtml().toLowerCase();
		int iElementTypePos = strElement.indexOf("input");
		int iElementClosePos = strElement.indexOf(">", iElementTypePos);
		String strInputElement = strElement.substring(iElementTypePos-1,iElementClosePos+1);
		System.out.println("strElement: " + strElement);
		System.out.println("strInputElement: " + strInputElement);
		Element tmpElement = new Element("input");
		Elements el1 = element.children();
		for(Element el: el1) {
			System.out.println("el: " + el);
		}
		System.out.println("tmpElement: " + tmpElement.outerHtml());
		
	}
}
