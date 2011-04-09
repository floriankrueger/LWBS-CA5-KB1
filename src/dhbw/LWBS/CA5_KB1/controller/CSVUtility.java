package dhbw.LWBS.CA5_KB1.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class CSVUtility
{
	String line = "";
	Queue<String[]> persons = new LinkedList<String[]>();

	public CSVUtility(String fileName)
	{
		try
		{
			BufferedReader readCSV = new BufferedReader(
					new FileReader(fileName));

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

	public String[] getPerson()
	{
		return persons.poll();
	}

}
