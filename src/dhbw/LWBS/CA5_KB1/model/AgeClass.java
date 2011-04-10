package dhbw.LWBS.CA5_KB1.model;

public enum AgeClass
{
	B18(1, "<18"),
	F19T24(2, "19-24"),
	F25T35(3, "25-35"),
	F36T49(4, "36-49"),
	F50T65(5, "50-65"),
	O65(6, ">65"),
	NONE(0, "_"),
	ALL(100, "*");

	public static String name = "AgeClass";
	private int id;
	private String token;

	AgeClass(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}

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
}
