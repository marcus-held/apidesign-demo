package com.mheld.demo.apidesign.economy

import com.mheld.demo.apidesign.player.PlayerRepository
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class MarketView(private val marketService: MarketService, private val playerRepository: PlayerRepository) {

	@ShellMethod(key = ["sell"], value = "Sells the specified resource")
	fun sell(amount: Int, resource: String) {
		val player = playerRepository.getCurrent()
		marketService.sell(player, Resource(resource), amount)
		println("Sold $amount $resource. You have ${player.money} money now")
	}

	@ShellMethod(key = ["buy"], value = "Buys the specified resource")
	fun buy(amount: Int, resource: String) {
		val player = playerRepository.getCurrent()
		marketService.buy(player, Resource(resource), amount)
		println("Bought $amount $resource. You have ${player.money} money now")
	}

}
