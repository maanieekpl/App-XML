package lab5_task1;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class task1 extends DefaultHandler {
	public static void main(String[] args) {
	
		 try {
		        File inputFile = new File("C:\\Users\\lab\\workspace\\lab5_task1\\src\\lab5_task1\\chessboard.xml");
		        SAXParserFactory factory = SAXParserFactory.newInstance();
		        SAXParser saxParser = factory.newSAXParser();
		        UserHandler userhandler = new UserHandler();
		        saxParser.parse(inputFile, userhandler);     
		     } catch (Exception e) {
		        e.printStackTrace();
		     }
	}
}
   
class UserHandler extends DefaultHandler{	
	
	boolean name;
	boolean position;
	

	@Override
	public void	startElement(String uri,
			String localName, String qName,Attributes a)throws SAXException {  
		if(qName.equalsIgnoreCase("name")){
			name = true;
		} else if(qName.equalsIgnoreCase("position")){
			position=true;
			}
		}

	@Override
	public void	endElement(String uri, String localName, String	qName) throws SAXException{ 
		if(qName.equalsIgnoreCase("pawn")){
			name=true;
		System.out.println("End Elemen" + qName);
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if(name){
			System.out.println("Name: " + new String(ch, start, length));
			name = false;
		}else if(position){
			System.out.println("position: " + new String(ch, start, length));
			position=false;
		}
	}
}