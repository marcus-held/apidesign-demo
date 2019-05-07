package com.mheld.demo.apidesign.economy

import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class ResourceRepository {

	private val resources = listOf<Resource>(
			Resource("Wood"),
			Resource("Stone")
	)

	fun findByName(name : String) = resources.find { resource -> resource.name == name } ?: throw IllegalArgumentException()

}
