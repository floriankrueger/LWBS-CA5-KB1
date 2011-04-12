package dhbw.LWBS.CA5_KB1.model;

/**
 * Contains all types of <code>Books</code> that can occur in the file that is read in.
 */
public enum Book
{
	BOOK_A(1,"Buch_A"),
	BOOK_B(2,"Buch_B"),
	BOOK_C(3,"Buch_C"),
	NONE(0,""),
	ALL(100,"*");

	// ENUM CODE
	public static String NAME = "Book";
	private int id;
	private String token;

	/**
	 * Enum constructor
	 * @param id
	 * @param token
	 */
	Book(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}

	/**
	 * Returns the <code>Book</code> constant that matches with the given id.
	 * @param id that is searched for
	 * @return <code>Book</code> constant, <code>null</code> if id is not contained
	 */
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

	/**
	 * Returns the <code>Book</code> constant that matches with the given token.
	 * @param token that is searched for
	 * @return <code>Book</code> constant, <code>null</code> if token is not contained
	 */
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