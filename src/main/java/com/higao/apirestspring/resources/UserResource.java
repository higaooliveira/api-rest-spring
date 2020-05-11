package com.higao.apirestspring.resources;

import com.higao.apirestspring.entities.User;
import com.higao.apirestspring.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping(value="/users")
    public ResponseEntity<User> create(@RequestBody User user){
        user = this.userService.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(user);
    }
    @PutMapping(value="/user/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        user = this.userService.update(id, user);

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value="/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
