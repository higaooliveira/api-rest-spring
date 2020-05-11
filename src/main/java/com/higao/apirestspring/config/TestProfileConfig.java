package com.higao.apirestspring.config;

import com.higao.apirestspring.entities.*;
import com.higao.apirestspring.entities.enums.OrderStatus;
import com.higao.apirestspring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {

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
        Category firstCat = new Category(null, "Higor Teste 1");
        Category secondCat = new Category(null, "Higor Teste 2");
        Category thirdCat = new Category(null, "Higor Teste 3");

        Product p1 = new Product(null, "Headset Gamer Hyperx", "Best HeadSet Ever", 250.0, "");
        Product p2 = new Product(null, "Teclado Gamer Hyperx", "Best Teclado Ever", 650.0, "");
        Product p3 = new Product(null, "Mouse Gamer Hyperx", "Best Mouse Ever", 150.0, "");
        Product p4 = new Product(null, "Produto Gamer Hyperx", "Best Produto Ever", 1000.0, "");
        this.categoryRepository.saveAll(Arrays.asList(firstCat, secondCat, thirdCat));
        this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        p1.getCategories().add(secondCat);
        p1.getCategories().add(firstCat);
        p1.getCategories().add(thirdCat);

        p2.getCategories().add(secondCat);
        p2.getCategories().add(thirdCat);

        p3.getCategories().add(firstCat);
        p3.getCategories().add(thirdCat);
        this.productRepository.saveAll(Arrays.asList(p1, p2, p3));

        User firstUser = new User("Higor Teste 1", "higor@gmail.com", "999999999", "123456");
        User secondUser = new User("Higor Teste 2", "higor@gmail.com", "999999999", "123456");

        Order firstOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, firstUser);
        Order secondOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, secondUser);
        Order thirdOrder = new Order(null, Instant.parse("2019-06-20T19:54:07Z"), OrderStatus.WAITING_PAYMENT, firstUser);

        this.userRepository.saveAll(Arrays.asList(firstUser, secondUser));
        this.orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));

        OrderItem oi1 = new OrderItem(firstOrder, p1, 2, p1.getPrice());
        OrderItem oi5 = new OrderItem(firstOrder, p4, 2, p4.getPrice());
        OrderItem oi2 = new OrderItem(secondOrder, p2, 1, p2.getPrice());
        OrderItem oi3 = new OrderItem(thirdOrder, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(firstOrder, p4, 5, p4.getPrice());

        this.orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));

        Payment payment1 = new Payment(null, Instant.parse("2019-06-20T21:53:07|"), firstOrder);
        firstOrder.setPayment(payment1);

        this.orderRepository.save(firstOrder);
    }
}
