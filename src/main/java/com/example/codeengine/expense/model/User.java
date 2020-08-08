package com.example.codeengine.expense.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="user")
public class User {

    @Id
    private long id;
    private String name;
    private String email;
    //@OneToMany
    //this means that one user can have many categories fo his expenses as mentioned above
    //we are using set here because that way it removes duplicate values
   // private Set<Category> category;

}
