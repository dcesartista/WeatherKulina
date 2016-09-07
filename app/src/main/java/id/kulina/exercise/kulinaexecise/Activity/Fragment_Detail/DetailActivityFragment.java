package id.kulina.exercise.kulinaexecise.Activity.Fragment_Detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import id.kulina.exercise.kulinaexecise.Activity.Fragment_Main.MainActivityFragment;
import id.kulina.exercise.kulinaexecise.POJO.DailyForecast;
import id.kulina.exercise.kulinaexecise.POJO.Forecasts;
import id.kulina.exercise.kulinaexecise.POJO.Temperature;
import id.kulina.exercise.kulinaexecise.POJO.Weather;
import id.kulina.exercise.kulinaexecise.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private static final String TAG = DetailActivityFragment.class.getSimpleName();

    long time = 1473220800;
    View rootView, indicator1, indicator2, indicator3;
    ViewPager viewPager;
    DetailsPagerAdapter pagerAdapter;
    Forecasts forecasts;
    TextView tvTemp, tvTempMax, tvTempMin, tvDay, tvDate, tvWeatherMain, tvWeatherDesc;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        forecasts = (Forecasts) getActivity().getIntent().getSerializableExtra(MainActivityFragment.EXTRA_FORECASTS);
        Log.v(TAG,forecasts.toString());
        initUIComponent();

        return rootView;
    }

    private void initUIComponent(){
        indicator1 = rootView.findViewById(R.id.indicator1);
        indicator2 = rootView.findViewById(R.id.indicator2);
        indicator3 = rootView.findViewById(R.id.indicator3);

        viewPager = (ViewPager)rootView.findViewById(R.id.detailPager);
        pagerAdapter = new DetailsPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);

        DailyForecast dailyForecast = forecasts.getList().get(0);
        Temperature temperature = dailyForecast.getTemp();
        Weather weather = dailyForecast.getWeather().get(0);
        Date date = new Date(dailyForecast.getDt()*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = simpleDateFormat.format(date);

        tvTemp = (TextView) rootView.findViewById(R.id.tv_temp);
        tvTemp.setText(String.valueOf(temperature.getDay()));
        tvTempMax = (TextView) rootView.findViewById(R.id.tv_max_temp);
        tvTempMax.setText(String.valueOf(temperature.getMax()) + getString(R.string.celcius));
        tvTempMin = (TextView) rootView.findViewById(R.id.tv_min_temp);
        tvTempMin.setText(String.valueOf(temperature.getMin()) + getString(R.string.celcius));
        tvWeatherMain = (TextView) rootView.findViewById(R.id.tv_weather_main);
        tvWeatherMain.setText(weather.getMain());
        tvWeatherDesc = (TextView) rootView.findViewById(R.id.tv_weather_desc);
        tvWeatherDesc.setText(weather.getDescription());
        tvDay = (TextView) rootView.findViewById(R.id.tv_day);
        tvDay.setText(getDay(date));
        tvDate = (TextView) rootView.findViewById(R.id.tv_date);
        tvDate.setText(formattedDate);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                indicator1.setBackgroundResource(R.drawable.pager_indicator_selected);
                indicator2.setBackgroundResource(R.drawable.pager_indicator);
                indicator3.setBackgroundResource(R.drawable.pager_indicator);
                break;

            case 1:
                indicator1.setBackgroundResource(R.drawable.pager_indicator);
                indicator2.setBackgroundResource(R.drawable.pager_indicator_selected);
                indicator3.setBackgroundResource(R.drawable.pager_indicator);
                break;

            case 2:
                indicator1.setBackgroundResource(R.drawable.pager_indicator);
                indicator2.setBackgroundResource(R.drawable.pager_indicator);
                indicator3.setBackgroundResource(R.drawable.pager_indicator_selected);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public class DetailsPagerAdapter extends FragmentPagerAdapter {

        public DetailsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return DetailPagerFragment.newInstance(position+1,forecasts);
                case 1:
                    return DetailPagerFragment.newInstance(position+1,forecasts);
                case 2:
                    return  DetailPagerFragment.newInstance(position+1,forecasts);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    private String getDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        switch (day){
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saurday";
            case Calendar.SUNDAY:
                return "Sunday";
            default:
                return "";
        }
    }
}
