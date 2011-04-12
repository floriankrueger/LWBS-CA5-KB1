package dhbw.LWBS.CA5_KB1.controller;

import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.collections.ListUtils;

import dhbw.LWBS.CA5_KB1.model.Book;
import dhbw.LWBS.CA5_KB1.model.Concept;
import dhbw.LWBS.CA5_KB1.model.Person;

/**
 * TODO class doc
 * 
 * 
 */
public class CA5_KB1
{
	/**
	 * TODO main
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		String trainingData = "gruppe_ca5_kb1.csv";
		String proofData = null;

		// TODO Switch? Stimmt das so?
		switch (args.length)
		{
		case 1:
			trainingData = args[0];

		case 2:
			proofData = args[1];
			break;
		}

		/*
		 * if (args.length == 1) { trainingData = args[0]; } else if
		 * (args.length == 2) { trainingData = args[0]; proofData = args[1]; }
		 */

		ArrayList<Person> trainingPersons;
		ArrayList<Person> proofPersons;
		ArrayList<Person> bookA = new ArrayList<Person>();
		ArrayList<Person> bookB = new ArrayList<Person>();
		ArrayList<Person> bookC = new ArrayList<Person>();

		System.out.print("Reading data for training from: " + trainingData
				+ " ..");
		trainingPersons = importPersons(trainingData);
		System.out.println(" done\n");
		System.out.print("Populating example sets for each book ..");
		populateBookLists(trainingPersons, bookA, bookB, bookC);
		System.out.println(" done\n");

		System.out.println("[ENTERING AQ ALGORITHM FOR BOOK A] |||||||||||||||||||||||| \n");
		Set<Concept> c_bookA = AlgorithmUtility.aqAlgo(bookA, mergeLists(bookB, bookC));
		System.out.println("[FINISHED AQ ALGORITHM FOR BOOK A] |||||||||||||||||||||||| \n");

		/*
		 * Set<Concept> c_bookB = AlgorithmUtility.aqAlgo(bookB,
		 * mergeLists(bookA, bookC)); Set<Concept> c_bookC =
		 * AlgorithmUtility.aqAlgo(bookC, mergeLists(bookA, bookB));
		 */

		if (proofData == null)
		{
			System.out.println("No proof data given, stepping out");
			return;
		}

		proofPersons = importPersons(proofData);
		for (Person person : proofPersons)
		{
			Book result = AlgorithmUtility.guessTheBook(person);
			System.out.println("Proof " + person.getNumber() + ": "
					+ result.toString());
		}

	}

	/**
	 * Appends two given lists and returns this as a new list.
	 * 
	 * @param a
	 *            list containing <code>Persons</code>
	 * @param b
	 *            list containing <code>Persons</code>
	 * @return concatenated list containing <code>Persons</code>
	 */
	@SuppressWarnings("unchecked")
	private static ArrayList<Person> mergeLists(ArrayList<Person> a,
			ArrayList<Person> b)
	{
		return new ArrayList<Person>(ListUtils.union(a, b));
	}

	/**
	 * Fills the given lists with the examples of the first list according to
	 * the book's type. Example: Person example that has chosen Book A. This
	 * example will be filled into the first given list called bookA.
	 * 
	 * @param allPersons
	 *            list containing all <code>Person</code> examples
	 * @param bookA
	 *            list to be filled with examples of type <code>Person</code>
	 * @param bookB
	 *            list to be filled with examples of type <code>Person</code>
	 * @param bookC
	 *            list to be filled with examples of type <code>Person</code>
	 */
	private static void populateBookLists(ArrayList<Person> allPersons,
			ArrayList<Person> bookA, ArrayList<Person> bookB,
			ArrayList<Person> bookC)
	{
		for (Person person : allPersons)
		{
			switch (person.getBook())
			{
			case BOOK_A:
				bookA.add(person);
				break;

			case BOOK_B:
				bookB.add(person);
				break;

			case BOOK_C:
				bookC.add(person);
				break;
			}
		}
		System.out.print(" A: " + bookA.size());
		System.out.print(" B: " + bookB.size());
		System.out.print(" C: " + bookC.size());
	}

	/**
	 * Fills a list with examples of type <code>Person</code> from the specified
	 * file and returns it afterwards.
	 * 
	 * @param fileName
	 *            name of the file in which the data is found
	 * @return list containing examples of type <code>Person</code>
	 */
	private static ArrayList<Person> importPersons(String fileName)
	{
		String[] currentPerson = null;
		ArrayList<Person> p = new ArrayList<Person>();
		CSVUtility readFile = new CSVUtility(fileName);
		while ((currentPerson = readFile.getPerson()) != null)
		{
			p.add(new Person(currentPerson));
		}
		System.out.println(p.size());
		return p;
	}

}
