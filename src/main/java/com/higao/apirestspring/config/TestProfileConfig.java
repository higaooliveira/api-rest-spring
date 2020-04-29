package com.higao.apirestspring.config;

import com.higao.apirestspring.entities.Order;
import com.higao.apirestspring.entities.User;
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


    @Override
    public void run(String... args) throws Exception {
        User firstUser = new User("Higor Teste 1", "higor@gmail.com", "999999999", "123456");
        User secondUser = new User("Higor Teste 2", "higor@gmail.com", "999999999", "123456");

        Order firstOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), firstUser);
        Order secondOrder = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), secondUser);
        Order thirdOrder = new Order(null, Instant.parse("2019-06-20T19:54:07Z"), firstUser);
        this.userRepository.saveAll(Arrays.asList(firstUser, secondUser));
        this.orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));
    }
}
