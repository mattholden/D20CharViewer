/**
 * 
 */
package com.darkenedsky.d20charviewer.common;
import java.io.IOException;
import java.io.StringReader;
import java.sql.*;
import org.jdom.*;

import java.util.List;
import java.util.Vector;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Utility class for converting SQL result sets to XML elements and other nifty XML formatting jazz.
 * @author Jaeden
 *
 */
public abstract class XMLTools {

	/** No constructor, please */ private XMLTools() { }
	
	public static Element xml(String name, Integer value) { return xml(name, Integer.toString(value)); }
	public static Element xml(String name, Boolean value) { return xml(name, Boolean.toString(value)); }
	public static Element xml(String name, Float value) { return xml(name, Float.toString(value)); }
	public static Element xml(String name, String value) { 
		Element e = new Element(name);
		e.setText(value);
		return e;
	}
	
	@SuppressWarnings("rawtypes")
	public static String getString(Element root, String elem) { 
		List list = root.getChildren(elem);
		if (list.size() == 0) return null;
		return ((Element)list.get(0)).getText();
	}
	@SuppressWarnings("rawtypes")
	public static Integer getInt(Element root, String elem) { 
		List list = root.getChildren(elem);
		if (list.size() == 0) return null;
		return Integer.parseInt(((Element)list.get(0)).getText());
	}
	@SuppressWarnings("rawtypes")
	public static Boolean getBoolean(Element root, String elem) { 
		List list = root.getChildren(elem);
		if (list.size() == 0) return null;
		return Boolean.parseBoolean(((Element)list.get(0)).getText());
	}
	@SuppressWarnings("rawtypes")
	public static Float getFloat(Element root, String elem) { 
		List list = root.getChildren(elem);
		if (list.size() == 0) return null;
		return Float.parseFloat(((Element)list.get(0)).getText());
	}
	
	/** Convert a result set into an XML object, using all its metadata to define the XML schema
	 * 
	 * @param set a ResultSet to render into XML
	 * @return XML-formatted results for every row and column in the result set
	 * @throws SQLException
	 */
	public static Element toXML(ResultSet set) throws SQLException {
		
		Element root = new Element("resultset");
		if (set.first() == false) {
			set.close();
			return root;
		}
		
		// get column names
		ResultSetMetaData meta = set.getMetaData();
		int cols = meta.getColumnCount();
		Vector<String> columns = new Vector<String>();
		for (int i = 1; i <= cols; i++)
			columns.add(meta.getColumnName(i));
		
		// loop through the fields and add stuff
		while (true) { 
			Element row = new Element ("result");
			
			for (int i = 1; i <= cols; i++) { 
				String val = set.getString(columns.get(i - 1));
				if (val != null) {
					
						// special case - we need to convert time values
						String type = meta.getColumnTypeName(i);
						if (type.contains("time"))
							val = Long.toString(Timestamp.valueOf(val).getTime());
						
						row.setAttribute(columns.get(i - 1), val);
				}
			}
			root.addContent(row);
			
			if (set.isLast()) break;
			set.next();
		}
		set.close();
		return root;
	}
	
	/** Convert a result set into an XML object, using all its metadata to define the XML schema
	 * 
	 * @param set a ResultSet to render into XML
	 * @return XML-formatted results for every row and column in the result set, rendered as a compact XML string
	 * @throws SQLException
	 */
	public static String buildXMLDataSet(ResultSet set) throws SQLException { 
		return xmlToCompactString(toXML(set));
	}
	
	/** The SAX Builder object used for string parsing */
	private static SAXBuilder sax = new SAXBuilder();
	
	/** Convert an XML-formatted string into an XML element object
	 * 
	 * @param xml the string to convert
	 * @return an XML object constructed from that string
	 * @throws Exception
	 */
	public static Element stringToXML(String xml) throws Exception {
		return (xml == null) ? null : sax.build(new StringReader(xml)).getRootElement();
	}
	
	/** Read a file and return an XML element
	 *   @param file File path
	 *   @return the XML root element
	 */
	public static Element loadXMLFile(String file)  throws JDOMException, IOException { 
		if (file == null) return null;
		
			Document doc = null;
			doc = sax.build(file);
			return doc.getRootElement();
		}

	/** Convenience method to convert an XML element into a compact-format string
	 * @param elem the XML element to render
	 * @return a string containing the compact-formatted XML
	 */
	public static String xmlToCompactString(Element elem) { 
			XMLOutputter out = new XMLOutputter();
			out.setFormat(Format.getCompactFormat());
			return out.outputString(elem);
	}
	
	/** Convenience method to convert an XML element into a pretty-format string
	 * @param elem the XML element to render
	 * @return a string containing the pretty-formatted XML
	 */
	public static String xmlToString(Element elem) { 
		XMLOutputter out = new XMLOutputter();
		out.setFormat(Format.getPrettyFormat());
		return out.outputString(elem);
	 }
	
	
	
}
