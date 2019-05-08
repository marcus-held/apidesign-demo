package com.mheld.demo.apidesign.player

import com.mheld.demo.apidesign.economy.ResourceId
import com.mheld.demo.apidesign.economy.ResourceService
import com.mheld.demo.apidesign.player.model.Player
import org.springframework.stereotype.Component

@Component
class PlayerService(private val resourceService: ResourceService) {

	internal val player = Player(500)

	fun getAllResources() = player.inventory.getAll()
			.map { (resourceId, amount) -> resourceService.getNameOf(resourceId) to amount}
			.toMap()

	fun reduceMoney(amount: Int) {
		player.reduceMoney(amount)
	}

	fun addToInventory(resourceId: ResourceId, amount: Int) {
		player.inventory.add(resourceId, amount)
	}

	fun removeFromInventory(resourceId: ResourceId, amount: Int) {
		player.inventory.remove(resourceId, amount)
	}

	fun addMoney(amount: Int) {
		player.addMoney(amount)
	}

	fun getMoney() = player.money

}
