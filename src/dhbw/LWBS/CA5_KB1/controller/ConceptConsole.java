package dhbw.LWBS.CA5_KB1.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dhbw.LWBS.CA5_KB1.model.AgeClass;
import dhbw.LWBS.CA5_KB1.model.Children;
import dhbw.LWBS.CA5_KB1.model.Concept;
import dhbw.LWBS.CA5_KB1.model.Degree;
import dhbw.LWBS.CA5_KB1.model.Gender;
import dhbw.LWBS.CA5_KB1.model.Income;
import dhbw.LWBS.CA5_KB1.model.Married;
import dhbw.LWBS.CA5_KB1.model.Profession;

public class ConceptConsole
{
	private BufferedReader reader;
	private boolean stillReading;
	
	public ConceptConsole()
	{
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.stillReading = true;
	}
	
	public Concept readConcept()
	{
		// the concept to be tested
		Concept c = Concept.getMostSpecializedConcept();
		
		System.out.println("Please enter the attributes of the person to be tested (blank for \"_\")\n");
		
		readAgeClass(c);
		readGender(c);
		readMarried(c);
		readChildren(c);
		readDegree(c);
		readProfession(c);
		readIncome(c);
		
		System.out.println();
		
		// prompt to continue reading
		System.out.print("Do you want to test more persons? (y/n) :");
		
		try 
		{
			if( reader.readLine().equals("n") )
				stillReading = false;
		} 
		catch (IOException ioe) 
		{
			System.err.println("IO error, please try again.");
		}
		
		return c;
	}

	/**
	 * @param c
	 */
	private void readAgeClass(Concept c)
	{
		do {
			System.out.print(AgeClass.NAME + " : ");
			
			try
			{
				c.setAgeClass(AgeClass.fromString(reader.readLine()));
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (c.getAgeClass() == null);
	}

	/**
	 * @param c
	 */
	private void readGender(Concept c)
	{
		do {
			System.out.print(Gender.NAME + " : ");
			
			try
			{
				c.setGender(Gender.fromString(reader.readLine()));
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (c.getGender() == null);
	}
	
	/**
	 * @param c
	 */
	private void readMarried(Concept c)
	{
		do {
			System.out.print(Married.NAME + " : ");
			
			try
			{
				c.setMarried(Married.fromString(reader.readLine()));
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (c.getMarried() == null);
	}
	
	/**
	 * @param c
	 */
	private void readChildren(Concept c)
	{
		do {
			System.out.print(Children.NAME + " : ");
			
			try
			{
				c.setChildren(Children.fromString(reader.readLine()));
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (c.getChildren() == null);
	}
	
	/**
	 * @param c
	 */
	private void readDegree(Concept c)
	{
		do {
			System.out.print(Degree.NAME + " : ");
			
			try
			{
				c.setDegree(Degree.fromString(reader.readLine()));
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (c.getDegree() == null);
	}
	
	/**
	 * @param c
	 */
	private void readProfession(Concept c)
	{
		do {
			System.out.print(Profession.NAME + " : ");
			
			try
			{
				c.setProfession(Profession.fromString(reader.readLine()));
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (c.getProfession() == null);
	}
	
	/**
	 * @param c
	 */
	private void readIncome(Concept c)
	{
		do {
			System.out.print(Income.NAME + " : ");
			
			try
			{
				c.setIncome(Income.fromString(reader.readLine()));
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (c.getIncome() == null);
	}
	
	public boolean isStillReading()
	{
		return stillReading;
	}
	
}
