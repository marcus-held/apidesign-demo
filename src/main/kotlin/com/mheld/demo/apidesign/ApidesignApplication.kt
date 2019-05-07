package com.mheld.demo.apidesign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class ApidesignApplication

fun main(args: Array<String>) {
	runApplication<ApidesignApplication>(*args)
}
