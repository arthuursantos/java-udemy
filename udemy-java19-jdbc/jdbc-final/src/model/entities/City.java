package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private int ID;
    private String Name;
    private String District;
    private int Population;

    private Country Country;

    public City() {
    }

    public City(int ID, String name, String district, int population, model.entities.Country country) {
        this.ID = ID;
        Name = name;
        District = district;
        Population = population;
        Country = country;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public model.entities.Country getCountry() {
        return Country;
    }

    public void setCountry(model.entities.Country country) {
        Country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return ID == city.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Country=" + Country +
                '}';
    }
}
