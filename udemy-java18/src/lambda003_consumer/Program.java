package lambda003_consumer;

import lambda003_consumer.entities.Product;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        //o consumer tambem é uma interface funcional
        //possui o metodo accept que retorna um void
        //util para alterar os elementos ou fazer qlqr coisa com eles

        Locale.setDefault(Locale.US);
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.0));
        products.add(new Product("Mouse", 50.0));
        products.add(new Product("Tablet", 350.5));
        products.add(new Product("HD Case", 80.0));

        products.forEach(p -> p.setName(p.getName().toUpperCase()));
        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName())); //predicate aqui
        products.forEach(System.out::println);

    }
}
