package dhbw.LWBS.CA5_KB1.model;

import java.util.Map;

/**
 * This is a specification of the class <code>Person</code>. In contrast to a
 * <code>Person</code> a <code>Concept</code> doesn't contain a number or a
 * book. Besides a <code>Concept</code> can be either specialized or
 * generalized.
 */
public class Concept extends Person
{
	/**
	 * Class constructor
	 * 
	 * @param ageClass
	 * @param gender
	 * @param married
	 * @param children
	 * @param degree
	 * @param profession
	 * @param income
	 */
	public Concept(AgeClass ageClass,
			Gender gender,
			Married married,
			Children children,
			Degree degree,
			Profession profession,
			Income income)
	{
		super(0, ageClass, gender, married, children, degree, profession, income, Book.NONE);
	}

	/**
	 * Initializes a new <code>Concept</code> with underscores meaning no
	 * attribute of an example is wanted and returns it.
	 * 
	 * @return <code>Concept</code>
	 */
	public static Concept getMostSpecializedConcept()
	{
		return new Concept(AgeClass.NONE,
				Gender.NONE,
				Married.NONE,
				Children.NONE,
				Degree.NONE,
				Profession.NONE,
				Income.NONE);
	}

	/**
	 * Initializes a new <code>Concept</code> with stars meaning each attribute
	 * of an example is wanted and returns it.
	 * 
	 * @return <code>Concept</code>
	 */
	public static Concept getMostGeneralizedConcept()
	{
		return new Concept(AgeClass.ALL,
				Gender.ALL,
				Married.ALL,
				Children.ALL,
				Degree.ALL,
				Profession.ALL,
				Income.ALL);
	}

	/**
	 * Proofs if the <code>Concept</code> on which the method is called covers
	 * the <code>Person</code> that is given.
	 * 
	 * @param p
	 *            <code>Person</code> that should be covered
	 * @return false if <code>Person</code>'s and <code>Concept</code>'s
	 *         attribute are unequal and the <code>Concept</code>'s attribute is
	 *         not a star, true otherwise
	 */
	public boolean covers(Person p)
	{
		for (String attributeKey : attributes.keySet())
		{
			int this_Attribute = attributes.get(attributeKey);
			Map<String, Integer> att = p.getAttributes();
			int other_Attribute = att.get(attributeKey);

			if ((this_Attribute != other_Attribute) && (this_Attribute != 100))
				return false;
		}
		return true;
	}

	/**
	 * Makes a copy of a complete <code>Concept</code> and returns the copy
	 * 
	 * @return <code>Concept</code>
	 */
	public Concept copy()
	{
		Concept temp = new Concept(AgeClass.fromInteger(ageClass.getId()),
				Gender.fromInteger(gender.getId()),
				Married.fromInteger(married.getId()),
				Children.fromInteger(children.getId()),
				Degree.fromInteger(degree.getId()),
				Profession.fromInteger(profession.getId()),
				Income.fromInteger(income.getId()));

		return temp;
	}

	/**
	 * Matches the given name with the according class name and sets the enum
	 * constant according to the given attribute.
	 * 
	 * @param name
	 *            of the enum to be searched for
	 * @param attribute
	 *            number of a constant in the specified enum
	 */
	public void setAttribute(String name, Integer attribute)
	{
		if (name.equals(AgeClass.NAME))
			setAgeClass(AgeClass.fromInteger(attribute));
		else if (name.equals(Gender.NAME))
			setGender(Gender.fromInteger(attribute));
		else if (name.equals(Married.NAME))
			setMarried(Married.fromInteger(attribute));
		else if (name.equals(Children.NAME))
			setChildren(Children.fromInteger(attribute));
		else if (name.equals(Degree.NAME))
			setDegree(Degree.fromInteger(attribute));
		else if (name.equals(Profession.NAME))
			setProfession(Profession.fromInteger(attribute));
		else if (name.equals(Income.NAME))
			setIncome(Income.fromInteger(attribute));
		else
			System.err.println("setAttribute called with unknown attribute name: "
					+ name);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;

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

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return super.toConceptString();
	}

	/**
	 * @param ageClass
	 *            the ageClass to set
	 */
	public void setAgeClass(AgeClass ageClass)
	{
		this.ageClass = ageClass;
		this.attributes.put(AgeClass.NAME, this.ageClass.getId());
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender)
	{
		this.gender = gender;
		this.attributes.put(Gender.NAME, this.gender.getId());
	}

	/**
	 * @param married
	 *            the married to set
	 */
	public void setMarried(Married married)
	{
		this.married = married;
		this.attributes.put(Married.NAME, this.married.getId());
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(Children children)
	{
		this.children = children;
		this.attributes.put(Children.NAME, this.children.getId());
	}

	/**
	 * @param degree
	 *            the degree to set
	 */
	public void setDegree(Degree degree)
	{
		this.degree = degree;
		this.attributes.put(Degree.NAME, this.degree.getId());
	}

	/**
	 * @param profession
	 *            the profession to set
	 */
	public void setProfession(Profession profession)
	{
		this.profession = profession;
		this.attributes.put(Profession.NAME, this.profession.getId());
	}

	/**
	 * @param income
	 *            the income to set
	 */
	public void setIncome(Income income)
	{
		this.income = income;
		this.attributes.put(Income.NAME, this.income.getId());
	}
}
