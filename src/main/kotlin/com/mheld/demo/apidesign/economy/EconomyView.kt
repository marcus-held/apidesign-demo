package com.mheld.demo.apidesign.economy

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class EconomyView(val resourceConversionService: ResourceConversionService) {

	@ShellMethod(key = ["listPrices"], value = "Lists current prices of resources")
	fun listPrices() {
		resourceConversionService.getAll().forEach { (resource, price) -> println("$resource -> $price") }
	}

}
