package dhbw.LWBS.CA5_KB1.model;

public enum Profession
{
	ANGESTELLTER(1), ARBEITER(2), ARBEITSLOS(3), FUEHRUNGSKRAFT(4), HAUSFRAU(5), LEHRER(
			6), RENTNER(7), SELBSTSTAENDIG(8);

	private int id;

	Profession(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
