package id.kulina.exercise.kulinaexecise.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import id.kulina.exercise.kulinaexecise.BaseActivity;
import id.kulina.exercise.kulinaexecise.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
