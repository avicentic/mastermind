package rs.vicko.mastermind;

import android.util.SparseArray;

public class Attempt
{
	private SparseArray<Token> tokens;
	private int size;

	public Attempt(int size)
	{
		this.size = size;
		tokens = new SparseArray<Token>();
		for (int i = 1; i <= size; i++)
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

	public boolean isReadyForCheck()
	{
		for (int i = 1; i <= size; i++)
		{
			if (tokens.get(i) == Token.DEFAULT)
			{
				return false;
			}
		}
		return true;

	}

	@Override
	public String toString()
	{
		String ret = "";
		for (int i = 1; i <= size; i++)
		{
			ret = ret + (i > 1 ? ";" : "") + tokens.get(i);

		}
		return ret;
	}

}
