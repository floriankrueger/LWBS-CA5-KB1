package dhbw.LWBS.CA5_KB1.model;

public enum Gender
{
	MALE(1), FEMALE(2);

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
