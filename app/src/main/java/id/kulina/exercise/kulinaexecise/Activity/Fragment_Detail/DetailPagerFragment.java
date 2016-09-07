package id.kulina.exercise.kulinaexecise.Activity.Fragment_Detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.kulina.exercise.kulinaexecise.Activity.Fragment_Main.MainActivityFragment;
import id.kulina.exercise.kulinaexecise.POJO.DailyForecast;
import id.kulina.exercise.kulinaexecise.POJO.Forecasts;
import id.kulina.exercise.kulinaexecise.POJO.Temperature;
import id.kulina.exercise.kulinaexecise.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailPagerFragment extends Fragment {
    private static final String TAG = DetailPagerFragment.class.getSimpleName();
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final int FIRST_PAGER = 1;
    private static final int SECOND_PAGER = 2;
    private static final int THIRD_PAGER = 3;

    View rootView;
    Forecasts forecasts;
    TextView tvTitle1,tvTitle2,tvTitle3,tvDesc1,tvDesc2,tvDesc3;
    int sectionNumber;

    public static DetailPagerFragment newInstance(int sectionNumber, Forecasts forecasts) {
        DetailPagerFragment fragment = new DetailPagerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putSerializable(MainActivityFragment.EXTRA_FORECASTS,forecasts);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        forecasts = (Forecasts) getArguments().getSerializable(MainActivityFragment.EXTRA_FORECASTS);
        rootView = inflater.inflate(R.layout.fragment_detail_pager, container, false);
        sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);

        initUIComponents();


        return rootView;
    }

    private void initUIComponents(){
        tvTitle1 = (TextView) rootView.findViewById(R.id.tv_title1);
        tvTitle2 = (TextView) rootView.findViewById(R.id.tv_title2);
        tvTitle3 = (TextView) rootView.findViewById(R.id.tv_title3);
        tvDesc1 = (TextView) rootView.findViewById(R.id.tv_desc1);
        tvDesc2 = (TextView) rootView.findViewById(R.id.tv_desc2);
        tvDesc3 = (TextView) rootView.findViewById(R.id.tv_desc3);

        DailyForecast dailyForecast = forecasts.getList().get(0);
        Temperature temperature = dailyForecast.getTemp();

        switch (sectionNumber){
            case FIRST_PAGER:
                tvTitle1.setText("morning");
                tvTitle2.setText("evening");
                tvTitle3.setText("night");
                tvDesc1.setText(temperature.getMorn()+getString(R.string.celcius));
                tvDesc2.setText(temperature.getEve()+getString(R.string.celcius));
                tvDesc3.setText(temperature.getNight()+getString(R.string.celcius));
                break;
            case SECOND_PAGER:
                tvTitle1.setText("pressure");
                tvTitle2.setText("wind speed");
                tvTitle3.setText("wind direction");
                tvDesc1.setText(dailyForecast.getPressure()+"hPa");
                tvDesc2.setText(dailyForecast.getSpeed() + "m/s");
                tvDesc3.setText(dailyForecast.getDeg() + "°");
                break;
            case THIRD_PAGER:
                tvTitle1.setText("humidity");
                tvTitle2.setText("cloudiness");
                tvTitle3.setText("rain");
                tvDesc1.setText(dailyForecast.getHumidity()+"%");
                tvDesc2.setText(dailyForecast.getClouds()+"%");
                tvDesc3.setText(dailyForecast.getRain()+"%");
                break;
        }

    }

}
