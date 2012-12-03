import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ReadNames {

	//Constructor
	public ReadNames()
	{
		
	}
	
	/*
	 * Method that checks if the "name" the user passed in has "met" LoLTalk before by scanning a 
	 * text document which contains the saved user names. If LoLTalk has not "met" the user before it will export new 
	 * user Name into the text document to remember it in the future.
	 */
	public boolean metBefore(String name)
	{
		
		//For reading through text documents
		FileInputStream fileInput = null;
		DataInputStream dataInput = null; 
		
			
		boolean met = false; 
		String readName;
		
		try
		{
			fileInput = new FileInputStream("userNames.txt");
			dataInput = new DataInputStream(fileInput);
			
			//Reads through the document "userNames.txt"
			while(dataInput.available()>0)
			{
				
				readName = dataInput.readLine();
				
				if (readName.equalsIgnoreCase(name))
				{
					met = true;
				}
				
			}
				
		}
		
		//Possible file reader exceptions to be caught
		catch (FileNotFoundException e)
		{
			System.out.println("Could not find the names document");
		}
		
		catch (IOException e)
		{
			System.out.println("IO Error");
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{	
			fileInput.close();	//Closes userNames.txt	after reading
		}
		catch(Exception e)
		{
			System.out.println("userNames.txt document did not close after reading");
		}
		
		
		//If LoLTalk has not "met" the user before it writes the new user name into "userNames.txt"
		if (!met)
		{
			try
			{
				 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("userNames.txt", true)));
				    out.println(name);
				   
				    try
				    {
				    out.close();
				    }
				    
				    catch (Exception e)
				    {
				    	System.out.println("userNames.txt did not close after writing");
				    }
				
				
			}
			catch(IOException e)
			{
				System.out.println("IO Error");
			}
		}			
		return met;		
	}			
}
