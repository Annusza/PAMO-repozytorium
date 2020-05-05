package com.annusza.bmicalc.kotlin

class QuestionKot internal constructor(var question: String, answers: Array<String?>, okAnswer: String){


    var answers = arrayOfNulls<String>(4)
    var okAnswer: String

   init{
        this.answers = answers
        this.okAnswer = okAnswer
    }
}
