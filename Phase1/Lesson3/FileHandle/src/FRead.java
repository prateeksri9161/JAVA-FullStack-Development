import java.io.FileReader;
import java.io.IOException;
public class FRead
{
	public static void main(String[] args)
	{
		char[] data = new char[100];
		try{
			FileReader input = new FileReader("File.txt");
			input.read(data);
			System.out.println("Data Received From A File");
			System.out.println(data);
			input.close();
		}
		catch(IOException ex) 
		{
			System.out.println("File read error...");
		}
	}
}