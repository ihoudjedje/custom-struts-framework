package com.uvsq.ministruts.factory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.uvsq.ministruts.controller.Action;


public class FactoryXMLParser {
	
	//I copy pasted this code, though I literally understand what it does.
	
	private static volatile FactoryXMLParser instance = null;
	public Map<String,Action> currentAction = new HashMap<String,Action>();
	
	public final static FactoryXMLParser getInstance(String fichier) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParserConfigurationException, SAXException, IOException {

        if (FactoryXMLParser.instance == null) {
           synchronized(FactoryXMLParser.class) {
             if (FactoryXMLParser.instance == null) {
            	 FactoryXMLParser.instance = new FactoryXMLParser(fichier);
             }
           }
        }
        return FactoryXMLParser.instance;
    }
	
	private FactoryXMLParser(String cheminxml) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
			  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         File fileXML = new File(cheminxml);

	         Document xml = builder.parse(fileXML);

	       
	         Element root = xml.getDocumentElement();
	         NodeList bases = root.getElementsByTagName("action");
	         String route = null;
	         String action = null;
	         for(int i=0;i<bases.getLength();i++){
	        	 Node base = bases.item(i);
	        	 NodeList elements = base.getChildNodes();
	        	 for(int j=0;j< elements.getLength();j++){
	        		 Node enfant = elements.item(j);
	        		 if(enfant.getNodeName().equals("url-pattern")){
	        			 route = enfant.getTextContent(); 
	        		 }
	        		 if(enfant.getNodeName().equals("action-name")){
	        			 action = enfant.getTextContent();
	        		 }
	        	 }
	        	 
	        	 Class cl = Class.forName(action);
	        	 Action o = (Action) cl.newInstance();
	        	 currentAction.put(route, o);
	         }
	
	}
	public Action getAction(String url){
		return currentAction.get(url);
	}
}
