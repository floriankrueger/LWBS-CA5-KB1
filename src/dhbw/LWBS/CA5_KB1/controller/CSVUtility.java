package dhbw.LWBS.CA5_KB1.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO class doc
 * 
 * Each example is put into a <code>Queue</code> so the first
 * example that is put into it is also pulled out first.
 * 
 */
public class CSVUtility
{
	String line = "";
	Queue<String[]> persons = new LinkedList<String[]>();

	/**
	 * Class Constructor specifying the data file's name where to pull the data.
	 * 
	 * @param fileName
	 *            data file's name
	 */
	public CSVUtility(String fileName)
	{
		try
		{
			BufferedReader readCSV = new BufferedReader(new FileReader(fileName));

			//skip the first line
			readCSV.readLine();
			while ((line = readCSV.readLine()) != null)
			{
				persons.offer(line.split(";"));
			}
			readCSV.close();

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Extracts one <code>Person</code> after another from the list of all
	 * <code>Person</code> examples.
	 * 
	 * @return <code>String[]</code> containing one <code>Person</code> example
	 */
	public String[] getPerson()
	{
		return persons.poll();
	}

}
