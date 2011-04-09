package dhbw.LWBS.CA5_KB1.model;

public enum Income
{
	B1000(1), // <1000
	F1000T1999(2), // 1000-1999
	F2000T2999(3), // 2000-2999
	F3000T3999(4), // 3000-3999
	F4000T4999(5), // 4000-4999
	O5000(6); // >5000

	private int id;

	Income(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
