package lab5_task2;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class task2 extends DefaultHandler {
	public static void main(String[] args) {
	
		 try {
		        File inputFile = new File("C:\\Users\\maani\\OneDrive\\Ró¿ne\\Studia\\APP & XML\\lab5\\lab5_task2\\src\\lab5_task2\\chessboard.xml");
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
	
	boolean chessboard;
	boolean pawn;
	boolean name;
	boolean position;
	

	@Override
	public void	startElement(String uri,
			String localName, String qName,Attributes a)throws SAXException {  
		if(qName.equalsIgnoreCase("chessboard")){
			chessboard = true;
		System.out.print("Start tag: " + qName);
		} else if(qName.equalsIgnoreCase("pawn")){
			pawn=true;
		System.out.print("Start tag: " + qName);
		} else if(qName.equalsIgnoreCase("name")) {
			name = true;
		System.out.println("Start tag: " + qName);
		} else if(qName.equalsIgnoreCase("position")) {
			position = true;
		System.out.println("Start tag: " + qName);
		}
	}


	@Override
	public void	endElement(String uri, String localName, String	qName) throws SAXException{ 
		if(qName.equalsIgnoreCase("chessboard")){
			chessboard=true;
		System.out.print("End tag: " + qName);
		}
		if(qName.equalsIgnoreCase("pawn")){
			pawn=true;
		System.out.print("End tag: " + qName);
		} else if(qName.equalsIgnoreCase("name")) {
			name = true;
		System.out.print("End tag: " + qName);
		} else if(qName.equalsIgnoreCase("position")) {
			position = true;
		System.out.print("End tag: " + qName);
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if(chessboard){
			System.out.println(new String(ch, start, length));
			chessboard = false;
		}else if(pawn){
			System.out.println(new String(ch, start, length));
			pawn=false;
		}else if(name){
			System.out.println(new String(ch, start, length));
			pawn=false;
		}else if(position){
			System.out.println(new String(ch, start, length));
			pawn=false;
		}
	}
}