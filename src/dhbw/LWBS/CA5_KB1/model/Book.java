package dhbw.LWBS.CA5_KB1.model;

public enum Book
{
	BOOK_A(1), BOOK_B(2), BOOK_C(3);

	// ENUM CODE
	private int id;

	Book(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}