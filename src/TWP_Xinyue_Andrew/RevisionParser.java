package TWP_Xinyue_Andrew;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static TWP_Xinyue_Andrew.URLFactory.UrlUserNumber;

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

//	public String getRevisionNode(int index, String attribute){
//
//		NodeList children = document.getElementsByTagName("rev");
//		Element element = (Element) children.item(index);
//		return element.getAttribute(attribute);
//	}
//
//	public Revision setRevision(int index){
//		String AuthorName = getRevisionNode(index, "user");
//		String RevisionTime = getRevisionNode(index, "timestamp");
//		String RevisionComment = getRevisionNode(index, "comment");
//		Revision revision = new Revision();
//		revision.setUpRevision(AuthorName, RevisionTime, RevisionComment);
//		return revision;
//	}

	public ArrayList<Revision> setRevisionList(NodeList revision){
		ArrayList<Revision> revisionList = new ArrayList<Revision>();
		for(int i=0;i< Integer.parseInt(UrlUserNumber);i++) {
			Element revisionElement = (Element) revision.item(i);
			Revision revisionItem = new Revision();
			revisionItem = revisionItem.setUpRevision(revisionElement.getAttribute("user"),
					revisionElement.getAttribute("timeStamp"),
					revisionElement.getAttribute("comment"));
			revisionList.add(revisionItem);
		}
		return revisionList;
	}

	public ArrayList<Revision> getRevisionList(){
		NodeList children = document.getElementsByTagName("rev");
		return setRevisionList(children);
	}
}
