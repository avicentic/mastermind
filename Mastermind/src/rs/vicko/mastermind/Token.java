package rs.vicko.mastermind;

public enum Token
{

	DEFAULT(0), ORANGE(1), BLUE(2), GREEN(3);

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
