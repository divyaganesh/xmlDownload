package com.example.xmlDownload.controller;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Component;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.example.xmlDownload.model.AuthAction;

@Component
public class DownloadService {
	
	public void download(String pilotName, List<AuthAction> authorizationList) {
		
		final String xmlFilePath = "U:\\"+pilotName+".xml";

		try {
			

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			// root element
			Element root = document.createElement("authorization");
			document.appendChild(root);

			// action element
			Element actions = document.createElement("actions");

			root.appendChild(actions);
			
			//add element
			
			
          //  List<AuthAction> authActionList = authorizationList.getAuthActionList();
            
            for(AuthAction authorization : authorizationList) {
            	
            	Element add = document.createElement("add");
            	actions.appendChild(add);
    			
            	Attr nameattr = document.createAttribute("Name");
            	nameattr.setValue(authorization.getName());
            	add.setAttributeNode(nameattr);
            	
            	Attr allowedattr = document.createAttribute("AllowedFor");
            	allowedattr.setValue(authorization.getAllowedFor());
            	add.setAttributeNode(allowedattr);
            	
            	Attr disabledattr = document.createAttribute("DisabledFor");
            	disabledattr.setValue(authorization.getDisabledFor());
            	add.setAttributeNode(disabledattr);
            }
			// create the xml file
			// transform the DOM Object to an XML File
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

			// If you use
			// StreamResult result = new StreamResult(System.out);
			// the output will be pushed to the standard output ...
			// You can use that for debugging

			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}
}