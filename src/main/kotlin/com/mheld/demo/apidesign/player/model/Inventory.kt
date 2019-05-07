package com.mheld.demo.apidesign.player.model

import com.mheld.demo.apidesign.economy.Resource

data class Inventory(private val store : MutableMap<Resource, Int>) {

	fun getAll() = store.toMap()

	fun add(resource: Resource, amount: Int) = store.put(resource, (store[resource] ?: 0) + amount)

	fun remove(resource: Resource, amount: Int) {
		val amountInStore = store[resource] ?: 0
		val newAmountInStore = amountInStore - amount
		when {
			newAmountInStore < 0 -> throw IllegalArgumentException("You don't have enough $resource in your inventory ($amountInStore)")
			newAmountInStore == 0 -> store.remove(resource)
			newAmountInStore > 0 -> store[resource] = newAmountInStore
		}
	}

}
