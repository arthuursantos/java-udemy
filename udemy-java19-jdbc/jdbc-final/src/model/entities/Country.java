package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private String Code;
    private String Name;
    private String Continent;

    public Country() {
    }

    public Country(String code, String name, String continent) {
        Code = code;
        Name = name;
        Continent = continent;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(Code, country.Code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Code);
    }

    @Override
    public String toString() {
        return "Country{" +
                "Code='" + Code + '\'' +
                ", Name='" + Name + '\'' +
                ", Continent='" + Continent + '\'' +
                '}';
    }
}
