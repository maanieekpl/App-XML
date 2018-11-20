package lab4_task3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.w3c.dom.*; 
import javax.xml.parsers.*; 
import javax.xml.transform.*; 
import javax.xml.transform.dom.*; 
import javax.xml.transform.stream.*; 


public class task3 {
	public static void main(String argv[]) throws IOException {
		
		
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\maani\\OneDrive\\Ró¿ne\\Studia\\APP & XML\\lab4\\lab4_task3\\src\\db.txt"));
        
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        
        for (String line : lines) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(line);
            index++;
        }
        
        String contents = sb.toString();
        String[] cos = contents.split(",");
        
        int columns = cos.length/index;
      

        String[][] table = new String[index][columns];
        int k=0;
        
        if(k<cos.length) {
	        for(int i = 0; i < index; i++) {
	        	for(int j = 0; j < columns; j++)
	        	{
	        		table[i][j]=cos[k];
	        		k++;
	        	}
	        }
        }
        
        for(int i = 0; i < index; i++) {
        	for(int j = 0; j < columns; j++)
        	{
        		System.out.print(table[i][j] + " ");
        	}
        	System.out.println();
        }
        
        System.out.println(table[1][0]);
        try {
        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance(); 
        DocumentBuilder docBuilder = dbfac.newDocumentBuilder(); 
        Document doc = docBuilder.newDocument(); 
        
        Element root = doc.createElement("ComputerEngineerig"); 
        doc.appendChild(root); 
        Element[] child = new Element[cos.length];
        Text[] text = new Text[cos.length];
        k=0;
        int l=0;
        for(int i = 0; i < index; i++) {
        	for(int j = 0; j < columns; j++) {
        		child[l]  = doc.createElement(table[k][j]);
        		root.appendChild(root);
        		text[l] = doc.createTextNode(table[k+i+1][j]);
        		root.appendChild(text[l]);
        		l++;
        	}
        }

        
      //Output the XML ------------------------------------------
      //set up a transformer
                  TransformerFactory transfac = TransformerFactory.newInstance(); 
                  Transformer trans = transfac.newTransformer(); 
                  trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); 
                  trans.setOutputProperty(OutputKeys.INDENT, "yes"); 
      //create string from xml tree
                  StringWriter sw = new StringWriter(); 
                  StreamResult result = new StreamResult(sw); 
                  DOMSource source = new DOMSource(doc); 
                  trans.transform(source, result); 
                  String xmlString = sw.toString(); 
      //print xml
                  System.out.println("Here's the xml:\n\n" + xmlString);        
        } catch (Exception e) { 
            System.out.println(e); 
        } 
        
	}
}
		
		



			
			
	

