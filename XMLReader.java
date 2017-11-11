import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom;

public class XMLReader
{

	public void bla ()
	{ 

		//some basic code to read an xml file. TODO: hardcoded source (filename)
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("./input.xml"));
		Element root = doc.getDocumentElement();

		//some dummy code...... TODO: find a good way to access the elements and their attributes
		NodeList nl = root.getChildNodes();
		for (int i=0;i<nl.getLength();i++){
			Node n = nl.item(i);
			int type = n.getNodeType();
			if (type == Node.ELEMENT_NODE){
				Element e = (Element) n;
				System.out.println(e.getTagName() + ": " + e.getAttribute("name"));
			}
		}

	}

}
