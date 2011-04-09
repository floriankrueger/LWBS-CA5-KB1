package dhbw.LWBS.CA5_KB1.model;

public class Person
{

	private int number;
	private AgeClass ageClass;
	private Gender gender;
	private boolean married;
	private int children;
	private Degree degree;
	private Profession profession;
	private Income income;
	private Book book;

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
			boolean married, int children, Degree degree,
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
	}

	public Person(String[] data)
	{
		super();

		int number = 0;
		int children = 0;

		// parse number
		try
		{
			number = Integer.parseInt(data[0]);
			children = Integer.parseInt(data[4]);
		}
		catch (NumberFormatException nfe)
		{
			// TODO
		}

		// create the person
		this.number = number;
		this.ageClass = getAgeClassForString(data[1]);
		this.gender = getGenderForString(data[2]);
		this.married = getBoolForString(data[3]);
		this.children = children;
		this.degree = getDegreeForString(data[5]);
		this.profession = getProfessionForString(data[6]);
		this.income = getIncomeForString(data[7]);
		this.book = getBookForString(data[8]);
	}

	@Override
	public int hashCode()
	{
		int arbitraryPrimeNumber = 31337;
		return number * arbitraryPrimeNumber;
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

	public boolean isMarried()
	{
		return married;
	}

	public int getChildren()
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

	// BOOL UTILS
	private boolean getBoolForString(String s)
	{
		if (s.equals("ja"))
			return true;
		else
			return false;
	}

	// ENUM UTILS
	private AgeClass getAgeClassForString(String s)
	{
		return null;
	}

	private Gender getGenderForString(String s)
	{
		if (s.equalsIgnoreCase("m"))
			return Gender.MALE;
		else if (s.equalsIgnoreCase("w"))
			return Gender.FEMALE;
		else
			System.err.println("Unknown Gender " + s);
		return null;

	}

	private Degree getDegreeForString(String s)
	{
		return null;
	}

	private Profession getProfessionForString(String s)
	{
		if (s.equalsIgnoreCase("Angestellter"))
			return Profession.ANGESTELLTER;
		else if (s.equalsIgnoreCase("Arbeiter"))
			return Profession.ARBEITER;
		else if (s.equalsIgnoreCase("Arbeitslos"))
			return Profession.ARBEITSLOS;
		else if (s.equalsIgnoreCase("Fuehrungskraft"))
			return Profession.FUEHRUNGSKRAFT;
		else if (s.equalsIgnoreCase("Hausfrau"))
			return Profession.HAUSFRAU;
		else if (s.equalsIgnoreCase("Lehrer"))
			return Profession.LEHRER;
		else if (s.equalsIgnoreCase("Rentner"))
			return Profession.RENTNER;
		else if (s.equalsIgnoreCase("Selbstaendig"))
			return Profession.SELBSTSTAENDIG;
		else
			System.err.println("Unknown Profession " + s);
		return null;
	}

	private Income getIncomeForString(String s)
	{
		return null;
	}

	private Book getBookForString(String s)
	{
		return null;
	}
}
