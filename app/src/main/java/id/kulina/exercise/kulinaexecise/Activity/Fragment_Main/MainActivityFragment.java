package id.kulina.exercise.kulinaexecise.Activity.Fragment_Main;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import id.kulina.exercise.kulinaexecise.API.GetWeatherAPI;
import id.kulina.exercise.kulinaexecise.Activity.DetailActivity;
import id.kulina.exercise.kulinaexecise.App;
import id.kulina.exercise.kulinaexecise.POJO.Forecasts;
import id.kulina.exercise.kulinaexecise.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = MainActivityFragment.class.getSimpleName();
    public static final String EXTRA_FORECASTS = "Forecasts";

    private View rootView;
    private Button inputCity, currentLoc;
    ProgressDialog progressDialog;
    Call<Forecasts> call;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Forecasting...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                call.cancel();
            }
        });
        initUIComponent();

        return rootView;
    }

    private void initUIComponent(){
        inputCity = (Button) rootView.findViewById(R.id.btn_input_city);
        inputCity.setOnClickListener(this);
        currentLoc = (Button) rootView.findViewById(R.id.btn_current_loc);
        currentLoc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.btn_input_city):
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                DialogInputCity inputCityDialog = new DialogInputCity();
                inputCityDialog.show(fragmentManager, "dialog");
                break;
            case (R.id.btn_current_loc):
                if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

                    ActivityCompat.requestPermissions(getActivity(), new String[] {android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                                                      App.MY_PERMISSION_ACCESS_COURSE_LOCATION );
                }

                LocationManager lm = (LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE);
                Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                double longitude = location.getLongitude();
                double latitude = location.getLatitude();
                getForecast(latitude,longitude);
                break;
        }
    }

    private void getForecast(double lat, double lon){

        Map<String,String> params= new HashMap<>();
        params.put("lat",String.valueOf(lat));
        params.put("lon",String.valueOf(lon));
        params.put("cnt",String.valueOf(App.NUM_OF_DAYS_FETCHED));
        params.put("mode",App.MODE);
        params.put("units",App.UNITS);
        params.put("appid",App.APPID);

        GetWeatherAPI getWeatherAPI= GetWeatherAPI.retrofit.create(GetWeatherAPI.class);
        call = getWeatherAPI.forecasts(params);
        progressDialog.show();
        call.enqueue(new Callback<Forecasts>() {
            @Override
            public void onResponse(Call<Forecasts> call, Response<Forecasts> response) {
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                Forecasts forecasts = response.body();
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra(EXTRA_FORECASTS,forecasts);
                getContext().startActivity(intent);
            }

            @Override
            public void onFailure(Call<Forecasts> call, Throwable t) {
                Log.v(TAG, t.toString());
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                if(t.toString().equals(DialogInputCity.FORECASTING_CANCELLED)){
                    Toast.makeText(getContext(),"Forecasting cancelled!",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(),"Failed to get weather data. Please check your internet connection!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
