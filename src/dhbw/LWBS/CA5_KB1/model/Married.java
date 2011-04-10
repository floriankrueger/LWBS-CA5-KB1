package dhbw.LWBS.CA5_KB1.model;

public enum Married
{
	YES(1),
	NO(2),
	NONE(0),
	ALL(100);

	private int id;

	private Married(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

}
