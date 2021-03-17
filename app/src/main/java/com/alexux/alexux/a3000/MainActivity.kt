 package com.alexux.alexux.a3000

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//ЧИСЛА
        btn_one.setOnClickListener { pokaz("1", true) }
        btn_two.setOnClickListener { pokaz("2", true) }
        btn_three.setOnClickListener { pokaz("3", true) }
        btn_four.setOnClickListener { pokaz("4", true) }
        btn_five.setOnClickListener { pokaz("5", true) }
        btn_six.setOnClickListener { pokaz("6", true) }
        btn_seven.setOnClickListener { pokaz("7", true) }
        btn_eight.setOnClickListener { pokaz("8", true) }
        btn_nine.setOnClickListener { pokaz("9", true) }
        btn_zero.setOnClickListener { pokaz("0", true) }
        btn_comma.setOnClickListener { pokaz(",", true) }


//ОПЕРАТОРЫ
        btn_plus.setOnClickListener { pokaz("+", false) }
        btn_open.setOnClickListener { pokaz("(", false) }
        btn_close.setOnClickListener { pokaz(")", false) }
        btn_multi.setOnClickListener { pokaz("*", false) }
        btn_div.setOnClickListener { pokaz("/", false) }

        //СТИРАНИЕ ОДНОГО СИМВОЛА С КОНЦА
        btn_back.setOnClickListener {
            val stroka = view_expression.text.toString()

            if (stroka.isNotEmpty()) {
                view_expression.text = stroka.substring(0, stroka.length - 1)
            }
            view_result.text = ""
        }

        //ОЧИСТКА ПОЛЕЙ expression и result-AC
        btn_ac.setOnClickListener {
            view_result.text = ""
            view_expression.text = ""
        }
        btn_equally.setOnClickListener {
            try {
                 val expression =  ExpressionBuilder(view_expression.text.toString()).build()
                val result = expression.evaluate()
                val Result = result.toLong()
                val longResult = result.toDouble()
                if (result == longResult.toDouble())
                    view_result.text = longResult.toString()
                else
                    view_result.text = result.toString()
            }
            catch (e:Exception)
            {
                Log.d("ошибка","Код"+e.message)
            }
        }


    }
    fun pokaz (stroka:String, ochistka: Boolean) {
        if(view_result.text.isNotEmpty()) {
            view_expression.text = ""
        }
        if(ochistka)
        {
            view_result.text = ""
            view_expression.append(stroka)
        }
        else
        {
            view_expression.append(view_result.text)
            view_expression.append(stroka)
            view_result.text = ""
        }
    }
}