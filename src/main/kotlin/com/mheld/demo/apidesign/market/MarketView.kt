package com.mheld.demo.apidesign.market

import com.mheld.demo.apidesign.player.PlayerService
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class MarketView(private val marketService: MarketService, private val playerService: PlayerService) {

	@ShellMethod(key = ["sell"], value = "Sells the specified resource")
	fun sell(amount: Int, resource: String) {
		marketService.sell(resource, amount)
		println("Sold $amount $resource. You have ${playerService.getMoney()} money now")
	}

	@ShellMethod(key = ["buy"], value = "Buys the specified resource")
	fun buy(amount: Int, resource: String) {
		marketService.buy(resource, amount)
		println("Bought $amount $resource. You have ${playerService.getMoney()} money now")
	}

}
