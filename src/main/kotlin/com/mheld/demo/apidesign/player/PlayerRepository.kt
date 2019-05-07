package com.mheld.demo.apidesign.player

import com.mheld.demo.apidesign.player.model.Player
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException
import java.util.*

@Component
class PlayerRepository {

	private var player: Player? = null

	fun save(player: Player) {
		this.player = player
	}

	fun getCurrent() = player ?: throw IllegalArgumentException("No player saved yet")

}
