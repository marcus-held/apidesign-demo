package com.mheld.demo.apidesign.economy

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class EconomyView(private val resourceService: ResourceService) {

	@ShellMethod(key = ["listPrices"], value = "Lists current prices of resources")
	fun listPrices() {
		resourceService.getAll()
				.forEach { resource -> println("${resource.name} -> ${resource.price}") }
	}

}
