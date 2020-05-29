package sdn;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SDNHandler extends DefaultHandler {

	private ArrayList<SDNEntry> allSDNEntry;
	private SDNEntry sdnEntry;
	private String reading;
	private int appearTimes = 0;

	public SDNHandler() {
		super();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (qName.equals("sdnList")) {
			allSDNEntry = new ArrayList<SDNEntry>();
		} else if (qName.equals("sdnEntry")) {
			sdnEntry = new SDNEntry();
			appearTimes = 0;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (qName.equals("sdnEntry")) {
			allSDNEntry.add(sdnEntry);
		}
		
		if (qName.equals("lastName") && appearTimes == 0) {
			sdnEntry.setLastName(reading);
			appearTimes++;
		}
		else if (qName.equals("sdnType")) {
			sdnEntry.setSdnType(reading);
		}
		else if (qName.equals("program")) {
			sdnEntry.setProgram(reading);
		}
		else if (qName.equals("type")) {
			sdnEntry.setAka_type(reading);
		}
		else if (qName.equals("category")) {
			sdnEntry.setAka_category(reading);
		}
		else if (qName.equals("lastName") && appearTimes == 1) {
			sdnEntry.setAka_lastname(reading);
		}
		else if (qName.equals("city")) {
			sdnEntry.setAddress_city(reading);
		}
		else if (qName.equals("country")) {
			sdnEntry.setAddress_country(reading);
		}
		else if (qName.equals("address1")) {
			sdnEntry.setAddress_address1(reading);
		}
		else if (qName.equals("postalCode")) {
			sdnEntry.setAddress_postalcode(reading);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		reading = new String(ch, start, length);
	}

	public ArrayList<SDNEntry> getAllSDNEntry() {
		return allSDNEntry;
	}

}