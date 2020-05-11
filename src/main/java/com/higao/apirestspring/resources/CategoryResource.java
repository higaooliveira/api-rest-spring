package com.higao.apirestspring.resources;

import com.higao.apirestspring.entities.Category;
import com.higao.apirestspring.entities.User;
import com.higao.apirestspring.services.CategoryService;
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
public class CategoryResource {

    @Autowired(required = true)
    private CategoryService categoryService;

    @GetMapping(value="/categories")
    public ResponseEntity<List<Category>> findAllUsers(){
        List<Category> categoryList = this.categoryService.findAll();
        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value="/category/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = this.categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }
}
