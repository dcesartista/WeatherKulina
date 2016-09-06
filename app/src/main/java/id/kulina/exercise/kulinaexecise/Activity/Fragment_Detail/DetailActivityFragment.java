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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import id.kulina.exercise.kulinaexecise.Activity.Fragment_Main.MainActivityFragment;
import id.kulina.exercise.kulinaexecise.POJO.Forecasts;
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

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Date date = new Date(time*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = simpleDateFormat.format(date);
        Log.v(TAG, formattedDate);

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
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    HashMap<String,String> detail0 = new HashMap<>();
                    detail0.put("morning","30");
                    detail0.put("evening","30");
                    detail0.put("night","30");
                    return DetailPagerFragment.newInstance(position+1);
                case 1:
                    HashMap<String,String> detail1 = new HashMap<>();
                    detail1.put("pressure","30");
                    detail1.put("wind speed","30");
                    detail1.put("wind direction","30");
                    return DetailPagerFragment.newInstance(position+1);
                case 2:
                    HashMap<String,String> detail2 = new HashMap<>();
                    detail2.put("humidity","30");
                    detail2.put("clouds","30");
                    detail2.put("rain","30");
                    return  DetailPagerFragment.newInstance(position+1);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
