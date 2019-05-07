package com.mheld.demo.apidesign.economy

import com.mheld.demo.apidesign.player.PlayerRepository
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class MarketView(val marketService: MarketService, val playerRepository: PlayerRepository) {

	@ShellMethod(key = ["sell"], value = "Sells the specified resource")
	fun sell(resource: String, amount: Int) {
		marketService.sell(playerRepository.getCurrent(), Resource(resource), amount)
	}

	@ShellMethod(key = ["buy"], value = "Buys the specified resource")
	fun buy(resource: String, amount: Int) {
		marketService.buy(playerRepository.getCurrent(), Resource(resource), amount)
	}

}
