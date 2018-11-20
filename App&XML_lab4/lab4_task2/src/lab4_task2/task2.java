package lab4_task2;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class task2 {
	  public static void main(String argv[]) {
	
	 try {

			File fXmlFile = new File("C:\\Users\\maani\\OneDrive\\Ró¿ne\\Studia\\APP & XML\\lab4\\lab4_task2\\src\\lab4_task2\\Book.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("book");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\n");

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Book id : " + eElement.getAttribute("id"));
					System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
					System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
					System.out.println("Genre : " + eElement.getElementsByTagName("genre").item(0).getTextContent());
					System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
					System.out.println("Publish Date : " + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
					System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
					
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  }
	  
	  

}

