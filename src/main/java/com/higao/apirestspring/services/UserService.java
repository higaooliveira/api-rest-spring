package com.higao.apirestspring.services;

import com.higao.apirestspring.entities.User;
import com.higao.apirestspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User create(User user){
        return this.userRepository.save(user);
    }

    public User update(Long id, User user){
        User entity = this.userRepository.getOne(id);

        entity.updateData(user);

        return this.userRepository.save(entity);
    }
    public void delete(Long id){
        this.userRepository.deleteById(id);
    }
}
