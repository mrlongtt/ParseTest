package squar.com.parseintegration;

import com.parse.ParseAnalytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ParsePushBroadcastReceiver extends com.parse.ParsePushBroadcastReceiver {

  @Override
  protected void onPushReceive(Context context, Intent intent) {
    super.onPushReceive(context, intent);
    String channel = intent.getStringExtra("com.parse.Channel");
    String data = intent.getStringExtra("com.parse.Data");
    Log.e("ParsePushBroadcastReceiver", "CHANNEL:" + channel);
    Log.e("ParsePushBroadcastReceiver", "data:" + data);
  }

  @Override
  protected Class<? extends Activity> getActivity(Context context, Intent intent) {
    return MainActivity.class;
  }

  @Override
  protected void onPushOpen(Context context, Intent intent) {
    ParseAnalytics.trackAppOpenedInBackground(intent);
    Log.e("ParsePushBroadcastReceiver", "onPushOpen");
  }
}
