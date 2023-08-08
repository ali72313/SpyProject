package com.example.spyproject.data


data class Player(val name: String, val winCount: Int, val gameCount: Int)

val players: List<Player> = listOf(
    Player("ahmad", 2, 4),
    Player("ahmad", 2, 4),
    Player("ahmad", 2, 4),
    Player("ahmad", 2, 4)
)