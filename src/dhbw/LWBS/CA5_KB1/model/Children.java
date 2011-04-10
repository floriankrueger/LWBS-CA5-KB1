package dhbw.LWBS.CA5_KB1.model;

public enum Children
{
	NONE(-1),	// _
	ALL(100),	// *
	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	ELEVEN(11),
	TWELVE(12),
	THIRTEEN(13),
	FOURTEEN(14),
	FIFTEEN(15),
	SIXTEEN(16),
	SEVENTEEN(17),
	EIGHTEEN(18),
	NINETEEN(19),
	TWENTY(20);
	
	private int id;
	
	Children(int id)
	{
		this.id = id;	
	}
}
