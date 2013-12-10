package rs.vicko.mastermind;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class UserSettingsActivity extends PreferenceActivity
{
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.settings);

	}
}
