package rs.vicko.mastermind;

import rs.vicko.commons.MessageBox;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity
{

	private Attempt target;
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

		setTarget();

	}

	private void setTarget()
	{
		target = new Attempt(4);
		for (int i = 1; i <= 4; i++)
		{

			int tokenId = 1 + (int) (6 * Math.random());

			Token token = Token.byId(tokenId);
			target.setToken(token, i);
		}
		Log.d("setTarget", target.toString());

	}

	private void addListenerOnCheckButton()
	{
		final Button button = (Button) findViewById(R.id.btnCheck);
		button.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				attemptNo++;

				TableLayout tableLayout = (TableLayout) findViewById(R.id.tablelayout);
				//TableLayout tableLayout = (TableLayout) getLayoutInflater().inflate(R.layout.activity_main, null);

				TableRow tableRow = new TableRow(activity);
				tableRow.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
						TableRow.LayoutParams.WRAP_CONTENT));
				//tableRow.setLayoutParams(new TableRow.LayoutParams(50, 50));
				//TableRow tableRow = (TableRow) findViewById(tableRowId);

				for (int i = 1; i <= 4; i++)
				{
					ImageView image = new ImageView(getApplicationContext());
					int imageId = getResources().getIdentifier("pic0" + attempt.getToken(i).getId(), "drawable",
							activity.getPackageName());
					Log.d("OnCheck", String.format("Found image id = %s", imageId));
					image.setImageResource(imageId);
					tableRow.addView(image);
				}

				//TextView text = new TextView(getApplicationContext());
				//tableRow.addView(text);

				Log.d("OnCheck", "attempt: " + attempt.toString());
				Log.d("OnCheck", "target: " + target.toString());

				Hit hit = checkAttempt();

				//				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				//						LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				//				params.gravity = Gravity.CENTER_VERTICAL;

				for (int i = 1; i <= hit.getHitPosition(); i++)
				{
					ImageView image = new ImageView(getApplicationContext());
					image.setImageResource(R.drawable.pic_position_ok);
					//image.setLayoutParams(params);
					tableRow.addView(image);
				}
				for (int i = 1; i <= hit.getHitColor(); i++)
				{
					ImageView image = new ImageView(getApplicationContext());
					image.setImageResource(R.drawable.pic_color_ok);
					//image.setLayoutParams(params);
					tableRow.addView(image);
				}
				for (int i = 1; i <= 4 - hit.getHitPosition() - hit.getHitColor(); i++)
				{
					ImageView image = new ImageView(getApplicationContext());
					image.setImageResource(R.drawable.pic_missed);
					//image.setLayoutParams(params);
					tableRow.addView(image);
				}
				tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
						TableLayout.LayoutParams.WRAP_CONTENT));

				if (hit.getHitPosition() == 4)
				{
					MessageBox.showMessage(activity, "Bravo", "You finished game!!!");
				}
				else if (attemptNo == 8)
				{
					MessageBox.showMessage(activity, ":-(", "You are looser, game is over");
				}

				//clear attempt
				attempt = new Attempt(4);
				for (int i = 1; i <= 4; i++)
				{
					int resourceId = getResources().getIdentifier("imageButton" + i, "id", activity.getPackageName());
					ImageButton imageButton = (ImageButton) findViewById(resourceId);
					imageButton.setImageResource(R.drawable.pic_default);
				}
				button.setClickable(false);
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Log.d("onOptionsItemSelected", (String) item.getTitle());
		switch (item.getItemId())
		{
		case R.id.action_settings:
			startActivity(new Intent(MainActivity.this, SettingsActivity.class));
			return true;
		default:
			return true;
		}

	}

	public Attempt getAttempt()
	{
		return attempt;
	}

	public void setAttempt(Attempt attempt)
	{
		this.attempt = attempt;
	}

	private Hit checkAttempt()
	{
		int hitColor = 0;
		int hitPosition = 0;

		Attempt a = attempt.clone();
		Attempt t = target.clone();
		for (int i = 1; i <= 4; i++)
		{
			if (a.getToken(i).getId() == t.getToken(i).getId())
			{
				a.setToken(Token.DEFAULT, i);
				t.setToken(Token.DEFAULT, i);
				hitPosition++;
			}
		}
		for (int i = 1; i <= 4; i++)
		{
			for (int j = 1; j <= 4; j++)
			{
				if (a.getToken(i) != Token.DEFAULT && t.getToken(j) != Token.DEFAULT
						&& a.getToken(i).getId() == t.getToken(j).getId())
				{
					a.setToken(Token.DEFAULT, i);
					t.setToken(Token.DEFAULT, j);
					hitColor++;
				}
			}
		}

		return new Hit(hitPosition, hitColor);

	}

}
