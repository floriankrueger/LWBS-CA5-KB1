package dhbw.LWBS.CA5_KB1.model;

public enum Degree
{
	NO_DEGREE(1),
	HAUPTSCHULE(2),
	REALSCHULE(3),
	GYMNASIUM(4),
	HOCHSCHULE(5),
	PROMOTION(6),
	NONE(0), // _
	ALL(100); // *

	private int id;

	Degree(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
