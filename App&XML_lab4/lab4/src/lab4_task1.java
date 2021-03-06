import java.io.*; 
import org.w3c.dom.*; 
import javax.xml.parsers.*; 
import javax.xml.transform.*; 
import javax.xml.transform.dom.*; 
import javax.xml.transform.stream.*; 
public class DomXmlExample { 
public static void main (String args[]) { 

try
 { 
//Creating an empty XML Document -------------------------
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder(); 
            Document doc = docBuilder.newDocument(); 
//Creating the XML tree -------------------------------
//create the root element and add it to the document            
            Element root = doc.createElement("ComputerEngineerig"); 
            doc.appendChild(root); 
//create a comment and putit in the root element
            Comment comment = doc.createComment("A comment in a root element"); 
            root.appendChild(comment); 
//create child element, add an attribute, and add to root
            Element child1 = doc.createElement("Cource"); 
            child1.setAttribute("Author", "Adrian Koszowski");
            child1.setAttribute("Name", "Application programming - Java and XML technologies");
            root.appendChild(child1); 
//create child element, add an attribute, and add to root
            Element price = doc.createElement("Topics"); 
            root.appendChild(price); 

//add a text element to the child
            Text text = doc.createTextNode(""); 
            price.appendChild(text); 
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