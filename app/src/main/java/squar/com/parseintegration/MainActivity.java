package squar.com.parseintegration;

import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.SaveCallback;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by silong on 2/9/15.
 */
public class MainActivity extends Activity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private static final String CHANNEL = "channel_Test";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  public void unsubscribe(View view) {
    Log.e(TAG, "unsubscribing");
    ParsePush.unsubscribeInBackground(CHANNEL, new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.e(TAG, "unsubscribed to " + CHANNEL);
        } else {
          Log.e(TAG, String.format("Failed to unsubscribed to Parse %s, %d", e.getMessage(), e.getCode()));
        }
      }
    });
  }

  public void subscribe(View view) {
    Log.e(TAG, "subscribing");
    ParsePush.subscribeInBackground(CHANNEL, new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.e(TAG, "Subscribed to " + CHANNEL);
        } else {
          Log.e(TAG, String.format("Failed to subscribe to Parse %s, %d", e.getMessage(), e.getCode()));
        }
      }
    });
  }
}
