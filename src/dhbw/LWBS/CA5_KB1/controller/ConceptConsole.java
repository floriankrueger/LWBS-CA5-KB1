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
		
		return c;
	}

	/**
	 * 
	 */
	public boolean continueTesting()
	{
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
		
		return stillReading;
	}

	/**
	 * @param c
	 */
	private void readAgeClass(Concept c)
	{
		AgeClass tmp = null;
		
		do {
			System.out.print(AgeClass.NAME + " : ");
			
			try
			{
				tmp = AgeClass.fromString(reader.readLine());
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (tmp == null);
		
		c.setAgeClass(tmp);
	}

	/**
	 * @param c
	 */
	private void readGender(Concept c)
	{
		Gender tmp = null;
		
		do {
			System.out.print(Gender.NAME + " : ");
			
			try
			{
				tmp = Gender.fromString(reader.readLine());
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (tmp == null);
		
		c.setGender(tmp);
	}
	
	/**
	 * @param c
	 */
	private void readMarried(Concept c)
	{
		Married tmp = null;
		
		do {
			System.out.print(Married.NAME + " : ");
			
			try
			{
				tmp = Married.fromString(reader.readLine());
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (tmp == null);
		
		c.setMarried(tmp);
	}
	
	/**
	 * @param c
	 */
	private void readChildren(Concept c)
	{
		Children tmp = null;
		
		do {
			System.out.print(Children.NAME + " : ");
			
			try
			{
				tmp = Children.fromString(reader.readLine());
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (tmp == null);
		
		c.setChildren(tmp);
	}
	
	/**
	 * @param c
	 */
	private void readDegree(Concept c)
	{
		Degree tmp = null;
		
		do {
			System.out.print(Degree.NAME + " : ");
			
			try
			{
				tmp = Degree.fromString(reader.readLine());
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (tmp == null);
		
		c.setDegree(tmp);
	}
	
	/**
	 * @param c
	 */
	private void readProfession(Concept c)
	{
		Profession tmp = null;
		
		do {
			System.out.print(Profession.NAME + " : ");
			
			try
			{
				tmp = Profession.fromString(reader.readLine());
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (tmp == null);
		
		c.setProfession(tmp);
	}
	
	/**
	 * @param c
	 */
	private void readIncome(Concept c)
	{
		Income tmp = null;
		
		do {
			System.out.print(Income.NAME + " : ");
			
			try
			{
				tmp = Income.fromString(reader.readLine());
			}
			catch (IOException ioe) 
			{
				System.err.println("IO error, please try again.");
			}
		} while (tmp == null);
		
		c.setIncome(tmp);
	}
}
