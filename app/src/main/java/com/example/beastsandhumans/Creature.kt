package com.example.beastsandhumans

import kotlin.random.Random

open class Creature(
    val attack: Int,
    val defense: Int,
    maxHealth: Int,
    protected val damageRange: IntRange
) {
    init {
        require(attack in 1..30) { "Атака должна быть между 1 и 30" }
        require(defense in 1..30) { "Защита должна быть между 1 и 30" }
        require(maxHealth > 0) { "Максимальное здоровье должно быть положительным" }
        require(damageRange.first > 0 && damageRange.last >= damageRange.first) { "Урон должен быть положительным диапазоном" }
    }

    var health: Int = maxHealth
        protected set
    val maxHealth: Int = maxHealth
    val isAlive: Boolean
        get() = health > 0

    fun attack(target: Creature) {
        require(isAlive) { "Атакующее существо мертво" }
        require(target.isAlive) { "Цель мертва" }

        val attackModifier = (attack - target.defense + 1).coerceAtLeast(1)
        val diceResults = List(attackModifier) { Random.nextInt(1, 7) }

        if (diceResults.any { it in 5..6 }) {
            val damage = damageRange.random()
            target.health = (target.health - damage).coerceAtLeast(0)
            println("Удар успешен! Нанесено урона: $damage. Здоровье цели: ${target.health}")
        } else {
            println("Удар неудачен! Здоровье цели: ${target.health}")
        }
    }
}