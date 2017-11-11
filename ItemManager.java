import java.io.File;
import java.util.NoSuchElementException;

public class ItemManager implements Assignment4
{

	private ItemList listOfItems;

	public ItemManager () { this.listOfItems = new ItemList("listOfItems"); }

	public void loadXml(File input) throws Exception
	{
		this.listOfItems = XMLReader.getListFromXMLFile ( input );
	}

	public double getPrice(String item)
	{
		Item item0 = this.listOfItems.search(item);
		if ( item0 == null )
			throw new NoSuchElementException("Can't find an element with name " + item + ".");
		return item0.getPrice();
	}

}
