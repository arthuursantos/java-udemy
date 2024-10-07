package lambda004_function;

import lambda003_consumer.entities.Product;
import lambda004_function.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.0));
        products.add(new Product("Mouse", 50.0));
        products.add(new Product("Tablet", 350.5));
        products.add(new Product("HD Case", 80.0));

        double sum = ProductService.filterSum(products, p -> p.getName().charAt(0) == 'T');
        System.out.println(sum);

        List<Product> productsReformatted = products.stream().map(product -> {
            product.setPrice(product.getPrice() * 2);
            product.setName(product.getName().toUpperCase());
            return product;
        }).toList();

        productsReformatted.forEach(System.out::println);

    }
}
