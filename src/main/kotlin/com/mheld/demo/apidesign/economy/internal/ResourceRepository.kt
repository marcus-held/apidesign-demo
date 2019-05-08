package com.mheld.demo.apidesign.economy.internal

import com.mheld.demo.apidesign.economy.ResourceId

internal class ResourceRepository {

	private val resources = listOf(
			Resource(ResourceId(1), "comic", 3),
			Resource(ResourceId(2), "videogame", 50),
			Resource(ResourceId(3), "doll", 15)
	)

	fun findAll() = resources.toList()
	fun findByName(resource: String) = resources.first { r -> r.name == resource }
	fun findById(resourceId: ResourceId) = resources.first { r -> r.id == resourceId}

}
