package com.example.codeengine.expense.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;


@Entity
//this entity annotation specifies that this class is an entity and is mapped to a database table
@Table(name="expense")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Expense {
    @Id
    //to specify the primary key of the entity we use Id annotation
    private long id;

    private Instant expenseDate;
    private String location;
    private String descript;

    @ManyToOne
    //this many to one relation means that many of these expenses can go under one single category
    private Category category;

    @JsonIgnore
    @ManyToOne
    //Many expenses can go to one user
    //a point to remember that the left part of the realtion always relates to the current class and the right part of the relation realtes to the object of the class that we are using here
    private User user;
}
