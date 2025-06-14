package com.batch14.productmanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@EnableFeignClients(basePackages = ["com.batch14.productmanagementservice.rest"])
class ProductManagementServiceApplication

fun main(args: Array<String>) {
	runApplication<ProductManagementServiceApplication>(*args)
}
