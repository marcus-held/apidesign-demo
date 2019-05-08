package com.mheld.demo.apidesign.player

import com.mheld.demo.apidesign.economy.ResourceRepository
import com.mheld.demo.apidesign.player.model.Inventory
import com.mheld.demo.apidesign.player.model.Player
import org.springframework.stereotype.Service

@Service
class PlayerFactory(private val resourceRepository: ResourceRepository) {

	fun createNewPlayer(name : String) :Player {
		val inventory = Inventory(mutableMapOf())

		return Player(name, inventory, 500)
	}

}
