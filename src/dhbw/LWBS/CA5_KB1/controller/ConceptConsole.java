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

/**
 * TODO class doc
 * 
 */
public class ConceptConsole
{
	private BufferedReader reader;
	private boolean stillReading;

	/**
	 * Class constructor
	 */
	public ConceptConsole()
	{
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.stillReading = true;
	}

	/**
	 * TODO readConcept
	 * 
	 * @return
	 */
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
	 * TODO continueTesting
	 */
	public boolean continueTesting()
	{
		// prompt to continue reading
		System.out.print("Do you want to test more persons? (y/n) :");

		try
		{
			if (reader.readLine().equals("n"))
				stillReading = false;
		}
		catch (IOException ioe)
		{
			System.err.println("IO error, please try again.");
		}

		return stillReading;
	}

	/**
	 * Prompts for <code>AgeClass</code> and checks if the user's input is of
	 * type <code>AgeClass</code>. If the user's input is a constant of
	 * <code>AgeClass</code> it is saved to the given <code>Concept</code>. If
	 * not the user is prompted for a new input.
	 * 
	 * @param c
	 *            <code>Concept</code> in which to write user's input
	 */
	private void readAgeClass(Concept c)
	{
		AgeClass tmp = null;

		do
		{
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
	 * Prompts for <code>Gender</code> and checks if the user's input is of type
	 * <code>Gender</code>. If the user's input is a constant of
	 * <code>Gender</code> it is saved to the given <code>Concept</code>. If not
	 * the user is prompted for a new input.
	 * 
	 * @param c
	 *            <code>Concept</code> in which to write user's input
	 */
	private void readGender(Concept c)
	{
		Gender tmp = null;

		do
		{
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
	 * Prompts for <code>Married</code> and checks if the user's input is of
	 * type <code>Married</code>. If the user's input is a constant of
	 * <code>Married</code> it is saved to the given <code>Concept</code>. If
	 * not the user is prompted for a new input.
	 * 
	 * @param c
	 *            <code>Concept</code> in which to write user's input
	 */
	private void readMarried(Concept c)
	{
		Married tmp = null;

		do
		{
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
	 * Prompts for <code>Children</code> and checks if the user's input is of
	 * type <code>Children</code>. If the user's input is a constant of
	 * <code>Children</code> it is saved to the given <code>Concept</code>. If
	 * not the user is prompted for a new input.
	 * 
	 * @param c
	 *            <code>Concept</code> in which to write user's input
	 */
	private void readChildren(Concept c)
	{
		Children tmp = null;

		do
		{
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
	 * Prompts for <code>Degree</code> and checks if the user's input is of type
	 * <code>Degree</code>. If the user's input is a constant of
	 * <code>Degree</code> it is saved to the given <code>Concept</code>. If not
	 * the user is prompted for a new input.
	 * 
	 * @param c
	 *            <code>Concept</code> in which to write user's input
	 */
	private void readDegree(Concept c)
	{
		Degree tmp = null;

		do
		{
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
	 * Prompts for <code>Profession</code> and checks if the user's input is of
	 * type <code>Profession</code>. If the user's input is a constant of
	 * <code>Profession</code> it is saved to the given <code>Concept</code>. If
	 * not the user is prompted for a new input.
	 * 
	 * @param c
	 *            <code>Concept</code> in which to write user's input
	 */
	private void readProfession(Concept c)
	{
		Profession tmp = null;

		do
		{
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
	 * Prompts for <code>Income</code> and checks if the user's input is of type
	 * <code>Income</code>. If the user's input is a constant of
	 * <code>Income</code> it is saved to the given <code>Concept</code>. If not
	 * the user is prompted for a new input.
	 * 
	 * @param c
	 *            <code>Concept</code> in which to write user's input
	 */
	private void readIncome(Concept c)
	{
		Income tmp = null;

		do
		{
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
