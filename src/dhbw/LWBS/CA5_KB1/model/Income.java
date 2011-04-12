package dhbw.LWBS.CA5_KB1.model;

/**
 * Contains all types of <code>Income</code> that can occur in the file that is read in.
 * 
 *
 */
public enum Income
{
	B1000(1, "<1000"), 
	F1000T1999(2, "1000-1999"), 
	F2000T2999(3, "2000-2999"), 
	F3000T3999(4, "3000-3999"), 
	F4000T4999(5, "4000-4999"), 
	O5000(6, "5000 und mehr"), 
	NONE(0, ""), 
	ALL(100, "*");

	public static String NAME = "Income";
	private int id;
	private String token;

	/**
	 * Enum constructor
	 * @param id
	 * @param token
	 */
	Income(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}
	
	/**
	 * Returns the <code>Income</code> constant that matches with the given id.
	 * @param id that is searched for
	 * @return <code>Income</code> constant
	 */
	public static Income fromInteger(Integer id)
	{
		if (id != null)
		{
			for (Income a : Income.values())
			{
				if (id == a.id)
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Income Id: " + id);
		return null;
	}
	
	/**
	 * Returns the <code>Income</code> constant that matches with the given token.
	 * @param token that is searched for
	 * @return <code>Income</code> constant
	 */
	public static Income fromString(String token)
	{
		if (token != null)
		{
			for (Income a : Income.values())
			{
				if (token.equalsIgnoreCase(a.token))
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Income token: " + token);
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
