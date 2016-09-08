package id.kulina.exercise.kulinaexecise.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;

import id.kulina.exercise.kulinaexecise.BaseActivity;
import id.kulina.exercise.kulinaexecise.R;

public class SplashScreenActivity extends BaseActivity {
    int splashInterval = 2000;
    View ivLogo, linLayTitle, root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivLogo = findViewById(R.id.iv_sun);
        linLayTitle = findViewById(R.id.lin_lay_title);
        root = findViewById(R.id.root);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this,
                                                                                 Pair.create(ivLogo, ivLogo.getTransitionName()),
                                                                                 Pair.create(linLayTitle, linLayTitle.getTransitionName())).toBundle();
                    startActivity(intent,bundle);
                } else{
                    startActivity(intent);
                }
            }
        }, splashInterval);
    }
}
