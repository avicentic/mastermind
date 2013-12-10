package rs.vicko.mastermind;

public class Hit
{
	private int hitPosition;
	private int hitColor;

	public Hit()
	{
		super();
	}

	public Hit(int hitPosition, int hitColor)
	{
		super();
		this.hitPosition = hitPosition;
		this.hitColor = hitColor;
	}

	public int getHitPosition()
	{
		return hitPosition;
	}

	public void setHitPosition(int hitPosition)
	{
		this.hitPosition = hitPosition;
	}

	public int getHitColor()
	{
		return hitColor;
	}

	public void setHitColor(int hitColor)
	{
		this.hitColor = hitColor;
	}

}
