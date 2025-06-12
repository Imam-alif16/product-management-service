package com.batch14.productmanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class ProductManagementServiceApplication

fun main(args: Array<String>) {
	runApplication<ProductManagementServiceApplication>(*args)
}
