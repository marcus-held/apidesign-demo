package com.mheld.demo.apidesign.economy

import com.mheld.demo.apidesign.player.model.Player
import org.springframework.stereotype.Service

@Service
class MarketService(val resourceConversionService: ResourceConversionService) {

	fun buy(player: Player, resource: Resource, amount: Int) {
		val price = resourceConversionService.getPriceFor(resource)

		player.reduceMoney(price * amount)
		player.inventory.add(resource, amount)
	}

	fun sell(player: Player, resource: Resource, amount: Int) {
		val price = resourceConversionService.getPriceFor(resource)

		player.inventory.remove(resource, amount)
		player.addMoney(price * amount)
	}

}
