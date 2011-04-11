package dhbw.LWBS.CA5_KB1.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
	private static final Logger log = Logger.getLogger(AlgorithmUtility.class);
	
	public static Set<Concept> aqAlgo(ArrayList<Person> positiveExamples,
			ArrayList<Person> negativeExamples)
	{
		BasicConfigurator.configure();
		log.setLevel(Level.DEBUG);
		
		Set<Concept> k = new HashSet<Concept>();
		for (Person person : positiveExamples)
		{
			log.debug("[BEGIN] VERSION SPACE ALGORITHM \n");
			Star s = versionSpaceAlgo(person, negativeExamples);
			log.debug("[END] VERSION SPACE ALGORITHM \n");
			log.info("\nStar: \n" + s);
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

		log.debug("[BEGIN] POSITIVE EXAMPLES");
		
		// Positive Examples
		for (Person a : positiveExamples) // equivalent zu "solange bR != leere Menge" & "waehle a aus bR"
		{
			log.debug("> VS <positive examples>: Person "
					+ a.toConceptString());

			for (Concept c : s) // ersetze all H aus G mit H(a) = 0 usw.
			{
				log.trace(">> VS <positive examples>: Concept " + c
						+ " -> ");
				generalize(a, c);
				log.trace(c);
			}
		}
		
		log.debug("[END] POSITIVE EXAMPLES\n");
		log.debug("[BEGIN] NEGATIVE EXAMPLES");
		
		// Negative Examples
		for (Person a : negativeExamples) // equivalent zu "solange bR != leere Menge" & "waehle a aus bR"
		{
			log.debug("> VS <negative examples>: Person "
					+ a.toConceptString());
			
			// Loesche alle Konzepte aus S, die gleich a sind
			deleteEqualConcepts(s, a);

			// Wenn s leer ist, dann war das letzte negative Beispiel gleich dem letzten Konzept aus s
			// und der Algorithmus ist fehlgeschlagen
			if (s.isEmpty())
			{
				log.info("> VS algorithm terminated without success because of drained \"S\"");
				return null;
			}

			// Ersetze alle H e G, die a als Beispiel haben, durch die allgemeinste
			// Spezialisierung von H, die a nicht enhaelt (jedoch alle bisher vorgelegten
			// positiven Beispiele!)

			log.trace(">> [BEGIN] specializing");
			
			Set<Concept> toBeInserted_g = new HashSet<Concept>();
			Set<Concept> toBeDeleted_g = new HashSet<Concept>();

			log.trace(">>> Iterating over concepts of \"G\"");
			
			for (Concept cG : g)
			{
				log.trace(">>>> VS <concept of g>: " + cG);
				
				// Wenn das Beispiel a Teilmenge des aktuellen Konzepts cG ist
				if (cG.covers(a))
				{
					log.trace(">>>> " + cG + " covers " + a.toConceptString());
					
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
							
							log.trace(">>>>> created new concept-to-be-inserted: " + c);
						}
					}
					
					// bisherige Konzepte aus g müssen gelöscht werden
					log.trace(">>>>> " + cG + " has been marked for deletion");
					toBeDeleted_g.add(cG);
				}
				else
				{
					log.trace(">>>> " + cG + " does not cover " + a.toConceptString());
				}
				
				log.trace(">>>> concepts marked for deletion: " + toBeDeleted_g);
				log.trace(">>>> concepts created: " + toBeInserted_g);

			}
			
			log.trace(">>>> [BEGIN] deletion of marked concepts from \"G\": " + g);
			for (Concept rG : toBeDeleted_g)
			{
				g.remove(rG);
			}
			log.trace(">>>> [END] deletion of marked concepts from \"G\": " + g + "\n");

			log.trace(">>>> [BEGIN] inserting of new concepts to \"G\": " + g);
			//TODO schöner machen :)
			nextConcept: for (Concept iC : toBeInserted_g)
			{
				for (Concept iG : g)
				{
					if (iC.covers(iG))
					{
						log.trace(">>>>> " + iC + " covers " + iG + " -> new concept is not added to \"G\"");
						continue nextConcept;
					}
					else
					{
						log.trace(">>>>> " + iC + " does not cover " + iG);
					}
				}
				
				log.trace(">>>>> added " + iC + " to \"G\"");
				g.add(iC);
			}
			log.trace(">>>> [END] inserting of new concepts to \"G\": " + g + "\n");
			
			// Wenn g leer ist, dann ist der Algorithmus fehlgeschlagen
			if (g.isEmpty())
			{
				log.info("> VS algorithm terminated without success because of drained \"G\"");
				return null;
			}
			
			if(s.equals(g))
			{
				log.info("> VS algorithm is terminating successfully because of equal \"S\" and \"G\" (concept learned)");
				return new Star(s, g);
			}
			
		}
		log.trace(">> [END] specializing");
		
		log.info("> VS algorithm is terminating successfully (no more examples to learn)");
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
		log.trace(">> [BEGIN] deleting equal concepts");
		for (Concept cS : s)
		{
			if (cS.equals(a))
			{
				s.remove(cS);
				log.trace(">>> removing Concept " + cS);
			}
		}
		log.trace(">> [END] deleting equal concepts");
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
