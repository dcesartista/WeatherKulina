package id.kulina.exercise.kulinaexecise;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ACER on 9/6/2016.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                                              .setDefaultFontPath("fonts/OpenSans-Regular.ttf")
                                              .setFontAttrId(R.attr.fontPath)
                                              .build()
        );
    }
}
