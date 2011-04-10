package dhbw.LWBS.CA5_KB1.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
			Star s = versionSpaceAlgo(person, negativeExamples);
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
		Set<Person> bV = new LinkedHashSet<Person>(); 	// Menge der bereits vorgelegten Beispiele
		Set<Concept> s = new LinkedHashSet<Concept>(); 	// Menge der speziellsten Konzepte
		Set<Concept> g = new LinkedHashSet<Concept>(); 	// Menge der generellsten Konzepte
		// Menge der noch nicht vorgelegten Beispiele entspricht positiveExamples & negative Examples
		
		// Algorithm
		
		s.add(Concept.getMostSpecializedConcept());	// s = {(_,...,_)}
		g.add(Concept.getMostGeneralizedConcept()); // g = {(*,...,*)}
		
		// Positive Examples
		for (Person a : positiveExamples) // equivalent zu "solange bR != leere Menge" & "waehle a aus bR"
		{
			System.out.println("VS <positive examples>: Person " + a.toConceptString());
			
			bV.add(a); // Setze bV = bV vereinigt mit {a}
			
			for (Concept c : s) // ersetze all H aus G mit H(a) = 0 usw.
			{
				System.out.print("VS <positive examples>: Concept " + c + " -> ");
				generalize(a,c);
				System.out.println(c);
			}
		}
		
		// Negative Examples
		for (Person a : negativeExamples) // equivalent zu "solange bR != leere Menge" & "waehle a aus bR"
		{
			// Loesche alle Konzepte aus S, die gleich a sind
			deleteEqualConcepts(s, a);
			
			// Wenn s leer ist, dann war das letzte negative Beispiel gleich dem letzten Konzept aus s
			// und der Algorithmus ist fehlgeschlagen
			if (s.isEmpty())
			{
				return null;
			}
			
			// Ersetze alle H e G, die a als Beispiel haben, durch die allgemeinste
			// Spezialisierung von H, die a nicht enhaelt (jedoch alle bisher vorgelegten
			// positiven Beispiele!)
			
			Set<Concept> toBeInserted_g = new HashSet<Concept>();
			Set<Concept> toBeDeleted_g = new HashSet<Concept>();
			
			for (Concept cG : g)
			{
				// Wenn das Beispiel a Teilmenge des aktuellen Konzepts cG ist
				if (cG.covers(a))
				{
					// TODO: Continue
				}
			}
		}

		return null;
	}

	/**
	 * Matches every Concept in the Set with the given Person example and removes if they match
	 * 
	 * @param s	the Set of Concepts which should be cleared from the given Person example
	 * @param a the given Person example
	 */
	private static void deleteEqualConcepts(Set<Concept> s, Person a)
	{
		for (Concept cS : s)
		{
			if (cS.equals(a)) 
			{
				s.remove(cS);
			}
		}
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
