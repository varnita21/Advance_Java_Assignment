package compare;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import junit.framework.Assert;

class CompareClassTest {
	final String file1 = "D:\\Eclipse\\xmlFile1.xml";
	final String file2 = "D:\\Eclipse\\file.xml";
	@Test
	void test() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setCoalescing(true);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setIgnoringComments(true);
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc1 = db.parse(new File("file1.xml"));
		doc1.normalizeDocument();

		Document doc2 = db.parse(new File("file2.xml"));
		doc2.normalizeDocument();
		Assert.assertTrue(doc1.isEqualNode(doc2));
	}

}
