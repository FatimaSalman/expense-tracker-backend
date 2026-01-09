package com.fatima.expense_tracker.model

import jakarta.persistence.*

@Entity
@Table(name = "expenses")
data class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val amount: Double,
    val category: String
)