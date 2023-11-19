package com.selim.worldcupapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.snackbar.Snackbar
import com.selim.worldcupapp.R
import com.selim.worldcupapp.data.DataManager
import com.selim.worldcupapp.data.ItemClickListener
import com.selim.worldcupapp.data.MatchDiffUtils
import com.selim.worldcupapp.data.domain.Match
import com.selim.worldcupapp.databinding.ListItemLayoutBinding
import com.selim.worldcupapp.databinding.SecondRvLayoutBinding

class MatchAdapter(private val context :Context,private var list: List<Match>,private val listener:ItemClickListener) : RecyclerView.Adapter<MatchAdapter.BaseViewHolder>() {

    abstract class BaseViewHolder(itemView: View) :ViewHolder(itemView)

    class MatchViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val binding =ListItemLayoutBinding.bind(itemView)
    }
    class HeaderViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val binding =SecondRvLayoutBinding.bind(itemView)
    }

    override fun getItemViewType(position: Int): Int {
        if (position %2 ==0){
            return TYPE_HEADER
        }
        else{
            return TYPE_MATCH
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when(viewType){
            TYPE_HEADER -> {
                val v :View =LayoutInflater.from(parent.context).inflate(R.layout.second_rv_layout,parent,false)
                val mvh = HeaderViewHolder(v)
                return mvh
            }
            TYPE_MATCH ->{
                val v :View =LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout,parent,false)
                val mvh = MatchViewHolder(v)
                return mvh
            }
        }
        return super.createViewHolder(parent,viewType)
    }

    override fun getItemCount(): Int {
        return list.size
    }

     fun setData(newList:List<Match>){
         val diffResult = DiffUtil.calculateDiff(MatchDiffUtils(list,newList))
         list=newList
         diffResult.dispatchUpdatesTo(this)
//        this.list=list
//        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val match = list[position]
        when(holder){
            is MatchViewHolder ->{
                holder.binding.apply {
                    tvYear.text = match.year.toString()
                    tvStadium.text = match.stadium
                    tvHomeTeam.text = match.homeTeam
                    tvAwayTeam.text = match.awayTeam
                    tvHomeTeamGoals.text = match.homeTeamGoals.toString()
                    tvAwayTeamGoals.text = match.awayTeamGoals.toString()
                    if (match.homeTeamGoals > match.awayTeamGoals ){
                        tvHomeTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.winner_color))
                        tvAwayTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.loser_color))
                    }
                    else if (match.awayTeamGoals > match.homeTeamGoals){
                        tvAwayTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.winner_color))
                        tvHomeTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.loser_color))
                    }
                    else{
                        tvAwayTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.same_result_color))
                        tvHomeTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.same_result_color))
                    }
                    cardItem.setOnClickListener {
                        listener.onClickItem(match)
                    }
                    ivDelete.setOnClickListener{
                        listener.deleteItem(position)
                    }
                }
            }
            is HeaderViewHolder ->{
                holder.binding.apply {

                }
            }
        }

    }
    companion object{
        const val TYPE_HEADER =11
        const val TYPE_MATCH =22
    }
}