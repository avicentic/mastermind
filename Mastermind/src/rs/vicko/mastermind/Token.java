package rs.vicko.mastermind;

public enum Token
{

	DEFAULT(0), TOKEN01(1), TOKEN02(2), TOKEN03(3), TOKEN04(4), TOKEN05(5), TOKEN06(6);

	private int id;

	Token(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public static Token byId(int id)
	{
		for (Token token : Token.values())
		{
			if (token.getId() == id)
			{
				return token;
			}
		}
		return null;
	}

	public static int getMaxId()
	{
		int maxId = 0;
		for (Token token : Token.values())
		{
			maxId = token.getId() > maxId ? token.getId() : maxId;
		}
		return maxId;
	}
}
