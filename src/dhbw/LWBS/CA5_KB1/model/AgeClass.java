package dhbw.LWBS.CA5_KB1.model;

public enum AgeClass
{
	B18(1), // <18
	F19T24(2), // 19-24
	F25T35(3), // 25-35
	F36T49(4), // 36-49
	F50T65(5), // 50-65
	O65(6); // >65

	private int id;

	AgeClass(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
