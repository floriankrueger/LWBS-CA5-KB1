package dhbw.LWBS.CA5_KB1.model;

/**
 * Contains all types of <code>Income</code> that can occur in the file that is read in.
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

	//ENUM CODE
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
	 * @return <code>Income</code> constant, <code>null</code> if id is not contained
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
	 * @return <code>Income</code> constant, <code>null</code> if token is not contained
	 */
	public static Income fromString(String token)
	{
		if (token != null)
		{
			try {
				int intValue = Integer.parseInt(token);
				
				token = getClassFromValue(intValue);
			}
			catch (NumberFormatException nfe) { /* do nothing, this will happen (in most cases) */ }
			
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
	
	/**
	 * Returns the correct <code>Income<code> token for a single given value (e.g. class 3000-3999 for the value 3412) 
	 * @param intValue an <code>int</code> that should be classified
	 * @return the token representing the correct <code>Income</code> for the given intValue
	 */
	private static String getClassFromValue(int intValue)
	{
		if (intValue <= 1000)
			return "<1000";
		
		if ( (intValue > 1000) && (intValue <= 1999) )
			return "1000-1999";
		
		if ( (intValue > 1999) && (intValue <= 2999) )
			return "2000-2999";
		
		if ( (intValue > 2999) && (intValue <= 3999) )
			return "3000-3999";
		
		if ( (intValue > 3999) && (intValue <= 4999) )
			return "4000-4999";
		
		if (intValue > 5000)
			return "5000 und mehr";
		
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
