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
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(inputStream);
	}

	public ArrayList<Revision> getRevisionTopicList(){
		NodeList children = document.getElementsByTagName("rev");
		return setRevisionTopicList(children);
	}

	public ArrayList<Revision> getRevisionUserList(String userName){
		NodeList children = document.getElementsByTagName("rev");
		return setRevisionUserList(children, userName);
	}

	public ArrayList<Revision> setRevisionTopicList(NodeList revision){
		ArrayList<Revision> revisionTopicList = new ArrayList<Revision>();
		for(int i=0;i< Integer.parseInt(UrlUserNumber);i++) {
			Element revisionElement = (Element) revision.item(i);
			Revision revisionItem = new Revision();
			revisionItem = revisionItem.setUpRevision(revisionElement.getAttribute("user"),
					revisionElement.getAttribute("timestamp"),
					revisionElement.getAttribute("comment"));
			revisionTopicList.add(revisionItem);
		}
		return revisionTopicList;
	}

	public ArrayList<Revision> setRevisionUserList(NodeList revision, String userName){
		ArrayList<Revision> revisionUserList = new ArrayList<Revision>();
		for(int i=0;i< Integer.parseInt(UrlUserNumber);i++) {
			Element revisionElement = (Element) revision.item(i);
			if(revisionElement.getAttribute("user").equalsIgnoreCase(userName)){
				Revision revisionItem = new Revision();
				revisionItem = revisionItem.setUpRevision(revisionElement.getAttribute("user"),
						revisionElement.getAttribute("timestamp"),
						revisionElement.getAttribute("comment"));
				revisionUserList.add(revisionItem);
			}
		}
		return revisionUserList;
	}

}
