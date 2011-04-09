package dhbw.LWBS.CA5_KB1.model;

public enum Degree
{
	NONE(1), HAUPTSCHULE(2), REALSCHULE(3), GYMNASIUM(4), HOCHSCHULE(5), PROMOTION(
			6);

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
