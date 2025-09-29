package com.example.beastsandhumans

import kotlin.random.Random

fun main() {
    val player = Player(
        attack = 25,
        defense = 20,
        maxHealth = 100,
        damageRange = 10..15
    )

    val monster = Monster(
        attack = 15,
        defense = 10,
        maxHealth = 80,
        damageRange = 5..10
    )

    while (player.isAlive && monster.isAlive) {
        player.attack(monster)
        if (monster.isAlive) {
            monster.attack(player)
        }
        
        if (player.isAlive && player.health < 50 && Random.nextBoolean()) {
            player.heal()
        }
    }

    println(if (player.isAlive) "Игрок победил!" else "Монстр победил!")
}