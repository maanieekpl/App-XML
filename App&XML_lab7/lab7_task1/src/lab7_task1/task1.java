package lab7_task1;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class task1 {

	public static void main(String[] args) throws Exception { 
		// TODO Auto-generated method stub
    	double sum = 0;
    	double avg;
    	int index=0;
    	String ServiceComponentName;
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Service component name: ");
    	ServiceComponentName = scan.nextLine();
    	
    	scan.close();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("sim.xml"));
        NodeList nodeList = doc.getElementsByTagName("measurement");

        
//----------------------AVG for all one service--------------------------
        
        
        
        
        for(int x=0, size = nodeList.getLength();x<size; x++){
            Element element = (Element) nodeList.item(x);
//        	if(nodeList.item(x).getAttributes().getNamedItem("status").getNodeValue().equals("ok") &&
//            		nodeList.item(x).hasAttribute("servicecomponent_name"){

        		if(element.getAttribute("status").equals("ok") &&
        				element.hasAttribute("servicecomponent_name")) {
        			if(element.getAttribute("servicecomponent_name").equals(ServiceComponentName)) {
	        	String text = new String(); 
	        	double temp;
	        	text = nodeList.item(x).getAttributes().getNamedItem("responseperiod").getNodeValue();
//	        	System.out.println(text);
	        	temp = Double.parseDouble(text);
	        	sum += temp;
	        	index++;
        		}
        	}
        }
        avg = sum/index;
        
        System.out.println("Avarage  for " + ServiceComponentName +
        		" = " + avg);
        

        
        avg=0;
        index=0;
        sum=0;

//----------------------AVG for all elements--------------------------
        for(int x=0, size = nodeList.getLength();x<size; x++){
        	if(nodeList.item(x).getAttributes().getNamedItem("status").getNodeValue().equals("ok")){
		        	String text = new String(); 
		        	double temp;
		        	text = nodeList.item(x).getAttributes().getNamedItem("responseperiod").getNodeValue();
		        	temp = Double.parseDouble(text);
		        	sum += temp;
		        	index++;
        	}
        }
        avg=sum/index;
        System.out.println("Avarage = " + avg);
        
        avg=0;
        index=0;
        sum=0;
//-----------------------------------------------------------------------------
        
        int index2=0;
        for(int x=0, size = nodeList.getLength();x<size; x++){
            Element element = (Element) nodeList.item(x);
        	if(element.hasAttribute("activityname")){
        		index2++;
        		if(element.getAttribute("status").equals("false")){
		        	index++;
        		}
        	}
        }
        sum = index*100;
        sum = sum/index2;
        System.out.println("Percentage activity false: " + sum); 
        avg=0;
        index=0;
        sum=0;
        index2=0;
	}

}
