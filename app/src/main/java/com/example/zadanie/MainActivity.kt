package com.example.zadanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.textView
import kotlinx.android.synthetic.main.activity_main.textView2
import layout.Round
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var currentRound = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        fillRounds()
        UpdateUI()
    }
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private val rounds = mutableListOf<Round>()
    private  fun fillRounds() {
        rounds.run {
            add(Round("Что такое Луна?", "Звезда","Планета", "Спутник", "Круг сыра", 3, 0))
            add(Round("В каком году запущен первый спутник?", "1957", "1967", "1965", "1969", 1, 100))
            add(Round("Сколько спутников у Марса?", "0", "1", "2", "3", 3, 1_000))
            add(Round("Как называется спутник Плутона?", "Нет спутников", "Харон", "Энцелад", "Ио", 2, 10_000))
            add(Round("Какой крупнейший спутник у Юпитера?", "Европа", "Каллисто","Титан", "Ганимед", 4, 100_000))
        }
    }
    private fun UpdateUI()
    {
        textView.text = rounds[currentRound].question
        textView2.text = rounds[currentRound].value.toString()
        val button: Button = findViewById(R.id.button)
        button.text = rounds[currentRound].answer1
      val button2: Button = findViewById(R.id.button2)
        button2.text = rounds[currentRound].answer2
      val button3: Button = findViewById(R.id.button3)
        button3.text = rounds[currentRound].answer3
      val button4: Button = findViewById(R.id.button4)
        button4.text = rounds[currentRound].answer4

    }
 private fun check(givenID: Int) = (givenID == rounds[currentRound].rightId)
    private fun goNext(): Boolean
    {
        if (currentRound >= rounds.size - 1) return false
        currentRound++
        UpdateUI()
        return true
    }
    fun processRound(givenID: Int ){
        if(check(givenID)) {
            if (!goNext()) {
                Toast.makeText(this, getString(R.string.YW), Toast.LENGTH_SHORT).show()
                finish()
            }
        }  else
            {  Toast.makeText(this, getString(R.string.YL), Toast.LENGTH_SHORT).show()
            finish()
        }

    }
    fun buttonClick(view: View){
        try{
            val id = view.tag.toString().toInt()
            processRound(id)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun buttonClick2(view: View) {try{
        val id = view.tag.toString().toInt()
        processRound(id)
    } catch (e: Exception) {
        e.printStackTrace()
    }}
    fun buttonClick3(view: View) {try{
        val id = view.tag.toString().toInt()
        processRound(id)
    } catch (e: Exception) {
        e.printStackTrace()
    }}
    fun button4Click4(view: View) {try{
        val id = view.tag.toString().toInt()
        processRound(id)
    } catch (e: Exception) {
        e.printStackTrace()
    }}

}
