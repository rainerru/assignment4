public class Book extends Item
{

	protected int ISBN;

	public Book ( String newName, double newPrice , int newISBN )
	{
		super(newName,newPrice);
		this.ISBN = newISBN;
	}

	public int getISBN () { return this.ISBN; }

	public void setISBN ( int newISBN ) { this.ISBN = newISBN; }

}
