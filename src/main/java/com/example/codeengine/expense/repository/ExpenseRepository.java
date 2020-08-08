package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {


}
