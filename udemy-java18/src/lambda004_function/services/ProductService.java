package lambda004_function.services;

import lambda003_consumer.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public static double filterSum(List<Product> products, Predicate<Product> criteria) {
        double sum = 0.0;
        for (Product product : products) {
            if (criteria.test(product)) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

}
