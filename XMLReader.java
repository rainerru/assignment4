import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.io.File;

public class XMLReader
{

	public static void main (String[] args)
	{
		System.out.println("asdf");
		try {
		ItemList list0 = getListFromXMLFile("./input.xml");
		System.out.println("list0.getprice (155.0) = " + list0.getPrice());
		} catch ( Exception e ) { e.printStackTrace(); }
	}

	public static ItemList getListFromXMLFile ( String filename ) throws Exception
	{ 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File( filename ));
			Element root = doc.getDocumentElement();

			ItemList fullList = new ItemList("fullList");
			
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
