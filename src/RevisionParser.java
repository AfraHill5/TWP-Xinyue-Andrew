import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class RevisionParser {
	private Document document;

	public void setUpDocument(InputStream inputStream ) throws ParserConfigurationException, IOException, SAXException {

//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(xml);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(inputStream);

	}

	public String getRevisionNode(int index, String attribute){

		NodeList children = document.getElementsByTagName("rev");
		Element element = (Element) children.item(index);
		return element.getAttribute(attribute);

//		NodeList AutherNames = document.getElementsByTagName("user");
//		NodeList RevisionTimes = document.getElementsByTagName("timestamp");
//		NodeList Revisioncomment = document.getElementsByTagName("comment");
	}

//	public Revison setRevision(int index){
//		String AutherNames = getRevisionNode(index, "user");
//		String RevisionTimes = getRevisionNode(index, "timestamp");
//		String Revisioncomment = getRevisionNode(index, "comment");
//	}
}
