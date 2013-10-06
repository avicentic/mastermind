package rs.vicko.mastermind;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity
{

	private ImageButton imageButton;
	private Integer imageDrawableId = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addListenerOnButton();

	}

	private void addListenerOnButton()
	{

		imageButton = (ImageButton) findViewById(R.id.imageButton0);
		imageButton.setImageDrawable(null);

		imageButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				if (imageDrawableId == null)
				{
					imageDrawableId = R.drawable.ic_pic0;
				}
				else if (imageDrawableId == R.drawable.ic_pic0)
				{
					imageDrawableId = R.drawable.ic_pic1;
				}
				else
				{
					imageDrawableId = R.drawable.ic_pic0;
				}
				;
				imageButton.setImageResource(imageDrawableId);

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

}
