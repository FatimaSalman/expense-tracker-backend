package com.fatima.expense_tracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExpenseTrackerApiApplication

fun main(args: Array<String>) {
	runApplication<ExpenseTrackerApiApplication>(*args)
}
