package com.selim.worldcupapp.data.domain

data class Match(
    val year:Int ,
    val city:String,
    val stadium:String,
    val homeTeam:String,
    val awayTeam:String,
    val homeTeamGoals:Int,
    val awayTeamGoals:Int
)
