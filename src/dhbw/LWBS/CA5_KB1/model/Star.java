package dhbw.LWBS.CA5_KB1.model;

import java.util.HashSet;
import java.util.Set;

public class Star
{
	private Set<Concept> specializedConcepts;
	private Set<Concept> generalizedConcepts;

	Star()
	{
		this(new HashSet<Concept>(), new HashSet<Concept>());
	}
	
	Star(Set<Concept> s, Set<Concept> g)
	{
		super();
		this.specializedConcepts = s;
		this.generalizedConcepts = g;
	}
	
	public boolean addSpecializedConcept(Concept c)
	{
		return specializedConcepts.add(c);
	}
	
	public boolean addGeneralizedConcept(Concept c)
	{
		return generalizedConcepts.add(c);
	}
}
