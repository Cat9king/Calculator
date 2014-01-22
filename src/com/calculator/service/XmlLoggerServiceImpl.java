package com.calculator.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class XmlLoggerServiceImpl implements LoggerService {

	@Override
	public void write(String string) {
		try {

			checkForDirectory();		
			
			File xmlFile = new File("C:\\calcXmlFiles\\calc.xml");
			boolean newFileFlag = false;
			if (!xmlFile.exists()) {
				newFileFlag = true;
				xmlFile.createNewFile();
			}

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document doc = null;
			Element root = null;

			if (newFileFlag) {
				doc = documentBuilder.newDocument();
				root = doc.createElement("calc");
				doc.appendChild(root);
			} else {
				doc = documentBuilder.parse(xmlFile);
				root = doc.getDocumentElement();
			}

			Element element = doc.createElement("expression");

			element.appendChild(doc.createTextNode(string));
			root.appendChild(element);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);

			StreamResult streamResult = new StreamResult(xmlFile);

			transformer.transform(domSource, streamResult);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<String> read() {
		
		List<String> expList = new ArrayList<String>();

		try {

			File xmlFile = new File("C:\\calcXmlFiles\\calc.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			NodeList nList = doc.getElementsByTagName("expression");		
			
			for (int i = 0; i < nList.getLength(); i++) {
				expList.add(nList.item(i).getTextContent());				
			}			

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return expList;

	}
	
	private void checkForDirectory(){
		File dir = new File("C:\\calcXmlFiles");
		if(!dir.exists()){
			dir.mkdir();
		}
	}

}
