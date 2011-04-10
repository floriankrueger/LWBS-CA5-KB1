package dhbw.LWBS.CA5_KB1.model;

public class Concept extends Person
{	
	Concept(AgeClass ageClass, Gender gender,
			Married married, Children children, Degree degree,
			Profession profession, Income income)
	{
		super(0, ageClass, gender, married, children, degree, profession ,income ,Book.NONE);
	}
	
	public static Concept getMostSpecializedConcept()
	{
		return new Concept(AgeClass.NONE, Gender.NONE, Married.NONE, Children.NONE, Degree.NONE, Profession.NONE, Income.NONE);
	}
	
	public static Concept getMostGeneralizedConcept()
	{
		return new Concept(AgeClass.ALL, Gender.ALL, Married.ALL, Children.ALL, Degree.ALL, Profession.ALL, Income.ALL);
	}
	
	/**
	 * @param ageClass the ageClass to set
	 */
	public void setAgeClass(AgeClass ageClass)
	{
		this.ageClass = ageClass;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	/**
	 * @param married the married to set
	 */
	public void setMarried(Married married)
	{
		this.married = married;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Children children)
	{
		this.children = children;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(Degree degree)
	{
		this.degree = degree;
	}

	/**
	 * @param profession the profession to set
	 */
	public void setProfession(Profession profession)
	{
		this.profession = profession;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(Income income)
	{
		this.income = income;
	}
}
