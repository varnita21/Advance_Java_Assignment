package proj;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Connect {
		// TODO Auto-generated method stub
	public static void main(String[] args) {
		
		int count=0;
		final String xmlPath = "D:\\Eclipse\\XMlfile.xml";
		String dbDriver = "com.mysql.cj.jdbc.Driver"; 
        	String dbURL = "jdbc:mysql://sql12.freemysqlhosting.net/"; 
        	String dbName = "sql12273536"; 
        	String dbUsername = "sql12273536"; 
        	String dbPassword = "accolite"; 
        
		try{  
			System.out.println("In try");
			Class.forName(dbDriver); 
	        Connection con = DriverManager.getConnection(dbURL + dbName, 
	                                                     dbUsername,  
	                                                     dbPassword); 
	  
			Statement stmt=con.createStatement();  
			ResultSet result=stmt.executeQuery("show fields from emp");
	        
			DOMSource domSource = null;
	 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
		    while (result.next()) {
			Element employee = doc.createElement("employee");
			doc.appendChild(employee);
			Attr attr = doc.createAttribute("id");
			attr.setValue(""+count);
			employee.setAttributeNode(attr);
			Element empNo = doc.createElement("EmpNo");
			empNo.appendChild(doc.createTextNode(""+result.getInt(1)));
			employee.appendChild(empNo);
			
			//name
			Element ename = doc.createElement("ename");
			ename.appendChild(doc.createTextNode(result.getString(2)));
			employee.appendChild(ename);
			
			//job
			Element job = doc.createElement("job");
			job.appendChild(doc.createTextNode(result.getString(3)));
			employee.appendChild(job);
			
			//D.O.M
			Element mrg = doc.createElement("mrg");
			mrg.appendChild(doc.createTextNode(""+result.getInt(4)));
			employee.appendChild(mrg);
			
			//hiredate
			Element hiredate = doc.createElement("hiredate");
			hiredate.appendChild(doc.createTextNode(""+result.getDate(5)));
			employee.appendChild(hiredate);
			
			//sal
			Element sal = doc.createElement("sal");
			sal.appendChild(doc.createTextNode(""+result.getInt(6)));
			employee.appendChild(sal);
			
			//comm
			Element comm = doc.createElement("comm");
			sal.appendChild(doc.createTextNode(""+result.getInt(7)));
			employee.appendChild(comm);
			
			//deptno
			Element deptno = doc.createElement("deptno");
			deptno.appendChild(doc.createTextNode(""+result.getInt(7)));
			employee.appendChild(deptno);
			count++;
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StreamResult streamResult = new StreamResult(new File(xmlPath));
			transformer.transform(domSource, streamResult);
		    }
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			StreamResult streamResult = new StreamResult(new File(xmlPath));
			transformer.transform(domSource, streamResult);
			System.out.println("Done creating XML File 1 without editing.");
			rs.close();
			con.close();
			Connect2 c = new Connect2();
			c.con();
		    compare.CompareClass.compare();
		
		}
		catch(Exception e){ System.out.println(e);}  
	}
}







