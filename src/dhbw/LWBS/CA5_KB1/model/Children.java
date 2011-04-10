package dhbw.LWBS.CA5_KB1.model;

public enum Children
{
	NONE(-1, ""),
	ALL(100, "*"),
	ZERO(0, "0"),
	ONE(1, "1"),
	TWO(2, "2"),
	THREE(3, "3"),
	FOUR(4, "4"),
	FIVE(5, "5"),
	SIX(6, "6"),
	SEVEN(7, "7"),
	EIGHT(8, "8"),
	NINE(9, "9"),
	TEN(10, "10"),
	ELEVEN(11, "11"),
	TWELVE(12, "12"),
	THIRTEEN(13, "13"),
	FOURTEEN(14, "14"),
	FIFTEEN(15, "15"),
	SIXTEEN(16, "16"),
	SEVENTEEN(17, "17"),
	EIGHTEEN(18, "18"),
	NINETEEN(19, "19"),
	TWENTY(20, "20");
	
	public static String NAME = "Children";
	private int id;
	private String token;
	
	Children(int id, String token)
	{
		this.id = id;
		this.token = token;
	}
	
	public int getId()
	{
		return id;
	}
	public static Children fromInteger(Integer id)
	{
		if (id != null)
		{
			for (Children a : Children.values())
			{
				if (id == a.id)
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Children Id: " + id);
		return null;
	}

	public static Children fromString(String token)
	{
		if (token != null)
		{
			for (Children a : Children.values())
			{
				if (token.equalsIgnoreCase(a.token))
				{
					return a;
				}
			}
		}
		System.err.println("Unknown Children token: " + token);
		return null;
	}
}
