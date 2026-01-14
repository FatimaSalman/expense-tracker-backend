package com.fatima.expense_tracker.controller

import com.fatima.expense_tracker.model.Expense
import com.fatima.expense_tracker.repository.ExpenseRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/expenses")
class ExpenseController(val repository: ExpenseRepository) {

    // 1. get all Expense
    @GetMapping
    fun getAllExpenses(): List<Expense> = repository.findAll()

    // 2. add new expense
    @PostMapping
    fun addExpense(@RequestBody expense: Expense): Expense = repository.save(expense)

    // 2. delete a expense
    @DeleteMapping("/{id}")
    fun deleteExpense(@PathVariable id: Long): ResponseEntity<Map<String, String>> {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            ResponseEntity.ok(mapOf("message" to "تم حذف المصروف بنجاح من السيرفر!"))
        } else {
            ResponseEntity.status(404).body(mapOf("message" to "عذراً، المصروف غير موجود"))
        }
    }

    // 3. get categories
    @GetMapping("/categories")
    fun getCategories(): List<String> {
        return listOf("Food", "Transport", "Shopping", "Bills", "Health", "General", "Education")
    }

}