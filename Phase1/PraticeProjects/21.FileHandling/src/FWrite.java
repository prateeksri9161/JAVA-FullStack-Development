import java.io.FileWriter;
import java.io.IOException;
public class FWrite
{
	public static void main(String[] args)
	{
		String data = "I Am a Programmer";
		try{
			FileWriter output = new FileWriter("File.txt");
			output.write(data);
			System.out.println("Data is Written Sucessfully");
			System.out.println(data);
			output.close();
		}
		catch(IOException ex) 
		{
			System.out.println("File write error...");
		}
	}
}