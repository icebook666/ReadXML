package sdn;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLManager {
	/**
	 * 抓取指定SDN URL的XML檔案，回傳每筆SDNEntry
	 * @return
	 */
	public static ArrayList<SDNEntry> getAllSDNEntry() {
		ArrayList<SDNEntry> allSDNEntry = null;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			SDNHandler sdnHandler = new SDNHandler();
			//File file = new File("D:\\XML\\sdn_s1.xml");
			//parser.parse(file, sdnHandler);
			String url = "https://www.treasury.gov/ofac/downloads/sdn.xml";
			parser.parse(new InputSource(new URL(url).openStream()), sdnHandler);
			
			allSDNEntry = sdnHandler.getAllSDNEntry();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allSDNEntry;
	}
}
