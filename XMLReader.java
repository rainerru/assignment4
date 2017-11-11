import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;

public class XMLReader
{

	public static ItemList getListFromXMLFile ( File filename ) throws Exception
	{ 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(filename);
			Element root = doc.getDocumentElement();

			ItemList fullList = new ItemList("root");
			
			addListToList(root,fullList);

			return fullList;
	}

	private static void addListToList ( Element e, ItemList list )
	{
		NodeList listOfNodes = e.getChildNodes();

		for (int i=0;i<listOfNodes.getLength();i++){

			Node currentNode = listOfNodes.item(i);
			int type = currentNode.getNodeType();

			if (type == Node.ELEMENT_NODE){

				Element currentElement = (Element) currentNode;
				if ( currentElement.getTagName().equals("list") )
					addListToList ( currentElement, list );
				else 
					addElementToList ( currentElement, list );

			}
		}
	} 

	private static void addElementToList ( Element currentElement, ItemList list )
	{
		if ( currentElement.getTagName().equals("book") )
		{
			Item newItem = new Book(currentElement.getAttribute("name"),
				Double.parseDouble(currentElement.getAttribute("price")),
				Integer.parseInt(currentElement.getAttribute("isbn")));
			list.add(newItem);
		} else
		if ( currentElement.getTagName().equals("cd") )
		{
			Item newItem = new Cd(currentElement.getAttribute("name"),
				Double.parseDouble(currentElement.getAttribute("price")));
			list.add(newItem);
		} else
		{
			Item newItem = new Item(currentElement.getAttribute("name"),
				Double.parseDouble(currentElement.getAttribute("price")));
			list.add(newItem);
		} 
	} 

}
