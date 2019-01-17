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
		final String xmlPath1 = "D:\\Eclipse\\xmlFile1.xml";
		final String xmlPath2 = "D:\\Eclipse\\xmlFile.xml";
		
		File xmlfile1 = new File(xmlPath1);
		File xmlfile2 = new File(xmlPath2);
		BufferedReader xml1 = new BufferedReader(new FileReader(xmlfile1));
		BufferedReader xml2 = new BufferedReader(new FileReader(xmlfile2));
		String st1 = xml1.readLine();
		String st2 = xml2.readLine();
	    System.out.println("This Entry is Added New To The DataBase");
		while(st1!=null&&st2!=null)
		{
			if(st1.equals(st2))
			{
				st1=xml1.readLine();
				st2=xml2.readLine();
			}
			else
			{
				System.out.println(st2);
				st2=xml2.readLine();
			}
		}
		if(st1.equals(st2))
			System.out.println("same");
		else
			System.out.println("notsame");
	}

}
