package dhbw.LWBS.CA5_KB1.model;

/**
 * Contains all types of <code>Married</code> that can occur in the file that is read in.
 *
 */
public enum Married
{
	YES(1,"ja"),
	NO(2,"nein"),
	NONE(0,""),
	ALL(100,"*");

	public static String NAME = "Married";
	private int id;
	private String token;

	/**
	 * Enum constructor
	 * @param id
	 * @param token
	 */
	Married(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}
	
	/**
	 * Returns the <code>Married</code> constant that matches with the given id.
	 * @param id that is searched for
	 * @return <code>Married</code> constant
	 */
	public static Married fromInteger(Integer id)
	{
		if (id != null)
		{
			for (Married a : Married.values())
			{
				if (id == a.id)
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Married Id: " + id);
		return null;
	}
	
	/**
	 * Returns the <code>Married</code> constant that matches with the given token.
	 * @param token that is searched for
	 * @return <code>Married</code> constant
	 */
	public static Married fromString(String token)
	{
		if (token != null)
		{
			for (Married a : Married.values())
			{
				if (token.equalsIgnoreCase(a.token))
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Married token: " + token);
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
