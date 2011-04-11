package dhbw.LWBS.CA5_KB1.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Star
{
	private Set<Concept> specializedConcepts;
	private Set<Concept> generalizedConcepts;

	/**
	 * Class constructor
	 */
	public Star()
	{
		this(new ArrayList<Concept>(), new ArrayList<Concept>());
	}

	/**
	 * Class constructor initializing a <code>HashSet</code> with each of the
	 * given lists
	 */
	public Star(List<Concept> s, List<Concept> g)
	{
		super();
		this.specializedConcepts = new HashSet<Concept>(s);
		this.generalizedConcepts = new HashSet<Concept>(g);
	}

	//Fill sets with a concept c
	public boolean addSpecializedConcept(Concept c)
	{
		return specializedConcepts.add(c);
	}

	public boolean addGeneralizedConcept(Concept c)
	{
		return generalizedConcepts.add(c);
	}

	//GETTER for specializedConcepts and generalizedConcepts
	public Set<Concept> getGeneralizedConcepts()
	{
		return generalizedConcepts;
	}

	public Set<Concept> getSpecializedConcepts()
	{
		return specializedConcepts;
	}

	/**
	 * Create easily readable output for the <code>Star</code> consisting of
	 * generalized and specialized <code>Concepts</code>
	 * 
	 * @return String which contains both generalized and specialized
	 *         <code>Concepts</code>
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("S:");
		for (Concept c : specializedConcepts)
			buffer.append("\t" + c + "\n");
		buffer.append("G:");
		for (Concept c : generalizedConcepts)
			buffer.append("\t" + c + "\n");
		return buffer.toString();
	}
}
