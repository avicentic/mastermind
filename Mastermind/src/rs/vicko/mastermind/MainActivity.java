package rs.vicko.mastermind;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;

public class MainActivity extends Activity
{

	private Attempt attempt = new Attempt(4);
	private int attemptNo = 0;

	private Mastermind mm = new MastermindImpl();
	private Activity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addListenerOnButton1();
		addListenerOnButton2();
		addListenerOnButton3();
		addListenerOnButton4();

		addListenerOnCheckButton();

	}

	private void addListenerOnCheckButton()
	{
		Button button = (Button) findViewById(R.id.btnCheck);
		button.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				attemptNo++;

				int tableRowId = getResources().getIdentifier("tableRowAtempt" + attemptNo, "id",
						activity.getPackageName());

				TableRow tableRow = (TableRow) findViewById(tableRowId);

				// TODO Auto-generated method stub
				for (int i = 1; i <= 4; i++)
				{
					ImageView image = new ImageView(getApplicationContext());
					int imageId = getResources().getIdentifier("pic0" + attempt.getToken(i).getId(), "drawable",
							activity.getPackageName());
					Log.d("OnCheck", String.format("Found image id = %s", imageId));
					image.setImageResource(imageId);
					tableRow.addView(image);
				}

				Log.d("OnCheck", attempt.toString());

				//clear attempt
				attempt = new Attempt(4);
				for (int i = 1; i <= 4; i++)
				{
					int resourceId = getResources().getIdentifier("imageButton" + i, "id", activity.getPackageName());
					ImageButton imageButton = (ImageButton) findViewById(resourceId);
					imageButton.setImageResource(R.drawable.pic_default);
				}
			}
		});

	}

	private void addListenerOnButton1()
	{
		final MainActivity activity = this;
		ImageButton imageButton;
		imageButton = (ImageButton) findViewById(R.id.imageButton1);

		imageButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				mm.setNextToken(activity, 1);
			}
		});
	}

	private void addListenerOnButton2()
	{
		final MainActivity activity = this;
		ImageButton imageButton;
		imageButton = (ImageButton) findViewById(R.id.imageButton2);

		imageButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				mm.setNextToken(activity, 2);
			}
		});
	}

	private void addListenerOnButton3()
	{
		final MainActivity activity = this;
		ImageButton imageButton;
		imageButton = (ImageButton) findViewById(R.id.imageButton3);

		imageButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				mm.setNextToken(activity, 3);
			}
		});
	}

	private void addListenerOnButton4()
	{
		final MainActivity activity = this;
		ImageButton imageButton;
		imageButton = (ImageButton) findViewById(R.id.imageButton4);

		imageButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				mm.setNextToken(activity, 4);
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
