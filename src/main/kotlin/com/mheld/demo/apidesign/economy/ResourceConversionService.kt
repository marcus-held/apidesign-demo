package com.mheld.demo.apidesign.economy

import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class ResourceConversionService {

	private val conversions: Map<Resource, Int> = mapOf(
			Resource("comic") to 3,
			Resource("videogame") to 50,
			Resource("doll") to 15
	)

	fun getAll() = conversions.toMap()

	fun getPriceFor(resource: Resource) = conversions[resource] ?: throw IllegalArgumentException("I don't have a price for $resource")

}
