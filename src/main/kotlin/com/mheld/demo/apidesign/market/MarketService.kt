package com.mheld.demo.apidesign.market

import com.mheld.demo.apidesign.economy.ResourceService
import com.mheld.demo.apidesign.player.PlayerService
import org.springframework.stereotype.Service

@Service
class MarketService(private val resourceService: ResourceService, private val playerService: PlayerService) {

	fun buy(resourceName: String, amount: Int) {

		val resourceId = resourceService.getIdOf(resourceName)
		val price = resourceService.getPriceFor(resourceId)

		playerService.reduceMoney(price * amount)
		playerService.addToInventory(resourceId, amount)
	}

	fun sell(resourceName: String, amount: Int) {

		val resourceId = resourceService.getIdOf(resourceName)
		val price = resourceService.getPriceFor(resourceId)

		playerService.removeFromInventory(resourceId, amount)
		playerService.addMoney(price * amount)
	}

}
