package rs.vicko.mastermind;

public enum Token
{

	DEFAULT(0), ORANGE(1), BLUE(2);

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

}
