package com.mheld.demo.apidesign.player

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class PlayerView(private val playerService: PlayerService) {

	@ShellMethod(value = "Get information about the current player", key = ["info"])
	fun info() = println(playerService.player)

	@ShellMethod(value = "Lists the inventory of the player", key = ["inventory", "inv"])
	fun inventory() = playerService.getAllResources()
			.forEach { (resource , amount)-> println("$resource : $amount") }
}
