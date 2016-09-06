package id.kulina.exercise.kulinaexecise.POJO;

/**
 * Created by ACER on 9/6/2016.
 */
public class City{
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", coord=" + coord +
               ", country='" + country + '\'' +
               ", population=" + population +
               '}';
    }
}

class Coord{
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
