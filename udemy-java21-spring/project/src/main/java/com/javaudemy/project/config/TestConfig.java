package com.javaudemy.project.config;

import com.javaudemy.project.entities.*;
import com.javaudemy.project.entities.enums.OrderStatus;
import com.javaudemy.project.repositories.*;
import com.javaudemy.project.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Arthur Santos", "arthur@gmail.com", "19999344489", "vaicorinthians");
        User u2 = new User("João Felipe", "joao@yahoo.com", "19998764532", "mortis1000");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(OrderStatus.WAITING_PAYMENT, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(OrderStatus.SHIPPED,Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(OrderStatus.DELIVERED,Instant.parse("2019-07-22T15:21:22Z"), u1);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Category cat1 = new Category("Electronics");
        Category cat2 = new Category("Books");
        Category cat3 = new Category("Computers");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Payment pay1 = new Payment(Instant.parse("2019-06-20T19:53:07Z"), o1);
        o1.setPayment(pay1);
        orderRepository.save(o1);

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

    }
}
