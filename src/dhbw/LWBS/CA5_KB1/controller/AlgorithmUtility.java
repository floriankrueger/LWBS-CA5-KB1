package dhbw.LWBS.CA5_KB1.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dhbw.LWBS.CA5_KB1.model.AgeClass;
import dhbw.LWBS.CA5_KB1.model.Book;
import dhbw.LWBS.CA5_KB1.model.Children;
import dhbw.LWBS.CA5_KB1.model.Concept;
import dhbw.LWBS.CA5_KB1.model.Degree;
import dhbw.LWBS.CA5_KB1.model.Gender;
import dhbw.LWBS.CA5_KB1.model.Income;
import dhbw.LWBS.CA5_KB1.model.Married;
import dhbw.LWBS.CA5_KB1.model.Person;
import dhbw.LWBS.CA5_KB1.model.Profession;
import dhbw.LWBS.CA5_KB1.model.Star;

public class AlgorithmUtility
{
	public static Set<Concept> aqAlgo(ArrayList<Person> positiveExamples,
			ArrayList<Person> negativeExamples)
	{
		Set<Concept> k = new HashSet<Concept>();
		for (Person person : positiveExamples)
		{
			System.out.println("[BEGIN] VERSION SPACE ALGORITHM \n");
			Star s = versionSpaceAlgo(person, negativeExamples);
			System.out.println("[END] VERSION SPACE ALGORITHM \n");
			System.out.println("Star for book A: \n" + s);
			// TODO bestGeneralization
			// TODO c = c geschnitten s
			// TODO remove all persons from c that are already covered by s
		}

		return k;
	}

	public static Star versionSpaceAlgo(ArrayList<Person> positiveExamples,
			ArrayList<Person> negativeExamples)
	{
		// Declarations
		List<Concept> s = new ArrayList<Concept>(); // Menge der speziellsten Konzepte
		List<Concept> g = new ArrayList<Concept>(); // Menge der generellsten Konzepte
		// Menge der noch nicht vorgelegten Beispiele entspricht positiveExamples & negative Examples
		// Menge der bereits vorgelegten Beispiele muss nicht gefuehrt werden, da die for each 
		//  Schleife jedes Beispiel nur einmal verwendet

		// Algorithm

		s.add(Concept.getMostSpecializedConcept()); // s = {(_,...,_)}
		g.add(Concept.getMostGeneralizedConcept()); // g = {(*,...,*)}

		System.out.println("[BEGIN] POSITIVE EXAMPLES");
		
		// Positive Examples
		for (Person a : positiveExamples) // equivalent zu "solange bR != leere Menge" & "waehle a aus bR"
		{
			System.out.println("> VS <positive examples>: Person "
					+ a.toConceptString());

			for (Concept c : s) // ersetze all H aus G mit H(a) = 0 usw.
			{
				System.out.print(">> VS <positive examples>: Concept " + c
						+ " -> ");
				generalize(a, c);
				System.out.println(c);
			}
		}
		
		System.out.println("[END] POSITIVE EXAMPLES\n");
		System.out.println("[BEGIN] NEGATIVE EXAMPLES");
		
		// Negative Examples
		for (Person a : negativeExamples) // equivalent zu "solange bR != leere Menge" & "waehle a aus bR"
		{
			System.out.println("> VS <negative examples>: Person "
					+ a.toConceptString());
			
			// Loesche alle Konzepte aus S, die gleich a sind
			deleteEqualConcepts(s, a);

			// Wenn s leer ist, dann war das letzte negative Beispiel gleich dem letzten Konzept aus s
			// und der Algorithmus ist fehlgeschlagen
			if (s.isEmpty())
			{
				System.out.println("> VS algorithm terminated without success because of drained \"S\"");
				return null;
			}

			// Ersetze alle H e G, die a als Beispiel haben, durch die allgemeinste
			// Spezialisierung von H, die a nicht enhaelt (jedoch alle bisher vorgelegten
			// positiven Beispiele!)

			System.out.println(">> [BEGIN] specializing");
			
			Set<Concept> toBeInserted_g = new HashSet<Concept>();
			Set<Concept> toBeDeleted_g = new HashSet<Concept>();

			System.out.println(">>> Iterating over concepts of \"G\"");
			
			for (Concept cG : g)
			{
				System.out.println(">>>> VS <concept of g>: " + cG);
				
				// Wenn das Beispiel a Teilmenge des aktuellen Konzepts cG ist
				if (cG.covers(a))
				{
					System.out.println(">>>> " + cG + " covers " + a.toConceptString());
					
					// von jedem Element aus s muss ein neues Konzept in g (toBeInserted) erstellt werden
					// bsp.: s={(a,b)} g={(a,*),(*,b)}

					for (String key : a.getAttributes().keySet())
					{
						int a_Attribute = a.getAttributes().get(key);
						int s_Attribute = s.get(0).getAttributes()
								.get(key);

						if ((a_Attribute != s_Attribute)
								|| (s_Attribute != 100)) //ALL (*) = 100
						{
							Concept c = cG.copy();
							c.setAttribute(key, s_Attribute);
							toBeInserted_g.add(c);
							
							System.out.println(">>>>> created new concept-to-be-inserted: " + c);
						}
					}
					
					// bisherige Konzepte aus g müssen gelöscht werden
					System.out.println(">>>>> " + cG + " has been marked for deletion");
					toBeDeleted_g.add(cG);
				}
				else
				{
					System.out.println(">>>> " + cG + " does not cover " + a.toConceptString());
				}
				
				System.out.println(">>>> concepts marked for deletion: " + toBeDeleted_g);
				System.out.println(">>>> concepts created: " + toBeInserted_g);

			}
			
			System.out.println(">>>> [BEGIN] deletion of marked concepts from \"G\": " + g);
			for (Concept rG : toBeDeleted_g)
			{
				g.remove(rG);
			}
			System.out.println(">>>> [END] deletion of marked concepts from \"G\": " + g + "\n");

			System.out.println(">>>> [BEGIN] inserting of new concepts to \"G\": " + g);
			//TODO schöner machen :)
			nextConcept: for (Concept iC : toBeInserted_g)
			{
				for (Concept iG : g)
				{
					if (iC.covers(iG))
					{
						System.out.println(">>>>> " + iC + " covers " + iG + " -> new concept is not added to \"G\"");
						continue nextConcept;
					}
					else
					{
						System.out.println(">>>>> " + iC + " does not cover " + iG);
					}
				}
				
				System.out.println(">>>>> added " + iC + " to \"G\"");
				g.add(iC);
			}
			System.out.println(">>>> [END] inserting of new concepts to \"G\": " + g + "\n");
			
			// Wenn g leer ist, dann ist der Algorithmus fehlgeschlagen
			if (g.isEmpty())
			{
				System.out.println("> VS algorithm terminated without success because of drained \"G\"");
				return null;
			}
			
			if(s.equals(g))
			{
				System.out.println("> VS algorithm is terminating successfully because of equal \"S\" and \"G\" (concept learned)");
				return new Star(s, g);
			}
			
		}
		System.out.println(">> [END] specializing");
		
		System.out.println("> VS algorithm is terminating successfully (no more examples to learn)");
		return new Star(s, g);
	}

	/**
	 * Matches every Concept in the Set with the given Person example and
	 * removes if they match
	 * 
	 * @param s
	 *            the Set of Concepts which should be cleared from the given
	 *            Person example
	 * @param a
	 *            the given Person example
	 */
	private static void deleteEqualConcepts(List<Concept> s, Person a)
	{
		System.out.println(">> [BEGIN] deleting equal concepts");
		for (Concept cS : s)
		{
			if (cS.equals(a))
			{
				s.remove(cS);
				System.out.println(">>> removing Concept " + cS);
			}
		}
		System.out.println(">> [END] deleting equal concepts");
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
		// TODO implement
	}

	public static Book guessTheBook(Person p)
	{
		// TODO implement
		return null;
	}

	// HELPER METHODS
	private static void generalize(Person p, Concept c)
	{
		// generalize ageclass
		if (c.getAgeClass() == AgeClass.NONE)
			c.setAgeClass(p.getAgeClass());
		else if (p.getAgeClass() != c.getAgeClass())
			c.setAgeClass(AgeClass.ALL);

		// generalize gender
		if (c.getGender() == Gender.NONE)
			c.setGender(p.getGender());
		else if (p.getGender() != c.getGender())
			c.setGender(Gender.ALL);

		// generalize married
		if (c.getMarried() == Married.NONE)
			c.setMarried(p.getMarried());
		else if (p.getMarried() != c.getMarried())
			c.setMarried(Married.ALL);

		// generalize children
		if (c.getChildren() == Children.NONE)
			c.setChildren(p.getChildren());
		else if (p.getChildren() != c.getChildren())
			c.setChildren(Children.ALL);

		// generalize degree
		if (c.getDegree() == Degree.NONE)
			c.setDegree(p.getDegree());
		else if (p.getDegree() != c.getDegree())
			c.setDegree(Degree.ALL);

		// generalize profession
		if (c.getProfession() == Profession.NONE)
			c.setProfession(p.getProfession());
		else if (p.getProfession() != c.getProfession())
			c.setProfession(Profession.ALL);

		// generalize income
		if (c.getIncome() == Income.NONE)
			c.setIncome(p.getIncome());
		else if (p.getIncome() != c.getIncome())
			c.setIncome(Income.ALL);
	}
}
