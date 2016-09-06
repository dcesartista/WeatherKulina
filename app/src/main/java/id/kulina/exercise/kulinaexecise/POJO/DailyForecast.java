package id.kulina.exercise.kulinaexecise.POJO;

import java.util.ArrayList;

/**
 * Created by ACER on 9/6/2016.
 */
public class DailyForecast {
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

class Weather{
    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
               "id=" + id +
               ", main='" + main + '\'' +
               ", description='" + description + '\'' +
               ", icon='" + icon + '\'' +
               '}';
    }
}

class Temperature{
    private float day;
    private float min;
    private float max;
    private float night;
    private float eve;
    private float morn;

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getNight() {
        return night;
    }

    public void setNight(float night) {
        this.night = night;
    }

    public float getEve() {
        return eve;
    }

    public void setEve(float eve) {
        this.eve = eve;
    }

    public float getMorn() {
        return morn;
    }

    public void setMorn(float morn) {
        this.morn = morn;
    }

    @Override
    public String toString() {
        return "Temperature{" +
               "day=" + day +
               ", min=" + min +
               ", max=" + max +
               ", night=" + night +
               ", eve=" + eve +
               ", morn=" + morn +
               '}';
    }
}
