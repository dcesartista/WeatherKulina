package id.kulina.exercise.kulinaexecise;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ACER on 9/6/2016.
 */
public class App extends Application {
    public static final int MY_PERMISSION_ACCESS_COURSE_LOCATION = 0;
    public static final String APPID = "b7b035032f6b6442eb374d5735df644c";
    public static final int NUM_OF_DAYS_FETCHED = 1;
    public static final String MODE = "json";
    public static final String UNITS = "metric";

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                                              .setDefaultFontPath("fonts/OpenSans-Light.ttf")
                                              .setFontAttrId(R.attr.fontPath)
                                              .build()
        );
    }
}
