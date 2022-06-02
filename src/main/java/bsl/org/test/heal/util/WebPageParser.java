package bsl.org.test.heal.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebPageParser {
	public Document getHtmlSource(String strUrl) throws Exception{
		return Jsoup.connect(strUrl).get();
	}

}
