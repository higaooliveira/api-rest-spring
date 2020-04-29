package com.higao.apirestspring.config;

import com.higao.apirestspring.entities.Category;
import com.higao.apirestspring.entities.Order;
import com.higao.apirestspring.entities.User;
import com.higao.apirestspring.entities.enums.OrderStatus;
import com.higao.apirestspring.repositories.CategoryRepository;
import com.higao.apirestspring.repositories.OrderRepository;
import com.higao.apirestspring.repositories.UserRepository;
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


    @Override
    public void run(String... args) throws Exception {
        User firstUser = new User("Higor Teste 1", "higor@gmail.com", "999999999", "123456");
        User secondUser = new User("Higor Teste 2", "higor@gmail.com", "999999999", "123456");

        Order firstOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, firstUser);
        Order secondOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, secondUser);
        Order thirdOrder = new Order(null, Instant.parse("2019-06-20T19:54:07Z"), OrderStatus.WAITING_PAYMENT, firstUser);

        Category firstCat = new Category(null, "Higor Teste 1");
        Category secondCat = new Category(null, "Higor Teste 2");
        Category thirdCat = new Category(null, "Higor Teste 3");

        this.categoryRepository.saveAll(Arrays.asList(firstCat, secondCat, thirdCat));
        this.userRepository.saveAll(Arrays.asList(firstUser, secondUser));
        this.orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));
    }
}
