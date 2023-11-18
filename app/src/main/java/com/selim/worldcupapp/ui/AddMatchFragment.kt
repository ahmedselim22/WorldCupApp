//package com.selim.worldcupapp.ui
//
//import android.content.Context
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import androidx.fragment.app.Fragment
//import com.selim.worldcupapp.R
//import com.selim.worldcupapp.data.domain.Match
//
//class AddMatchFragment{
//    lateinit var listener:AddItemFragment
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val v = inflater.inflate(R.layout.add_match_layout,container,false)
//        val et_year = v.findViewById<EditText>(R.id.addMatch_et_year)
//        val et_city = v.findViewById<EditText>(R.id.addMatch_et_city)
//        val et_stadium = v.findViewById<EditText>(R.id.addMatch_et_stadium)
//        val et_dateTime = v.findViewById<EditText>(R.id.addMatch_et_dateTime)
//        val et_homeTeam = v.findViewById<EditText>(R.id.addMatch_et_homeTeam)
//        val et_awayTeam = v.findViewById<EditText>(R.id.addMatch_et_awayTeam)
//        val et_hoemGoals = v.findViewById<EditText>(R.id.addMatch_et_homeTeamGoals)
//        val et_awayGoals = v.findViewById<EditText>(R.id.addMatch_et_awayTeamGoals)
//        val et_referee = v.findViewById<EditText>(R.id.addMatch_et_referee)
//        val et_assistant1 = v.findViewById<EditText>(R.id.addMatch_et_assistant1)
//        val et_assistant2 = v.findViewById<EditText>(R.id.addMatch_et_assistant2)
//        val et_attendance = v.findViewById<EditText>(R.id.addMatch_et_attendance)
//        val btn_add = v.findViewById<Button>(R.id.addMatch_btn_add)
//
//        btn_add.setOnClickListener {
//            val match=Match(
//                year = et_year.text.toString().toInt(),
//                city = et_city.text.toString(),
//                stadium = et_stadium.text.toString(),
//                homeTeam = et_homeTeam.text.toString(),
//                awayTeam = et_awayTeam.text.toString(),
//                homeTeamGoals = et_hoemGoals.text.toString().toInt(),
//                awayTeamGoals = et_awayGoals.text.toString().toInt(),
//                dateTime = et_dateTime.text.toString(),
//                referee = et_referee.text.toString(),
//                attendance = et_attendance.text.toString(),
//                assistant1 = et_assistant1.text.toString(),
//                assistant2 = et_assistant2.text.toString()
//            )
//            listener.onAddItem(match)
//        }
//
//        return v
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        listener=context as AddItemFragment
//    }
//
//}