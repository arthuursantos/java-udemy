package streams002;

import streams002.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        String path = System.getenv("HOMEPATH")+"\\Ambiente de Trabalho\\in.csv";
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                products.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        double average = products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum) / products.size();

        System.out.printf("Average: %.2f\n", average);

        List<String> productsFlt = products.stream()
                .filter(p -> p.getPrice()<average)
                .map(Product::getName)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(productsFlt);

    }
}
