package com.mheld.demo.apidesign.player.model

data class Player(val name: String, val inventory: Inventory, private var money: Int) {

	fun reduceMoney(amount: Int) {
		if (money > amount) {
			money -= amount
		} else {
			throw IllegalArgumentException("Not enough money to reduce from player.")
		}
	}

	fun addMoney(amount: Int) {
		money += amount
	}

}
