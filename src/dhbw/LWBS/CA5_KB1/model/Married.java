package dhbw.LWBS.CA5_KB1.model;

/**
 * TODO enum doc
 * 
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

	private Married(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}
	
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
