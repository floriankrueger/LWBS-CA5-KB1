package dhbw.LWBS.CA5_KB1.model;

/**
 * Contains all types of <code>Degree</code> that can occur in the file that is read in.
 */
public enum Degree
{
	NO_DEGREE(1, "keiner"),
	HAUPTSCHULE(2, "Hauptschule"),
	REALSCHULE(3, "Realschule"),
	GYMNASIUM(4, "Gymnasium"),
	HOCHSCHULE(5, "Hochschule"),
	PROMOTION(6, "Promotion"),
	NONE(0, ""),
	ALL(100, "*");

	//ENUM CODE
	public static String NAME = "Degree";
	private int id;
	private String token;

	/**
	 * Enum constructor
	 * @param id
	 * @param token
	 */
	Degree(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}
	
	/**
	 * Returns the <code>Degree</code> constant that matches with the given id.
	 * @param id that is searched for
	 * @return <code>Degree</code> constant, <code>null</code> if id is not contained
	 */
	public static Degree fromInteger(Integer id)
	{
		if (id != null)
		{
			for (Degree a : Degree.values())
			{
				if (id == a.id)
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Degree Id: " + id);
		return null;
	}

	/**
	 * Returns the <code>Degree</code> constant that matches with the given token.
	 * @param token that is searched for
	 * @return <code>Degree</code> constant, <code>null</code> if token is not contained
	 */
	public static Degree fromString(String token)
	{
		if (token != null)
		{
			for (Degree a : Degree.values())
			{
				if (token.equalsIgnoreCase(a.token))
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Degree token: " + token);
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
