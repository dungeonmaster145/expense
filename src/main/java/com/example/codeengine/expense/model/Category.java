package com.example.codeengine.expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="category")
@Data
//data annotation of the lombok library automatically creates getters and setters for the variables that we have just created
//@AllArgsConstructor creates an argumented constructor for the parameters that we just passed for our values
public class Category
{
     @Id
    private long id;
     //travel and grocery
    @NotNull
     private String name;
   //  @ManyToOne(cascade = CascadeType.PERSIST)
     //this means that many categories can be assigned to one single user
     //many to one the first part reflects on the current class and the second part reflects on the parent class
    //private User user;

}
