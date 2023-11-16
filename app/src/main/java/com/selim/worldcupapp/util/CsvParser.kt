package com.selim.worldcupapp.util

import com.selim.worldcupapp.data.domain.Match

class CsvParser {
    fun parse(line:String): Match {
        val tokens = line.split(",")
        return Match(
            year = tokens[Constants.ColumnIndex.YEAR].toInt(),
            city = tokens[Constants.ColumnIndex.CITY],
            stadium = tokens[Constants.ColumnIndex.STADIUM],
            homeTeam = tokens[Constants.ColumnIndex.HOME_TEAM],
            awayTeam = tokens[Constants.ColumnIndex.AWAY_TEAM],
            homeTeamGoals = tokens[Constants.ColumnIndex.HOME_TEAM_GOALS].toInt(),
            awayTeamGoals = tokens[Constants.ColumnIndex.AWAY_TEAM_GOALS].toInt()
        )
    }
}