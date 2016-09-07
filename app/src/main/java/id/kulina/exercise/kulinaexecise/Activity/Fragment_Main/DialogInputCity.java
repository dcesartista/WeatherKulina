package id.kulina.exercise.kulinaexecise.Activity.Fragment_Main;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
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
 * A simple {@link Fragment} subclass.
 */
public class DialogInputCity extends DialogFragment {
    private static final String TAG = DialogInputCity.class.getSimpleName();
    private static final String NO_CITY_ERROR = "Invalid double: \"Error: Not found city\"";
    public static final String FORECASTING_CANCELLED = "java.net.SocketException: Socket closed";

    Activity activity;
    ProgressDialog progressDialog;
    Call<Forecasts> call;

    public DialogInputCity() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialog_input_city, null);
        final EditText city = (EditText) view.findViewById(R.id.et_city_name);
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Forecasting...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                call.cancel();
            }
        });

        builder.setView(view)
               .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                       getForecast(city.getText().toString());
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       DialogInputCity.this.getDialog().cancel();
                   }
               });
        return builder.create();
    }

    private void getForecast(String city){


        Map<String,String> params= new HashMap<>();
        params.put("q",city);
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
                Intent intent = new Intent(activity, DetailActivity.class);
                intent.putExtra(MainActivityFragment.EXTRA_FORECASTS,forecasts);
                activity.startActivity(intent);
            }

            @Override
            public void onFailure(Call<Forecasts> call, Throwable t) {
                Log.v(TAG, t.getMessage().toString());
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                if(String.valueOf(t.getMessage()).equals(NO_CITY_ERROR)){
                    Toast.makeText(activity,"City Name Not Found, Please try another city.",Toast.LENGTH_LONG).show();
                } else if(t.toString().equals(FORECASTING_CANCELLED)){
                    Toast.makeText(activity,"Forecasting cancelled!",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(activity,"Failed to get weather data. Please check your internet connection!",Toast.LENGTH_LONG).show();
                }

            }
        });
        dismiss();
    }

}
