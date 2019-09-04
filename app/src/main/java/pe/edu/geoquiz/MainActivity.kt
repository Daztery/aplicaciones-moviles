package pe.edu.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val questions = ArrayList<Question>()

    var position = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()

        btnTrue.setOnClickListener {
            validateOption(true)
        }

        btnFalse.setOnClickListener {
            validateOption(false)
        }

        btn_next.setOnClickListener {
            position +=1
            showQuestion()
        }

        btn_back.setOnClickListener {
            position -=1
            showQuestion()
        }


    }

    private fun showQuestion(){
        tvQuestion.text=questions[position].sentence
    }


    private fun loadQuestions() {

        val question01 = Question("Es lima capital de Peru?",true)
        questions.add(question01)

        val question02 = Question("Es lima capital de Chile?",false)
        questions.add(question02)

    }

    private fun validateOption(option: Boolean) {
        if(option==questions[position].response){
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"Incorrect",Toast.LENGTH_SHORT).show()
        }
    }

}
