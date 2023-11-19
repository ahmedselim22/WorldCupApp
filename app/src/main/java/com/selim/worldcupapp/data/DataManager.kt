package com.selim.worldcupapp.data

import com.selim.worldcupapp.data.domain.Match

object DataManager {
    private val matchesList = mutableListOf<Match>()
    var currentMatchIndex =0

    val matches :List<Match>
        get() = matchesList.toList()
    fun addMatch(match: Match){
        matchesList.add(match)
    }
    fun addMatchAt(index: Int,match: Match){
        matchesList.add(index,match)
    }

    fun removeMatchAt(index:Int){
        matchesList.removeAt(index)
    }
//    fun getCurrentMatch():Match{
//        return matchesList[currentMatchIndex]
//    }
//    fun getPreviousMatch():Match{
//        currentMatchIndex--
//        if (currentMatchIndex==-1){
//            currentMatchIndex= matchesList.size-1
//        }
//        return matchesList[currentMatchIndex]
//    }
//    fun getNextMatch():Match{
//        currentMatchIndex++
//        if (currentMatchIndex== matchesList.size){
//            currentMatchIndex=0
//        }
//        return matchesList[currentMatchIndex]
//    }
}