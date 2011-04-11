package dhbw.LWBS.CA5_KB1.model;

public enum Book
{
	BOOK_A(1,"Buch_A"),
	BOOK_B(2,"Buch_B"),
	BOOK_C(3,"Buch_C"),
	NONE(0,""),
	ALL(100,"*");

	// ENUM CODE
	private static String NAME = "Book";
	private int id;
	private String token;

	Book(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}

	public static Book fromInteger(Integer id)
	{
		if (id != null)
		{
			for (Book a : Book.values())
			{
				if (id == a.id)
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Book Id: " + id);
		return null;
	}

	public static Book fromString(String token)
	{
		if (token != null)
		{
			for (Book a : Book.values())
			{
				if (token.equalsIgnoreCase(a.token))
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Book token: " + token);
		return null;
	}
	
	@Override
	public String toString() {
		if (id != 0)
			return token;
		else
			return "_";
	}
}