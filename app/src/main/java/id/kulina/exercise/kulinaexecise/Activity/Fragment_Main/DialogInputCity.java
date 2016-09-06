package id.kulina.exercise.kulinaexecise.Activity.Fragment_Main;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import id.kulina.exercise.kulinaexecise.API.GetWeatherAPI;
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

    public DialogInputCity() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialog_input_city, null);
        final EditText city = (EditText) view.findViewById(R.id.et_city_name);

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
        Call<Forecasts> call = getWeatherAPI.forecasts(params);
        call.enqueue(new Callback<Forecasts>() {
            @Override
            public void onResponse(Call<Forecasts> call, Response<Forecasts> response) {
                Forecasts forecasts = response.body();
                Log.v(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<Forecasts> call, Throwable t) {
                Log.v(TAG, t.toString());
            }
        });
    }

}
