package com.selim.worldcupapp.data

import com.selim.worldcupapp.data.domain.Match

interface ItemClickListener {
    fun onClickItem(match:Match){}
    fun deleteItem(index:Int){}
}