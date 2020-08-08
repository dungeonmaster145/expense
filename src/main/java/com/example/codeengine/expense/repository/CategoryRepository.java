package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
//the extension to the JPA repository means that now we have a connection to a database
public interface CategoryRepository extends JpaRepository<Category,Long>
{
    //here findBy+name the name is actually the name variable that we have passed in the Category class which enables us to find the serched value by its name
    Category findByName(String name);
}
