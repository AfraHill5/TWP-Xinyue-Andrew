import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;


public class JavaXmlParserTest {

	private Document document;

	@Before
	public  void setUp() throws ParserConfigurationException, IOException, SAXException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("example.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(inputStream);
	}

	@Test
	public void testReadFirstElement(){
		NodeList children = document.getChildNodes();
		Element firstElement = (Element)children.item(0);
		Assert.assertEquals("api",firstElement.getNodeName());
	}

	@Test
	public void testReadFirstNewsUserName(){
		NodeList items = document.getElementsByTagName("rev");
		Element revisionElement = (Element) items.item(0);
		String user = revisionElement.getAttribute("user");
		Assert.assertEquals("Dr. British12",user);
	}
}
