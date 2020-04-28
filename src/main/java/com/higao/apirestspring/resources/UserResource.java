package com.higao.apirestspring.resources;

import com.higao.apirestspring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAllUsers(){
        User u = new User("Teste", "higoa@gmail.com", "1999999999","blablabla");

        return ResponseEntity.ok().body(u);
    }
}
