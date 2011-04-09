package dhbw.LWBS.CA5_KB1.controller;

import java.util.ArrayList;

import dhbw.LWBS.CA5_KB1.model.Book;
import dhbw.LWBS.CA5_KB1.model.Concept;
import dhbw.LWBS.CA5_KB1.model.Person;
import dhbw.LWBS.CA5_KB1.model.Star;

public class AlgorithmUtility
{
	public static Concept aqAlgo(ArrayList<Person> positiveExamples,
			ArrayList<Person> negativeExamples)
	{
		Concept c = new Concept();
		for (Person person : positiveExamples)
		{
			Star s = versionSpaceAlgo(person, negativeExamples);
			// TODO bestGeneralization
			// TODO c = c geschnitten s
			// TODO remove all persons from c that are already covered by s

		}

		return c;
	}

	public static Star versionSpaceAlgo(ArrayList<Person> positiveExamples,
			ArrayList<Person> negativeExamples)
	{
		// TODO implement
		return null;
	}

	private static Star versionSpaceAlgo(Person posExample,
			ArrayList<Person> negExamples)
	{
		ArrayList<Person> posExamples = new ArrayList<Person>();
		posExamples.add(posExample);
		return versionSpaceAlgo(posExamples, negExamples);
	}

	public static void bestGeneralization()
	{
		//TODO implement
	}

	public static Book guessTheBook(Person p)
	{
		//TODO implement
		return null;
	}
}
