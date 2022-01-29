import java.io.FileWriter;
import java.io.IOException;
public class FAppend
{
	public static void main(String[] args)
	{
		String data = "Working in JAVA";
		try{
			FileWriter output = new FileWriter("File.txt", true);
			output.write(data);
			System.out.println("Data is Append Sucessfully");
			System.out.println(data);
			output.close();
		}
		catch(IOException ex) 
		{
			System.out.println("File append error...");
		}
	}
}