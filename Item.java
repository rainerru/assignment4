public class Item
{

	protected String name;
	protected double price;

	public Item ( String newName ) { this.name = newName; };

	public Item ( String newName, double newPrice )
	{
		this.name = newName;
		this.price = newPrice;
	}

	public double getPrice() { return this.price; }

	public void setPrice( double newPrice ) { this.price = newPrice; }

	public String getName() { return this.name; }

	public void setName ( String newName ) { this.name = newName; }

}
