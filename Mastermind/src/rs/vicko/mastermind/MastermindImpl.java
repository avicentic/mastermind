package rs.vicko.mastermind;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

public class MastermindImpl implements Mastermind
{

	@Override
	public void setNextToken(MainActivity activity, int tokenPos)
	{

		Attempt attempt = activity.getAttempt();

		int resourceId = activity.getResources().getIdentifier("imageButton" + tokenPos, "id",
				activity.getPackageName());

		Log.d("Mastermind", "resourceid=" + resourceId);
		ImageButton imageButton = (ImageButton) activity.findViewById(resourceId);

		int tokenId = attempt.getToken(tokenPos).getId();

		tokenId = tokenId + 1 > Token.getMaxId() ? 1 : tokenId + 1;

		int drawableId = activity.getResources().getIdentifier("pic0" + tokenId, "drawable", activity.getPackageName());

		Log.d("setNextToken", String.format("On position %s set token %s", tokenPos, Token.byId(tokenId)));

		imageButton.setImageResource(drawableId);
		attempt.setToken(Token.byId(tokenId), tokenPos);

		Button btnCheck = (Button) activity.findViewById(R.id.btnCheck);

		btnCheck.setClickable(attempt.isReadyForCheck());

	}

}
