package com.higao.apirestspring.resources;

import com.higao.apirestspring.entities.User;
import com.higao.apirestspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UserResource {

    @Autowired(required = true)
    private UserService userService;

    @GetMapping(value="/users")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> userList = this.userService.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value="/user/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = this.userService.findById(id);

        return ResponseEntity.ok().body(user);
    }
}
