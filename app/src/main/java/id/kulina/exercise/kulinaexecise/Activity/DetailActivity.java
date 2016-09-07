package id.kulina.exercise.kulinaexecise.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import id.kulina.exercise.kulinaexecise.Activity.Fragment_Main.MainActivityFragment;
import id.kulina.exercise.kulinaexecise.BaseActivity;
import id.kulina.exercise.kulinaexecise.POJO.Forecasts;
import id.kulina.exercise.kulinaexecise.R;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Forecasts forecasts = (Forecasts) getIntent().getSerializableExtra(MainActivityFragment.EXTRA_FORECASTS);
        TextView title = (TextView) findViewById(R.id.tv_title_toolbar);
        title.setText(forecasts.getCity().getName());
    }

}
