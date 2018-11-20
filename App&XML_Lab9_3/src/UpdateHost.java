

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.lab9.Host;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class UpdateHost
 */
@WebServlet("/updatehost")
public class UpdateHost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String host = request.getParameter("txthost");
		String ip = request.getParameter("txtip");
		
		System.out.println(host);
		System.out.println(ip);
		
		
		String webInfPath = getServletConfig().getServletContext().getRealPath("data");
		
		
		Host[] hosts = null;
		

		 try {  
			  
			   File xmlFile = new File(webInfPath+"/host.xml");  
			   DocumentBuilderFactory documentFactory = DocumentBuilderFactory  
			     .newInstance();  
			   DocumentBuilder documentBuilder = documentFactory  
			     .newDocumentBuilder();  
			   Document doc = documentBuilder.parse(xmlFile);  
			  
			   doc.getDocumentElement().normalize();  
			   NodeList nodeList = doc.getElementsByTagName("host");  
			  
			   System.out.println("Root element :"  
			     + doc.getDocumentElement().getNodeName());  
			  
			   hosts = new Host[nodeList.getLength()];
			   System.out.println("legth"+nodeList.getLength());
			   
			   
			   
			   for (int temp = 0; temp < nodeList.getLength(); temp++) {  
			    Node node = nodeList.item(temp);  
			  
			    
			    
			    if (node.getNodeType() == Node.ELEMENT_NODE) {  
			  
			     Element student = (Element) node;  
			  
			     String name = student.getAttribute("name");
			     if(name.equals(host))
			     {
			    	 Host h = new Host(name,ip);
			    	 
			    	 hosts[temp] = h;
			    	
			     }
			     else
			     {
			    	 Host h = new Host(name,student.getElementsByTagName("ip").item(0).getTextContent());
			    	 hosts[temp] = h;
			    	 
			    	 
			    	 
			     }
			     
			    
			    }  
			   
			   }  
			  } catch (Exception e) {  
			   e.printStackTrace();  
			  } 
		     
		 	request.setAttribute("host", hosts);
			RequestDispatcher rs = request.getRequestDispatcher("xmlservlet");
			rs.forward(request,response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
