package com.selim.worldcupapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.selim.worldcupapp.R
import com.selim.worldcupapp.data.domain.Match
import com.selim.worldcupapp.databinding.ListItemLayoutBinding

class MatchAdapter(val list: List<Match>) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    class MatchViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding =ListItemLayoutBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val v :View =LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout,parent,false)
        val mvh = MatchViewHolder(v)
        return mvh
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = list[position]
        holder.binding.apply {
            tvCity.text = match.city
            tvYear.text = match.year.toString()
            tvStadium.text = match.stadium
            tvHomeTeam.text = match.homeTeam
            tvAwayTeam.text = match.awayTeam
            tvHomeTeamGoals.text = match.homeTeamGoals.toString()
            tvAwayTeamGoals.text = match.awayTeamGoals.toString()
        }
    }
}