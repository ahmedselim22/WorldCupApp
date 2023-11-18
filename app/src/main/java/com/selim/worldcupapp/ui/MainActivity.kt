package com.selim.worldcupapp.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.selim.worldcupapp.R
import com.selim.worldcupapp.data.DataManager
import com.selim.worldcupapp.adapter.MatchAdapter
import com.selim.worldcupapp.data.ItemClickListener
import com.selim.worldcupapp.data.domain.Match
import com.selim.worldcupapp.databinding.ActivityMainBinding
import com.selim.worldcupapp.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() ,ItemClickListener{
    lateinit var binding:ActivityMainBinding
    val TAG = "MAIN_ACTIVITY"
    var match: Match?=null
    lateinit var adapter:MatchAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parseFile()
        adapter = MatchAdapter(this,DataManager.matches,this)
        binding.mainRv.adapter = adapter

        binding.fabAdd.setOnClickListener {
            showAddMatchDialog()
//            val fragment =AddMatchFragment()
//            val transaction= supportFragmentManager.beginTransaction()
//            val view = findViewById<FrameLayout>(R.id.fragment_container)
//            view.visibility= View.VISIBLE
//            transaction.replace(R.id.fragment_container,fragment)
//            transaction.commit()
        }

//        binding.ivNext.setOnClickListener {
//            bindMatches(DataManager.getNextMatch())
//        }
//        binding.ivPrevious.setOnClickListener {
//            bindMatches(DataManager.getPreviousMatch())
//        }
    }
    fun addMatch(match:Match){
//        val m = Match(
//            2020,"cairo","qatar stadium","argantina","france"
//            ,4,3,"22-8-2020","78322",
//            "asdasd","asdsd","asdsd"
//        )
        DataManager.addMatch(match)
        adapter.setData(DataManager.matches)
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

    override fun onClickItem(match: Match) {
        super.onClickItem(match)
        this.match =match
        showMatchDetailsDialog(match)
    }
    override fun deleteItem(index: Int) {
        DataManager.removeMatchAt(index)
        adapter.setData(DataManager.matches)
    }

    private fun showMatchDetailsDialog(match: Match){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.match_details_layout)
        dialog.findViewById<TextView>(R.id.details_tv_year).text=match.year.toString()
        dialog.findViewById<TextView>(R.id.details_tv_stadium).text = match.stadium
        dialog.findViewById<TextView>(R.id.details_tv_city).text = match.city
        dialog.findViewById<TextView>(R.id.details_tv_assistant1).text = match.assistant1
        dialog.findViewById<TextView>(R.id.details_tv_assistant2).text = match.assistant2
        dialog.findViewById<TextView>(R.id.details_tv_attendence).text = match.attendance
        dialog.findViewById<TextView>(R.id.details_tv_awayTeam).text = match.awayTeam
        dialog.findViewById<TextView>(R.id.details_tv_homeTeam).text = match.homeTeam
        dialog.findViewById<TextView>(R.id.details_tv_awayTeamGoals).text = match.awayTeamGoals.toString()
        dialog.findViewById<TextView>(R.id.details_tv_homeTeamGoals).text = match.homeTeamGoals.toString()
        dialog.findViewById<TextView>(R.id.details_tv_dateTime).text = match.dateTime
        dialog.findViewById<TextView>(R.id.details_tv_referee).text = match.referee
        dialog.findViewById<ImageView>(R.id.details_iv_close).setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun showAddMatchDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.add_match_layout)
        val et_year =  dialog.findViewById<EditText>(R.id.addMatch_et_year)
        val et_city =  dialog.findViewById<EditText>(R.id.addMatch_et_city)
        val et_stadium =  dialog.findViewById<EditText>(R.id.addMatch_et_stadium)
        val et_dateTime =  dialog.findViewById<EditText>(R.id.addMatch_et_dateTime)
        val et_homeTeam =  dialog.findViewById<EditText>(R.id.addMatch_et_homeTeam)
        val et_awayTeam =  dialog.findViewById<EditText>(R.id.addMatch_et_awayTeam)
        val et_hoemGoals =  dialog.findViewById<EditText>(R.id.addMatch_et_homeTeamGoals)
        val et_awayGoals =  dialog.findViewById<EditText>(R.id.addMatch_et_awayTeamGoals)
        val et_referee =  dialog.findViewById<EditText>(R.id.addMatch_et_referee)
        val et_assistant1 =  dialog.findViewById<EditText>(R.id.addMatch_et_assistant1)
        val et_assistant2 =  dialog.findViewById<EditText>(R.id.addMatch_et_assistant2)
        val et_attendance =  dialog.findViewById<EditText>(R.id.addMatch_et_attendance)
        val btn_add =  dialog.findViewById<Button>(R.id.addMatch_btn_add)
        btn_add.setOnClickListener {
            val match=Match(
                year = et_year.text.toString().toInt(),
                city = et_city.text.toString(),
                stadium = et_stadium.text.toString(),
                homeTeam = et_homeTeam.text.toString(),
                awayTeam = et_awayTeam.text.toString(),
                homeTeamGoals = et_hoemGoals.text.toString().toInt(),
                awayTeamGoals = et_awayGoals.text.toString().toInt(),
                dateTime = et_dateTime.text.toString(),
                referee = et_referee.text.toString(),
                attendance = et_attendance.text.toString(),
                assistant1 = et_assistant1.text.toString(),
                assistant2 = et_assistant2.text.toString()
            )
            DataManager.addMatch(match)
            adapter.setData(DataManager.matches)
            Toast.makeText(this,"added",Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
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