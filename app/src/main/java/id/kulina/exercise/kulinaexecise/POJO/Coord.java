package id.kulina.exercise.kulinaexecise.POJO;

import java.io.Serializable;

/**
 * Created by ACER on 9/6/2016.
 */
public class Coord implements Serializable {
    private double lon;
    private double lat;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Coord{" +
               "lon=" + lon +
               ", lat=" + lat +
               '}';
    }
}
