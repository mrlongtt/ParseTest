package squar.com.parseintegration;

import com.parse.Parse;

import android.app.Application;

/**
 * Created by silong on 2/9/15.
 */
public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Parse.initialize(this, "btLIXKQCer314UEkbQtKEbnDwdG6xEcr2AWruOgW",
        "BRv1emdouSSvj1vod1gry7pnnTUjJ5bnD97HSuuy");
  }
}
