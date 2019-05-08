package com.mheld.demo.apidesign.economy

import com.mheld.demo.apidesign.economy.internal.ResourceRepository
import org.springframework.stereotype.Service

@Service
class ResourceService() {

	private val resourceRepository = ResourceRepository()

	internal fun getAll() = resourceRepository.findAll()

	fun getPriceFor(resourceId: ResourceId) = resourceRepository.findById(resourceId).price
	fun getNameOf(resourceId: ResourceId) = resourceRepository.findById(resourceId).name
	fun getIdOf(resourceName: String) = resourceRepository.findByName(resourceName).id

}
