package com.example.codeengine.expense.Controller;


import com.example.codeengine.expense.model.Expense;
import com.example.codeengine.expense.repository.ExpenseRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ExpenseController {
   @Autowired
    private ExpenseRepository expenseRepository;


    @GetMapping("/expenses")
    Collection<Expense> getExpenses()
    {
        return expenseRepository.findAll();
    }
    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id)
    {
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }
    @PostMapping("/expenses")
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense)throws URISyntaxException
    {
        Expense result=expenseRepository.save(expense);
        return ResponseEntity.created(new URI("/api/expenses" +result.getId())).body(result);
    }

    @PutMapping("/expenses/{id}")
    ResponseEntity<Expense> updateCategory(@Valid @RequestBody Expense expense)
    {
        //this function is basically a update statement like update table xyz .....
        Expense result=expenseRepository.save(expense);
        return ResponseEntity.ok().body(result);
    }

}
