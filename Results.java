import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.*;

public class Results
{
	public static void main (String[] args)
	{
		BufferedReader reader = null;
		
		//Give an output for a user who hasn't supplied an argument:
		if (args.length == 0)
		{
			System.out.println("No filename specified");
			System.exit(1);
		}
		
		//Give a message if there is an fnfe error:
		try
		{
			reader = new BufferedReader(new FileReader(args[0]));
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Error on opening file data");
			System.exit(2);
		}

		ArrayList<ArrayList<String>> resultsArray = new ArrayList<ArrayList<String>>();
		String inputLine="";
		int rowCount = 0;
		
		// Do stuff until we reach the end of our document:
		while (inputLine != null)
		{
			
			try
			{
					// Our last iteration was not null so we scan the line after that i.e. the line
					// corresponding to our current iteration (it may be null):
					inputLine = reader.readLine();
					
			}
			
			catch (IOException ioe)
			{
					System.out.println("Error on opening file data");
					System.exit(3);
			}
			
			// We check that we are not at null (i.e end of doc) on our current iteration:
			if (inputLine != null)
			{
				
				// if the line we are on is not a blank line we add this to our array:
				if (inputLine.length() > 0)
				{
					
						StringTokenizer tokenizer = new StringTokenizer(inputLine);
						ArrayList<String> row = new ArrayList<String>();
						
						while(tokenizer.hasMoreTokens())
						{
							row.add(tokenizer.nextToken());
							
						}
						
						resultsArray.add(row);
						rowCount++;
				}
			}

			
		}
		
		if (rowCount == 0)
			System.out.println("This document is empty!");
		else
		{
			bubble(resultsArray, rowCount);
			System.out.println("Name" + "       " + "Mark");
			for (int i = 0; i < rowCount; i++)
			{
				
				String formattedString = String.format("%-10s %3s ", resultsArray.get(i).get(1) + " " + resultsArray.get(i).get(0), resultsArray.get(i).get(2));
				System.out.println(formattedString);
			}
			
		}
		
	}
	
	public static void bubble (ArrayList<ArrayList<String>> resultsArray, int rowCount)
	{
		int i, j;
		ArrayList<String> temp;
		
		for ( i = 0; i < rowCount - 1; i++)
		{
			for ( j = rowCount - 1; j > i; j--)
			{
				if( Integer.parseInt(resultsArray.get(j).get(2)) < Integer.parseInt(resultsArray.get(j - 1).get(2)) )
				{
					temp = resultsArray.get(j);
					resultsArray.set(j, resultsArray.get(j - 1));
					resultsArray.set( j - 1 , temp );
					
				}
			}
		}
	}
	
	
}