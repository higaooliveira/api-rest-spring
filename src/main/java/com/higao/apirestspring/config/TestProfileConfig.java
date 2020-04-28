package com.higao.apirestspring.config;

import com.higao.apirestspring.entities.User;
import com.higao.apirestspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User firstUser = new User("Higor Teste 1", "higor@gmail.com", "999999999", "123456");
        User secondUser = new User("Higor Teste 2", "higor@gmail.com", "999999999", "123456");

        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
    }
}
