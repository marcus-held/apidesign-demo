package com.mheld.demo.apidesign.player

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class PlayerView(val playerRepository: PlayerRepository, val playerFactory: PlayerFactory) {

	@ShellMethod(value = "Creates a new Player.", key = ["new"])
	fun newPlayer(name: String) {
		playerRepository.save(playerFactory.createNewPlayer(name))
		println("Created a new player $name")
	}

	@ShellMethod(value = "Get information about the current player", key = ["info"])
	fun info() = println(playerRepository.getCurrent() ?: "You didn't create a player yet")

	@ShellMethod(value = "Lists the inventory of the player", key = ["inventory", "inv"])
	fun inventory() = playerRepository.getCurrent().inventory.getAll()
			.forEach { (resource, amount) -> println("${resource.name} : $amount") }
}
