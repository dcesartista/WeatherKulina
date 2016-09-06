package id.kulina.exercise.kulinaexecise.POJO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ACER on 9/6/2016.
 */
public class DailyForecast implements Serializable{
    private int dt;
    private Temperature temp;
    private float pressure;
    private int humidity;
    private ArrayList<Weather> weather;
    private float speed;
    private int deg;
    private int clouds;
    private float rain;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    @Override
    public String toString() {
        return "DailyForecast{" +
               "dt=" + dt +
               ", temp=" + temp +
               ", pressure=" + pressure +
               ", humidity=" + humidity +
               ", weather=" + weather +
               ", speed=" + speed +
               ", deg=" + deg +
               ", clouds=" + clouds +
               ", rain=" + rain +
               '}';
    }
}




