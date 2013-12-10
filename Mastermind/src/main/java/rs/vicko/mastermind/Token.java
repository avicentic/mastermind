package rs.vicko.mastermind;

public enum Token
{

	DEFAULT(0), TOKEN_SPADE(1), TOKEN_DIAMOND(2), TOKEN_HEART(3), TOKEN_CLUB(4), TOKEN_STAR(5), TOKEN_ROYAL(6);

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
