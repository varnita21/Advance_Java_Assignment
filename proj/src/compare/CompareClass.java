package compare;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.custommonkey.xmlunit.XMLUnit;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class CompareClass {

	public static void compare() throws IOException {
		// TODO Auto-generated method stub
		final String xmlPath1 = "xmlFile1.xml";
		final String xmlPath2 = "xmlFile.xml";
		
		File file1 = new File(xmlPath1);
		File file2 = new File(xmlPath2);
		BufferedReader FirstXML = new BufferedReader(new FileReader(file1));
		BufferedReader secondXML = new BufferedReader(new FileReader(file2));
		String line = FirstXML.readLine();
		String line1 = secondXML.readLine();
	    System.out.println("This Entry is Added New To The DataBase");
		while(line!=null&&line1!=null)
		{
			if(line.equals(line1))
			{
				line=FirstXML.readLine();
				line1=secondXML.readLine();
			}
			else
			{
				System.out.println(line1);
				line1=secondXML.readLine();
			}
		}
		if(line.equals(line1))
			System.out.println("same");
		else
			System.out.println("notsame");
	}

}
