package dhbw.LWBS.CA5_KB1.model;

public enum Gender
{
	MALE(1, "m"), 
	FEMALE(2, "w"),
	NONE(0, ""),
	ALL(100, "*");

	public static String NAME = "Gender";
	private int id;
	private String token;

	Gender(int id, String token)
	{
		this.id = id;
		this.token = token;
	}

	public int getId()
	{
		return id;
	}
	public static Gender fromInteger(Integer id)
	{
		if (id != null)
		{
			for (Gender a : Gender.values())
			{
				if (id == a.id)
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Gender Id: " + id);
		return null;
	}
	
	public static Gender fromString(String token)
	{
		if (token != null)
		{
			for (Gender a : Gender.values())
			{
				if (token.equalsIgnoreCase(a.token))
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Gender token: " + token);
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
