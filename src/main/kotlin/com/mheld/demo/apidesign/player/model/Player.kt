package com.mheld.demo.apidesign.player.model

internal data class Player(private var _money: Int,
				  val inventory: Inventory = Inventory()) {

	var money: Int
		get() = _money
		private set(value) {
			_money = value
		}

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
