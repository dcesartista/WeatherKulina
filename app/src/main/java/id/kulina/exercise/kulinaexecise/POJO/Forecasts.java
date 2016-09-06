package id.kulina.exercise.kulinaexecise.POJO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ACER on 9/6/2016.
 */
public class Forecasts implements Serializable{
    private City city;
    private String cod;
    private double message;
    private int cnt;
    private ArrayList<DailyForecast> list;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<DailyForecast> getList() {
        return list;
    }

    public void setList(ArrayList<DailyForecast> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Forecasts{" +
               "list=" + list +
               ", cnt=" + cnt +
               ", message=" + message +
               ", cod='" + cod + '\'' +
               ", city=" + city +
               '}';
    }
}

