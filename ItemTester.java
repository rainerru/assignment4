import java.lang.RuntimeException;

public class ItemTester
{

	public static void main ( String[] args )
	{

		ItemList list0 = new ItemList("list0");
		Item cd0 = new Cd("cd0",20);
		Item cd1 = new Cd("cd1",40);
		Item book0 = new Book("book0",15,1234);
		Item book1 = new Book("book1",10.5,5678);
		ItemList list1 = new ItemList("list1");
		list1.add(cd1);
		list1.add(book1);
		list0.add(cd0);
		list0.add(book0);
		list0.add(list1);

		System.out.println("cd0 price (20) = " + cd0.getPrice());
		System.out.println("book1 price (10.5) = " + book1.getPrice());
		System.out.println("list1.price (50.5) = " + list1.getPrice());
		System.out.println("list0.price (85.5) = " + list0.getPrice());

		try {
		Item bla = list0.search("cd1");
		System.out.println("cd1 price (40) = " + bla.getPrice());

		bla = list0.search("list0");
		System.out.println("list0 price (80.5) = " + bla.getPrice());

		bla = list0.search("list1");
		System.out.println("list1 price (50.5) = " + bla.getPrice());


		Item bla1 = list0.search("cd25");
 		if (bla1 == null) {throw new RuntimeException("can't find it!");} 
		} catch ( Exception e ) { throw new RuntimeException("can't find it!"); }


	}

}
