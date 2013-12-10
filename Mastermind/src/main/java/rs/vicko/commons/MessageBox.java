package rs.vicko.commons;

import android.app.Activity;
import android.app.AlertDialog;

public class MessageBox
{
	public static void showMessage(Activity activity, String title, String message)
	{

		AlertDialog alertDialog;
		alertDialog = new AlertDialog.Builder(activity).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.show();
	}
}
