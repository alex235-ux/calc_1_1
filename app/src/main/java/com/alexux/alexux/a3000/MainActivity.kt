 package com.alexux.alexux.a3000

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

//инициализация переменных под звуки
    private var soundPool: SoundPool? = null
    private var soundId1: Int = 0
    private var soundId2: Int = 0
    private var soundId3: Int = 0
    private var soundId4: Int = 0
    private var soundId5: Int = 0
    private var soundId6: Int = 0
    private var soundId7: Int = 0
    private var soundId8: Int = 0
       private var soundId9: Int = 0
    private var soundId10: Int = 0
    private var soundId11: Int = 0
    private var soundId12: Int = 0
    private var soundId13: Int = 0
    private var soundId14: Int = 0
    private var soundId15: Int = 0
    private var soundId16: Int = 0
    private var soundId17: Int = 0
    private var soundId18: Int = 0
    private var soundId19: Int = 0
    private var soundId20: Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//ЧИСЛА
        btn_one.setOnClickListener { pokaz("1", true);playSound(1) }
        btn_two.setOnClickListener { pokaz("2", true);playSound(2)  }
        btn_three.setOnClickListener { pokaz("3", true) ;playSound(3) }
        btn_four.setOnClickListener { pokaz("4", true) ;playSound(4) }
        btn_five.setOnClickListener { pokaz("5", true) ;playSound(5) }
        btn_six.setOnClickListener { pokaz("6", true) ;playSound(6) }
        btn_seven.setOnClickListener { pokaz("7", true) ;playSound(7) }
        btn_eight.setOnClickListener { pokaz("8", true) ;playSound(8) }
        btn_nine.setOnClickListener { pokaz("9", true) ;playSound(9) }
        btn_zero.setOnClickListener { pokaz("0", true) ;playSound(10) }
        btn_comma.setOnClickListener { pokaz(",", true) ;playSound(11) }


//ОПЕРАТОРЫ
        btn_plus.setOnClickListener { pokaz("+", false) ;playSound(17) }
        btn_minus.setOnClickListener { pokaz("-", false) ;playSound(18) }
        btn_open.setOnClickListener { pokaz("(", false) ;playSound(14) }
        btn_close.setOnClickListener { pokaz(")", false) ;playSound(15) }
        btn_multi.setOnClickListener { pokaz("*", false) ;playSound(12) }
        btn_div.setOnClickListener { pokaz("/", false) ;playSound(13) }

        //СТИРАНИЕ ОДНОГО СИМВОЛА С КОНЦА
        btn_back.setOnClickListener {
            val stroka = view_expression.text.toString()
            playSound(20)
            if (stroka.isNotEmpty()) {
                view_expression.text = stroka.substring(0, stroka.length - 1)
            }
            view_result.text = ""
        }

        //ОЧИСТКА ПОЛЕЙ expression и result-AC
        btn_ac.setOnClickListener {
            playSound(19)
            view_result.text = ""
            view_expression.text = ""
        }
        btn_equally.setOnClickListener {
            try {
                playSound(16)
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







//загрузка
        soundPool = SoundPool(25, AudioManager.STREAM_MUSIC, 0)
        soundId1 = soundPool!!.load(baseContext, R.raw.one, 1)
        soundId2 = soundPool!!.load(baseContext, R.raw.two, 1)
        soundId3 = soundPool!!.load(baseContext, R.raw.three, 1)
        soundId4 = soundPool!!.load(baseContext, R.raw.four, 1)
        soundId5 = soundPool!!.load(baseContext, R.raw.five, 1)
        soundId6 = soundPool!!.load(baseContext, R.raw.six, 1)
        soundId7= soundPool!!.load(baseContext, R.raw.seven, 1)
        soundId8 = soundPool!!.load(baseContext, R.raw.eight, 1)
        soundId9 = soundPool!!.load(baseContext, R.raw.nine, 1)
        soundId10 = soundPool!!.load(baseContext, R.raw.zero, 1)
        soundId11 = soundPool!!.load(baseContext, R.raw.comma, 1)
        soundId12 = soundPool!!.load(baseContext, R.raw.multi, 1)
        soundId13 = soundPool!!.load(baseContext, R.raw.div, 1)
        soundId14 = soundPool!!.load(baseContext, R.raw.open, 1)
        soundId15 = soundPool!!.load(baseContext, R.raw.close, 1)
        soundId16 = soundPool!!.load(baseContext, R.raw.equally, 1)
        soundId17 = soundPool!!.load(baseContext, R.raw.plus, 1)
        soundId18 = soundPool!!.load(baseContext, R.raw.minus, 1)
        soundId19 = soundPool!!.load(baseContext, R.raw.ac, 1)
        soundId20 = soundPool!!.load(baseContext, R.raw.back, 1)


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


    fun playSound(sound: Int) {

        var soundId = 0
        when (sound) {

            1 -> soundId = soundId1
            2 -> soundId = soundId2
            3 -> soundId = soundId3
            4 -> soundId = soundId4
            5 -> soundId = soundId5
            6 -> soundId = soundId6
            7-> soundId = soundId7
            8 -> soundId = soundId8
            9 -> soundId = soundId9
            10 -> soundId = soundId10
            11 -> soundId = soundId11
            12 -> soundId = soundId12
            13 -> soundId = soundId13
            14 -> soundId = soundId14
            15 -> soundId = soundId15
            16 -> soundId = soundId16
            17 -> soundId = soundId17
            18 -> soundId = soundId18
            19 -> soundId = soundId19
            20 -> soundId = soundId20
        }
        soundPool?.play(soundId, 1F, 1F, 0, 0, 1F)
        Toast.makeText(this, soundId!!.toString(), Toast.LENGTH_SHORT).show()


    }








}