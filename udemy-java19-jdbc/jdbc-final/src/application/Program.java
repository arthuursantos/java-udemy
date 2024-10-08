package application;

import model.entities.City;
import model.entities.Country;

public class Program {
    public static void main(String[] args) {
        Country country = new Country("BRA", "Brazil", "South America", "South America", 8547403.00, 1822, 170115000, 62.9, 776739.00, 804108.00, "Brasil", "Federal Republic", "Fernando Henrique Cardoso", 211, "BR");
        System.out.println(country);
        City city = new City(433, "Elias Fausto", country, "São Paulo", 53433);
        System.out.println(city);
    }
}
