package com.higao.apirestspring.services;

import com.higao.apirestspring.entities.User;
import com.higao.apirestspring.repositories.UserRepository;
import com.higao.apirestspring.services.exceptions.DatabaseException;
import com.higao.apirestspring.services.exceptions.ResourceNotFoundException;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User create(User user){
        return this.userRepository.save(user);
    }

    public User update(Long id, User user){
        try {
            User entity = this.userRepository.getOne(id);
            entity.updateData(user);
            return this.userRepository.save(entity);
        }catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException(id);
        }
    }
    public void delete(Long id){
        try {
            this.userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException ex){
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }
}
