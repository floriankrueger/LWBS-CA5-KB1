package dhbw.LWBS.CA5_KB1.model;

public class Concept extends Person
{
	Concept(AgeClass ageClass, Gender gender, Married married,
			Children children, Degree degree, Profession profession,
			Income income)
	{
		super(0, ageClass, gender, married, children, degree, profession,
				income, Book.NONE);
	}

	public static Concept getMostSpecializedConcept()
	{
		return new Concept(AgeClass.NONE, Gender.NONE, Married.NONE,
				Children.NONE, Degree.NONE, Profession.NONE, Income.NONE);
	}

	public static Concept getMostGeneralizedConcept()
	{
		return new Concept(AgeClass.ALL, Gender.ALL, Married.ALL, Children.ALL,
				Degree.ALL, Profession.ALL, Income.ALL);
	}

	public boolean covers(Person p)
	{
		// TODO implement "covers"
		return true;
	}
	
	public boolean equals(Person other)
	{
		if (ageClass != other.ageClass)
			return false;
		if (children != other.children)
			return false;
		if (degree != other.degree)
			return false;
		if (gender != other.gender)
			return false;
		if (income != other.income)
			return false;
		if (married != other.married)
			return false;
		if (profession != other.profession)
			return false;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return super.toConceptString();
	}

	/*
	 * TODO : irgendwann loeschen public void generalizeAgeClass(AgeClass a) {
	 * if (ageClass == a) ageClass = a; else if (ageClass != a) ageClass =
	 * AgeClass.ALL;
	 * 
	 * 
	 * if (c.getAgeClass() == AgeClass.NONE) { c.setAgeClass(p.getAgeClass()); }
	 * else if (p.getAgeClass() == AgeClass.NONE) { // no action required } else
	 * if (p.getAgeClass() == c.getAgeClass()) { // no action required either }
	 * else if (p.getAgeClass() != c.getAgeClass()) {
	 * c.setAgeClass(AgeClass.ALL); } }
	 */

	/**
	 * @param ageClass
	 *            the ageClass to set
	 */
	public void setAgeClass(AgeClass ageClass)
	{
		this.ageClass = ageClass;
		this.attributes.put(AgeClass.class, this.ageClass.getId());
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender)
	{
		this.gender = gender;
		this.attributes.put(Gender.class, this.gender.getId());
	}

	/**
	 * @param married
	 *            the married to set
	 */
	public void setMarried(Married married)
	{
		this.married = married;
		this.attributes.put(Married.class, this.married.getId());
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(Children children)
	{
		this.children = children;
		this.attributes.put(Children.class, this.children.getId());
	}

	/**
	 * @param degree
	 *            the degree to set
	 */
	public void setDegree(Degree degree)
	{
		this.degree = degree;
		this.attributes.put(Degree.class, this.degree.getId());
	}

	/**
	 * @param profession
	 *            the profession to set
	 */
	public void setProfession(Profession profession)
	{
		this.profession = profession;
		this.attributes.put(Profession.class, this.profession.getId());
	}

	/**
	 * @param income
	 *            the income to set
	 */
	public void setIncome(Income income)
	{
		this.income = income;
		this.attributes.put(Income.class, this.income.getId());
	}
}
