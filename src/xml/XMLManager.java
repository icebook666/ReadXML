package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLManager {
	public static ArrayList<Channel> getAllChannels() {
		ArrayList<Channel> allChannels = null;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			File file = new File("D:\\XML\\sdn_s1.xml");
			ChannelHandler channelHandler = new ChannelHandler();
			parser.parse(file, channelHandler);
			allChannels = channelHandler.getAllChannels();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allChannels;
	}
}
