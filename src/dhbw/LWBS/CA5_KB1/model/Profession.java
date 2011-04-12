package dhbw.LWBS.CA5_KB1.model;

/**
 * TODO enum doc
 * 
 *
 */
public enum Profession
{
	ANGESTELLTER(1, "Angestellter"),
	ARBEITER(2, "Arbeiter"),
	ARBEITSLOS(3, "Arbeitslos"),
	FUEHRUNGSKRAFT(4, "Fuehrungskraft"),
	HAUSFRAU(5, "Hausfrau"),
	LEHRER(6, "Lehrer"),
	RENTNER(7, "Rentner"),
	SELBSTSTAENDIG(8, "Selbstaendig"),
	NONE(0, ""),
	ALL(100, "*");

	public static String NAME = "Profession";
	private int id;
	private String token;

	Profession(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}
	
	public static Profession fromInteger(Integer id)
	{
		if (id != null)
		{
			for (Profession a : Profession.values())
			{
				if (id == a.id)
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Profession Id: " + id);
		return null;
	}
	
	public static Profession fromString(String token)
	{
		if (token != null)
		{
			for (Profession a : Profession.values())
			{
				if (token.equalsIgnoreCase(a.token))
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Profession token: " + token);
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
