package id.kulina.exercise.kulinaexecise.POJO;

import java.io.Serializable;

/**
 * Created by ACER on 9/6/2016.
 */
public class City implements Serializable{
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


