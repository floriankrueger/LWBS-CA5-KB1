package dhbw.LWBS.CA5_KB1.model;

public enum Gender
{
	MALE(1), 
	FEMALE(2),
	NONE(0), // _
	ALL(100); // *

	private int id;

	Gender(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
