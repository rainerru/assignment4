import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItemList extends Item
{

	protected LinkedList<Item> listOfItems;

	public ItemList ( String newName )
	{
		super(newName);
		this.listOfItems = new LinkedList<Item>();
	}

	public void add ( Item newItem ) { this.listOfItems.add(newItem); }

	public double getPrice ()
	{
		double fullPrice = 0;

		Iterator<Item> itemIterator = listOfItems.iterator();
		while ( itemIterator.hasNext() ) {
			fullPrice += itemIterator.next().getPrice();
		}

		return fullPrice;
	}

	public Item search ( String name ) // throws Exception;;; instead: return null and then throw exception in another class if search returns null;
	{
		if ( this.getName().equals(name) ) return this;

		Iterator<Item> itemIterator = listOfItems.iterator();
		Item currentItem;
		while ( itemIterator.hasNext() ) {

			currentItem = itemIterator.next();
			if ( currentItem.getName().equals(name) ) return currentItem;
			if ( currentItem instanceof ItemList )
			{
 				currentItem = ((ItemList)currentItem).search(name);
				if ( currentItem != null ) return currentItem;
			}

		}
		return null;
	}

}
