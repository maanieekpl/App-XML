

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.utils.SystemIDResolver;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab9.Host;

/**
 * Servlet implementation class XmlServlet
 */
@WebServlet("/xmlservlet")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XmlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Host[] hosts = (Host[])request.getAttribute("host");
		
		PrintWriter out = response.getWriter();
		
		
		System.setProperty("javax.xml.transform.TransformerFactory",
                "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");

		  try {

				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("hosts");
				doc.appendChild(rootElement);
			
				
		
		for(int i=0; i<hosts.length; i++)
		{	
						
			Element course = doc.createElement("host");
			rootElement.appendChild(course);

			Attr attr1 = doc.createAttribute("name");
			attr1.setValue(hosts[i].getName());
			course.setAttributeNode(attr1);
					
			Element topic1 = doc.createElement("ip");
			topic1.appendChild(doc.createTextNode(hosts[i].getIp()));
			course.appendChild(topic1);

		}
		

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		 String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		 String webInfPath = getServletConfig().getServletContext().getRealPath("data");
		StreamResult result = new StreamResult(new File(webInfPath + "/host.xml"));
	
		
	
		transformer.transform(source, result);

		response.sendRedirect("viewhost.jsp");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
  
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
