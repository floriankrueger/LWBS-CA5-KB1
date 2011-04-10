package dhbw.LWBS.CA5_KB1.model;

public class Person
{

	private int number;
	private AgeClass ageClass;
	private Gender gender;
	private Married married;
	private Children children;
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

	public Married isMarried()
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

	// ENUM UTILS
	private AgeClass getAgeClassForString(String s)
	{
		if (s.equalsIgnoreCase("<18"))
			return AgeClass.B18;
		else if (s.equalsIgnoreCase("19-24"))
			return AgeClass.F19T24;
		else if (s.equalsIgnoreCase("25-35"))
			return AgeClass.F25T35;
		else if (s.equalsIgnoreCase("36-49"))
			return AgeClass.F36T49;
		else if (s.equalsIgnoreCase("50-65"))
			return AgeClass.F50T65;
		else if (s.equalsIgnoreCase(">65"))
			return AgeClass.O65;
		else if (s.equalsIgnoreCase(""))
			return AgeClass.NONE;
		else
			System.err.println("Unknown AgeClass: " + s);
		return null;
	}

	private Gender getGenderForString(String s)
	{
		if (s.equalsIgnoreCase("m"))
			return Gender.MALE;
		else if (s.equalsIgnoreCase("w"))
			return Gender.FEMALE;
		else if (s.equalsIgnoreCase(""))
			return Gender.NONE;
		else
			System.err.println("Unknown Gender " + s);
		return null;

	}

	private Degree getDegreeForString(String s)
	{
		if (s.equalsIgnoreCase("keiner"))
			return Degree.NO_DEGREE;
		else if (s.equalsIgnoreCase("Hauptschule"))
			return Degree.HAUPTSCHULE;
		else if (s.equalsIgnoreCase("Realschule"))
			return Degree.REALSCHULE;
		else if (s.equalsIgnoreCase("Gymnasium"))
			return Degree.GYMNASIUM;
		else if (s.equalsIgnoreCase("Hochschule"))
			return Degree.HOCHSCHULE;
		else if (s.equalsIgnoreCase("Promotion"))
			return Degree.PROMOTION;
		else if (s.equalsIgnoreCase(""))
			return Degree.NONE;
		else
			System.err.println("Unknown Degree: " + s);
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
		else if (s.equalsIgnoreCase(""))
			return Profession.NONE;
		else
			System.err.println("Unknown Profession " + s);
		return null;
	}

	private Income getIncomeForString(String s)
	{
		if (s.equalsIgnoreCase("<1000"))
			return Income.B1000;
		else if (s.equalsIgnoreCase("1000-1999"))
			return Income.F1000T1999;
		else if (s.equalsIgnoreCase("2000-2999"))
			return Income.F2000T2999;
		else if (s.equalsIgnoreCase("3000-3999"))
			return Income.F3000T3999;
		else if (s.equalsIgnoreCase("4000-4999"))
			return Income.F4000T4999;
		else if (s.equalsIgnoreCase("5000 und mehr"))
			return Income.O5000;
		else if (s.equalsIgnoreCase(""))
			return Income.NONE;
		else
			System.err.println("Unknown Income: " + s);
		return null;
	}
	
	private Married getMarriedForString(String s)
	{
		if (s.equalsIgnoreCase("ja"))
			return Married.YES;
		else if (s.equalsIgnoreCase("nein"))
			return Married.NO;
		else if (s.equalsIgnoreCase(""))
			return Married.NONE;
		else
			System.err.println("Unknown Married: " + s);
		return null;
	}

	private Book getBookForString(String s)
	{
		if (s.equalsIgnoreCase("Buch_A"))
			return Book.BOOK_A;
		else if (s.equalsIgnoreCase("Buch_B"))
			return Book.BOOK_B;
		else if (s.equalsIgnoreCase("Buch_C"))
			return Book.BOOK_C;
		else if (s.equalsIgnoreCase(""))
			return Book.NONE;
		else
			System.err.println("Unknown Book: " + s);
		return null;
	}
	
	private Children getChildrenForString(String s)
	{
		if (s.equalsIgnoreCase("0"))
			return Children.ZERO;
		else if (s.equalsIgnoreCase("1"))
			return Children.ONE;
		else if (s.equalsIgnoreCase("2"))
			return Children.TWO;
		else if (s.equalsIgnoreCase("3"))
			return Children.THREE;
		else if (s.equalsIgnoreCase("4"))
			return Children.FOUR;
		else if (s.equalsIgnoreCase("5"))
			return Children.FIVE;
		else if (s.equalsIgnoreCase("6"))
			return Children.SIX;
		else if (s.equalsIgnoreCase("7"))
			return Children.SEVEN;
		else if (s.equalsIgnoreCase("8"))
			return Children.EIGHT;
		else if (s.equalsIgnoreCase("9"))
			return Children.NINE;
		else if (s.equalsIgnoreCase("10"))
			return Children.TEN;
		else if (s.equalsIgnoreCase("11"))
			return Children.ELEVEN;
		else if (s.equalsIgnoreCase("12"))
			return Children.TWELVE;
		else if (s.equalsIgnoreCase("13"))
			return Children.THIRTEEN;
		else if (s.equalsIgnoreCase("14"))
			return Children.FOURTEEN;
		else if (s.equalsIgnoreCase("15"))
			return Children.FIFTEEN;
		else if (s.equalsIgnoreCase("16"))
			return Children.SIXTEEN;
		else if (s.equalsIgnoreCase("17"))
			return Children.SEVENTEEN;
		else if (s.equalsIgnoreCase("18"))
			return Children.EIGHTEEN;
		else if (s.equalsIgnoreCase("19"))
			return Children.NINETEEN;
		else if (s.equalsIgnoreCase("20"))
			return Children.TWENTY;
		else
			System.err.println("Unknown number of children: " + s);
		return null;
	}
}
