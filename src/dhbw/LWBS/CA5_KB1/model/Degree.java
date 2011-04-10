package dhbw.LWBS.CA5_KB1.model;

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

	public static String NAME = "Degree";
	private int id;
	private String token;

	Degree(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}
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

}
