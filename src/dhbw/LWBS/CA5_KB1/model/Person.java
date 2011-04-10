package dhbw.LWBS.CA5_KB1.model;

import java.util.HashMap;
import java.util.Map;

public class Person
{

	protected int number;
	protected AgeClass ageClass;
	protected Gender gender;
	protected Married married;
	protected Children children;
	protected Degree degree;
	protected Profession profession;
	protected Income income;
	protected Book book;
	
	@SuppressWarnings("rawtypes")
	protected Map<Class,Integer> attributes;

	/**
	 * @param number
	 * @param ageClass
	 * @param gender
	 * @param married
	 * @param children
	 * @param degree
	 * @param profession
	 * @param income
	 * @param book
	 */
	public Person(int number, AgeClass ageClass, Gender gender,
			Married married, Children children, Degree degree,
			Profession profession, Income income, Book book)
	{
		super();
		this.number = number;
		this.ageClass = ageClass;
		this.gender = gender;
		this.married = married;
		this.children = children;
		this.degree = degree;
		this.profession = profession;
		this.income = income;
		this.book = book;
		
		initHashMap();
	}

	@SuppressWarnings("rawtypes")
	private void initHashMap()
	{
		this.attributes = new HashMap<Class,Integer>();
		this.attributes.put(AgeClass.class, ageClass.getId());
		this.attributes.put(Gender.class, gender.getId());
		this.attributes.put(Married.class, married.getId());
		this.attributes.put(Children.class, children.getId());
		this.attributes.put(Degree.class, degree.getId());
		this.attributes.put(Profession.class, profession.getId());
		this.attributes.put(Income.class, income.getId());
	}

	public Person(String[] data)
	{
		super();

		int number = 0;

		// parse number
		try
		{
			number = Integer.parseInt(data[0]);
		}
		catch (NumberFormatException nfe)
		{
			System.err.println("Unknown number: " + data[0]);
		}

		// create the person
		this.number = number;
		this.ageClass = getAgeClassForString(data[1]);
		this.gender = getGenderForString(data[2]);
		this.married = getMarriedForString(data[3]);
		this.children = getChildrenForString(data[4]);
		this.degree = getDegreeForString(data[5]);
		this.profession = getProfessionForString(data[6]);
		this.income = getIncomeForString(data[7]);
		this.book = getBookForString(data[8]);
	}

	
	
	@Override
	public int hashCode()
	{
		final int prime = 31337;
		int result = 1;
		result = prime * result
				+ ((ageClass == null) ? 0 : ageClass.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((income == null) ? 0 : income.hashCode());
		result = prime * result + ((married == null) ? 0 : married.hashCode());
		result = prime * result + number;
		result = prime * result
				+ ((profession == null) ? 0 : profession.hashCode());
		return result;
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
		if (number != other.number)
			return false;
		if (ageClass != other.ageClass)
			return false;
		if (book != other.book)
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toConceptString()
	{
		return "(ageClass=" + ageClass + ", gender=" + gender
				+ ", married=" + married + ", children=" + children
				+ ", degree=" + degree + ", profession=" + profession
				+ ", income=" + income + ")";
	}

	// GETTER&SETTER
	public int getNumber()
	{
		return number;
	}

	public AgeClass getAgeClass()
	{
		return ageClass;
	}

	public Gender getGender()
	{
		return gender;
	}

	public Married getMarried()
	{
		return married;
	}

	public Children getChildren()
	{
		return children;
	}

	public Degree getDegree()
	{
		return degree;
	}

	public Profession getProfession()
	{
		return profession;
	}

	public Income getIncome()
	{
		return income;
	}

	public Book getBook()
	{
		return book;
	}

	/**
	 * @return the attributes
	 */
	@SuppressWarnings("rawtypes")
	public Map<Class, Integer> getAttributes()
	{
		return attributes;
	}
}
