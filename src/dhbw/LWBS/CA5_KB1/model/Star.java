package dhbw.LWBS.CA5_KB1.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Star
{
	private Set<Concept> specializedConcepts;
	private Set<Concept> generalizedConcepts;

	public Star()
	{
		this(new ArrayList<Concept>(), new ArrayList<Concept>());
	}
	
	public Star(List<Concept> s, List<Concept> g)
	{
		super();
		this.specializedConcepts = new HashSet<Concept>(s);
		this.generalizedConcepts = new HashSet<Concept>(g);
	}
	
	public boolean addSpecializedConcept(Concept c)
	{
		return specializedConcepts.add(c);
	}
	
	public boolean addGeneralizedConcept(Concept c)
	{
		return generalizedConcepts.add(c);
	}
	
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
