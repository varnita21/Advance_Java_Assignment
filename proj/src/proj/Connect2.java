package proj;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Connect2 {
	int count=0;
	final String xmlPath = "D:\\Eclipse\\xmlFile1.xml";
	String dbDriver = "com.mysql.cj.jdbc.Driver"; 
//    String dbURL = "jdbc:mysql://sql12.freemysqlhosting.net/"; 
//    String dbName = "sql12273536"; 
//    String dbUsername = "sql12273536"; 
//    String dbPassword = "accolite"; 
	String dbURL = "jdbc:mysql:// localhost:3306/"; 
    // Database name to access 
    String dbName = "db"; 
    String dbUsername = "root"; 
    String dbPassword = "root"; 
	public void con() throws ClassNotFoundException {
		try{  
			Class.forName(dbDriver); 
	        Connection con = DriverManager.getConnection(dbURL + dbName, 
	                                                     dbUsername,  
	                                                     dbPassword); 
	  
			Statement stmt=con.createStatement();
			ResultSet result=null;
			String sql = "INSERT INTO emp " +
	                   "VALUES (16, 'Varnita', 'Developer', 500, '2015-11-11',2000000,20,30)";
	      	stmt.executeUpdate(sql);
	      	result=stmt.executeQuery("select * from emp");
			System.out.println("Inserted records into the table...");
			// Iterate through the data in the result set and display it. 
		    DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = df.newDocumentBuilder();
			Document doc = db.newDocument();
			Element company = doc.createElement("company");
			doc.appendChild(company);
			
		    while (result.next()) {
			Element employee = doc.createElement("employee");
			company.appendChild(employee);
			Attr attr = doc.createAttribute("id");
			attr.setValue("count");
			employee.setAttributeNode(attr);
			Element empNo = doc.createElement("empNo");
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
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(xmlPath));
			transformer.transform(domSource, streamResult);
			count++;
		    }
			System.out.println("Done creating XML File 2 after updating.");

		}catch (SQLException sqlExp) {
			 
			System.out.println("SQLExcp:" + sqlExp.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
