package rs.vicko.mastermind;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity
{

	private Attempt attempt = new Attempt();

	private ImageButton imageButton;

	private Mastermind mm = new MastermindImpl();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addListenerOnButton();

	}

	private void addListenerOnButton()
	{

		final MainActivity activity = this;

		
		
		imageButton = (ImageButton) findViewById(R.id.imageButton1);
		imageButton.setImageResource(R.drawable.pic_default);

		imageButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				mm.setNextToken(activity, 1);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public Attempt getAttempt()
	{
		return attempt;
	}

	public void setAttempt(Attempt attempt)
	{
		this.attempt = attempt;
	}

}
