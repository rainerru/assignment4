import java.io.File;

public class ManagerTester
{

	public static void main (String[] args)
	{
		System.out.println("asdf");
		ItemManager m0 = new ItemManager();

		try {
			m0.loadXml(new File("./input.xml"));
		} catch ( Exception e ) { e.printStackTrace(); }		

		System.out.println("m0.getPrice(\"root\")  (155.0) = " + m0.getPrice("root"));
		System.out.println("m0.getPrice(\"B1\") (30) = " + m0.getPrice("B1"));
		System.out.println("m0.getPrice(\"B000\") (not here) = " + m0.getPrice("B0000"));

	}
}
