package com.selim.worldcupapp.data.domain

import android.provider.CalendarContract.Attendees

data class Match(
    val year:Int ,
    val city:String,
    val stadium:String,
    val homeTeam:String,
    val awayTeam:String,
    val homeTeamGoals:Int,
    val awayTeamGoals:Int,
    val dateTime:String,
    val attendance:String,
    val referee:String,
    val assistant1:String,
    val assistant2:String
)
