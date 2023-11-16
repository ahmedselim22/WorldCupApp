package com.selim.worldcupapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.selim.worldcupapp.data.DataManager
import com.selim.worldcupapp.adapter.MatchAdapter
import com.selim.worldcupapp.databinding.ActivityMainBinding
import com.selim.worldcupapp.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val TAG = "MAIN_ACTIVITY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parseFile()
        val matches = DataManager.matches
        val adapter = MatchAdapter(matches)
        binding.mainRv.adapter = adapter

//        binding.ivNext.setOnClickListener {
//            bindMatches(DataManager.getNextMatch())
//        }
//        binding.ivPrevious.setOnClickListener {
//            bindMatches(DataManager.getPreviousMatch())
//        }
    }
    private fun parseFile(){
        val inputStream = assets.open("worldcup.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser =CsvParser()
        buffer.forEachLine {
            Log.d(TAG, it)
            val currentMatch = parser.parse(it)
            DataManager.addMatch(currentMatch)
            Log.d(TAG, currentMatch.toString())
        }
//        bindMatches(DataManager.getCurrentMatch())
    }
//    fun bindMatches(match: Match){
//        binding.tvYear.text = match.year.toString()
//        binding.tvStadium.text = match.stadium
//        binding.tvCity.text = match.city
//        binding.tvHomeTeamName.text = match.homeTeam
//        binding.tvHomeTeamGoals.text = match.homeTeamGoals.toString()
//        binding.tvAwayTeamName.text = match.awayTeam
//        binding.tvAwayTeamGoals.text = match.awayTeamGoals.toString()
//    }
}