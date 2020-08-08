package com.example.codeengine.expense.Controller;


import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.repository.CategoryRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
  private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        //super();
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/categories")
    //we are using collection here because that way it will retirn a bunch of categories at one go
    Collection<Category> categories()
    {
           return categoryRepository.findAll();
           //this is basically a rip off of select * from categories
    }
    //the below code is used to access the category of any given specified ID
    @GetMapping({"category/{id}"})
    ResponseEntity<?> getCategory(@PathVariable Long id)
    {
        //we made it optional here because we don't know whether the id that we are looking for exists or not
         Optional<Category> category=categoryRepository.findById(id);
         //below we will return the value of the category int he form of stream
        //if the response is found then we attach it to body and send it to the browser other wise we will display the status 200 not found
        //so this is bascically a response entity
          return category.map(response ->ResponseEntity.ok().body(response))
                  .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@Valid @RequestBody Category category)throws URISyntaxException
    {
       Category result=categoryRepository.save(category);
       //the above statement is equivalent to insert into table query'
        return ResponseEntity.created(new URI("/api/category" +result.getId())).body(result);
    }
    @PutMapping("/category/{id}")
    ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category)
    {
        //this function is basically a update statement like update table xyz .....
        Category result=categoryRepository.save(category);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id)
    {
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
