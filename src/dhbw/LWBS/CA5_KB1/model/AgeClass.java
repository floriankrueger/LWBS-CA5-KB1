package dhbw.LWBS.CA5_KB1.model;

/**
 * Contains all types of <code>AgeClasses</code> that can occur in the file that is read in.
 */
public enum AgeClass
{
	B18(1, "<18"),
	F19T24(2, "19-24"),
	F25T35(3, "25-35"),
	F36T49(4, "36-49"),
	F50T65(5, "50-65"),
	O65(6, ">65"),
	NONE(0, ""),
	ALL(100, "*");

	//ENUM CODE
	public static String NAME = "AgeClass";
	private int id;
	private String token;

	/**
	 * Enum constructor
	 * @param id
	 * @param token
	 */
	AgeClass(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}

	/**
	 * Returns the <code>AgeClass</code> constant that matches with the given id.
	 * @param id that is searched for
	 * @return <code>AgeClass</code> constant, <code>null</code> if id is not contained
	 */
	public static AgeClass fromInteger(Integer id)
	{
		if (id != null)
		{
			for (AgeClass a : AgeClass.values())
			{
				if (id == a.id)
				{
					return a;
				}
			}
		}
		System.err.println("Unknown AgeClass Id: " + id);
		return null;
	}
	
	/**
	 * Returns the <code>AgeClass</code> constant that matches with the given token.
	 * @param token that is searched for
	 * @return <code>AgeClass</code> constant, <code>null</code> if token is not contained
	 */
	public static AgeClass fromString(String token)
	{
		if (token != null)
		{
			for (AgeClass a : AgeClass.values())
			{
				if (token.equalsIgnoreCase(a.token))
				{
					return a;
				}
			}
		}
		System.err.println("Unknown AgeClass token: " + token);
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
