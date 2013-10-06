package rs.vicko.mastermind;

import android.util.SparseArray;

public class Attempt
{
	private SparseArray<Token> tokens;

	public Attempt()
	{
		tokens = new SparseArray<Token>();
		for (int i = 1; i <= 4; i++)
		{
			tokens.put(i, Token.DEFAULT);
		}
	}

	public void setToken(Token token, int position)
	{
		tokens.put(position, token);
	}

	public Token getToken(int position)
	{
		return tokens.get(position);
	}

}
