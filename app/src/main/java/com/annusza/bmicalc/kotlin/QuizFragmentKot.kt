package com.annusza.bmicalc.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.annusza.bmicalc.R
import com.annusza.bmicalc.kotlin.QuestionKot
import kotlinx.android.synthetic.main.fragment_quiz.*


class QuizFragmentKot : Fragment() {

    private var questions = arrayOfNulls<QuestionKot>(9)
    private var a: Button? = null
    private var b: Button? = null
    private var c: Button? = null
    private var d: Button? = null
    private var nrOfQuestion = 0
    private var result = 0
    private var correctAnswer = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        a = view.findViewById(R.id.a)
        a?.run {setOnClickListener(listenersButton)}
        b = view.findViewById<Button>(R.id.b)
        b?.run {setOnClickListener(listenersButton)}
        c = view.findViewById<Button>(R.id.c)
        c?.run {setOnClickListener(listenersButton)}
        d = view.findViewById<Button>(R.id.d)
        d?.run {setOnClickListener(listenersButton)}
        startQuiz()
        readQuestion()
    }

    private fun startQuiz() {
        questions = arrayOf(
                QuestionKot(
                        resources.getString(R.string.q1),
                        arrayOf(
                        resources.getString(R.string.q1A),
                        resources.getString(R.string.q1B),
                        resources.getString(R.string.q1C),
                        resources.getString(R.string.q1D)
                ),
                        resources.getString(R.string.q1C)),
                QuestionKot(
                        resources.getString(R.string.q2), arrayOf(
                        resources.getString(R.string.q2A),
                        resources.getString(R.string.q2B),
                        resources.getString(R.string.q2C),
                        resources.getString(R.string.q2D)
                ),
                        resources.getString(R.string.q2D)),
                QuestionKot(
                        resources.getString(R.string.q3), arrayOf(
                        resources.getString(R.string.q3A),
                        resources.getString(R.string.q3B),
                        resources.getString(R.string.q3C),
                        resources.getString(R.string.q3D)
                ),
                        resources.getString(R.string.q3A)),
                QuestionKot(
                        resources.getString(R.string.q4), arrayOf(
                        resources.getString(R.string.q4A),
                        resources.getString(R.string.q4B),
                        resources.getString(R.string.q4C),
                        resources.getString(R.string.q4D)
                ),
                        resources.getString(R.string.q4C)),
                QuestionKot(
                        resources.getString(R.string.q5), arrayOf(
                        resources.getString(R.string.q5A),
                        resources.getString(R.string.q5B),
                        resources.getString(R.string.q5C),
                        resources.getString(R.string.q5D)
                ),
                        resources.getString(R.string.q5B)),
                QuestionKot(
                        resources.getString(R.string.q6), arrayOf(
                        resources.getString(R.string.q6A),
                        resources.getString(R.string.q6B),
                        resources.getString(R.string.q6C),
                        resources.getString(R.string.q6D)
                ),
                        resources.getString(R.string.q6C)),
                QuestionKot(
                        resources.getString(R.string.q7), arrayOf(
                        resources.getString(R.string.q7A),
                        resources.getString(R.string.q7B),
                        resources.getString(R.string.q7C),
                        resources.getString(R.string.q7D)
                ),
                        resources.getString(R.string.q7A)),
                QuestionKot(
                        resources.getString(R.string.q8), arrayOf(
                        resources.getString(R.string.q8A),
                        resources.getString(R.string.q8B),
                        resources.getString(R.string.q8C),
                        resources.getString(R.string.q8D)
                ),
                        resources.getString(R.string.q8B)),
                QuestionKot(
                        resources.getString(R.string.q9), arrayOf(
                        resources.getString(R.string.q9A),
                        resources.getString(R.string.q9B),
                        resources.getString(R.string.q9C),
                        resources.getString(R.string.q9D)
                ),
                        resources.getString(R.string.q9D))
        )
    }

    private val listenersButton = View.OnClickListener { view ->
        val button = view as Button
        val answer = button.text.toString()
        if (nrOfQuestion <= 9) {
            if (answer == correctAnswer) {
                result += 1
                points.setText(Integer.toString(result))
            }
            readQuestion()
        } else {
            if (button.id == R.id.a) {
                result = 0
                nrOfQuestion = 0
                b!!.visibility=View.VISIBLE
                c!!.visibility=View.VISIBLE
                d!!.visibility=View.VISIBLE
                counterTextField!!.visibility=View.VISIBLE
                pointsTextField!!.visibility=View.VISIBLE
                counter!!.visibility = View.VISIBLE
                points!!.visibility=View.VISIBLE
                readQuestion()
            }
        }
    }

    private fun readQuestion() {
        if (nrOfQuestion < 9) {
            val shownQuestion = questions[nrOfQuestion]
            content!!.text=shownQuestion!!.question
            a!!.text = shownQuestion!!.answers[0]
            b!!.text=shownQuestion!!.answers[1]
            c!!.text=shownQuestion!!.answers[2]
            d!!.text=shownQuestion!!.answers[3]
            correctAnswer = shownQuestion!!.okAnswer
            nrOfQuestion = nrOfQuestion + 1
            counter!!.text = Integer.toString(nrOfQuestion) + " z 9"
        } else {
            nrOfQuestion = 10
            content.setText("Your score: " + Integer.toString(result))
            a!!.setText(R.string.end)
            b!!.visibility=View.INVISIBLE
            c!!.visibility=View.INVISIBLE
            d!!.visibility=View.INVISIBLE

            points!!.visibility=View.INVISIBLE
            points!!.setText(R.string.zero)
            pointsTextField!!.visibility=View.INVISIBLE
            counter!!.visibility = View.INVISIBLE
            counterTextField!!.visibility=View.INVISIBLE
        }
    }

}

