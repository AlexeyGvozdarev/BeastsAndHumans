package com.example.beastsandhumans

class Player(
    attack: Int,
    defense: Int,
    maxHealth: Int,
    damageRange: IntRange
) : Creature(attack, defense, maxHealth, damageRange) {
    private var healCount: Int = 4

    fun heal() {
        require(isAlive) { "Игрок мертв" }
        require(healCount > 0) { "Исцеления закончились" }

        val healAmount = (maxHealth * 0.3).toInt()
        health = (health + healAmount).coerceAtMost(maxHealth)
        healCount--
        println("Исцеление на $healAmount. Текущее здоровье: $health. Осталось исцелений: $healCount")
    }
}