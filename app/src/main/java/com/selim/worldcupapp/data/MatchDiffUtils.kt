package com.selim.worldcupapp.data

import androidx.recyclerview.widget.DiffUtil
import com.selim.worldcupapp.data.domain.Match

class MatchDiffUtils(private val oldList:List<Match>,private val newList: List<Match>) :DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
                oldList[oldItemPosition].homeTeam ==newList[newItemPosition].homeTeam
                        && oldList[oldItemPosition].awayTeam==newList[newItemPosition].awayTeam
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}