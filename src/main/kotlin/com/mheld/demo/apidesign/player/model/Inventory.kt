package com.mheld.demo.apidesign.player.model

import com.mheld.demo.apidesign.economy.ResourceId

internal data class Inventory(private val store : MutableMap<ResourceId, Int> = mutableMapOf()) {

	fun getAll() = store.toMap()

	fun add(resource: ResourceId, amount: Int) = store.put(resource, (store[resource] ?: 0) + amount)

	fun remove(resource: ResourceId, amount: Int) {
		val amountInStore = store[resource] ?: 0
		val newAmountInStore = amountInStore - amount
		when {
			newAmountInStore < 0 -> throw IllegalArgumentException("You don't have enough $resource in your inventory ($amountInStore)")
			newAmountInStore == 0 -> store.remove(resource)
			newAmountInStore > 0 -> store[resource] = newAmountInStore
		}
	}

}
