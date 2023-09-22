package com.example.calci

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calci.ui.theme.CalciTheme
import java.lang.ArithmeticException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var lastNumeric:Boolean=true
        var lastDot:Boolean=false

        lateinit var btn1:Button
        lateinit var btn2:Button
        lateinit var btn3:Button
        lateinit var btn4:Button
        lateinit var btn5:Button
        lateinit var btn6:Button
        lateinit var btn7:Button
        lateinit var btn8:Button
        lateinit var btn9:Button
        lateinit var btn0:Button
        lateinit var btndiv:Button
        lateinit var btnplus:Button
        lateinit var btnmul:Button
        lateinit var btnmin:Button
        lateinit var btnclr:Button
        lateinit var btnpoint:Button
        lateinit var btnequal:Button
        lateinit var screentext:TextView
        super.onCreate(savedInstanceState)
        setContent {
            fun isOperatorAdded(value:String):Boolean{
                return if(value.startsWith("-"))
                {
                    false
                }else
                {
                    value.contains("/")
                            ||value.contains("*")
                            ||value.contains("+")
                            ||value.contains("-")
                }
            }
            fun removezero(result:String):String
            {
                var value=result
                if(result.contains(".0"))
                    value=result.substring(0,result.length-2)
                return value
            }
            setContentView(R.layout.activity_main)
            screentext=findViewById(R.id.screentext)
            btn1=findViewById(R.id.btn1)
            btn2=findViewById(R.id.btn2)
            btn3=findViewById(R.id.btn3)
            btn4=findViewById(R.id.btn4)
            btn5=findViewById(R.id.btn5)
            btn6=findViewById(R.id.btn6)
            btn7=findViewById(R.id.btn7)
            btn8=findViewById(R.id.btn8)
            btn9=findViewById(R.id.btn9)
            btn0=findViewById(R.id.btn0)
            btnplus=findViewById(R.id.btnplus)
            btnmin=findViewById(R.id.btnmin)
            btnmul=findViewById(R.id.btnmul)
            btndiv=findViewById(R.id.btndiv)
            btnpoint=findViewById(R.id.btnpoint)
            btnclr=findViewById(R.id.btnclr)
            btnequal=findViewById(R.id.btnequal)
            btn1.setOnClickListener {
                screentext.append("1")
                lastNumeric=true
            }
            btn2.setOnClickListener {
                screentext.append("2")
                lastNumeric=true
            }
            btn3.setOnClickListener {
                screentext.append("3")
                lastNumeric=true
            }
            btn4.setOnClickListener {
                screentext.append("4")
                lastNumeric=true
            }
            btn5.setOnClickListener {
                screentext.append("5")
                lastNumeric=true
            }
            btn6.setOnClickListener {
                screentext.append("6")
                lastNumeric=true
            }
            btn7.setOnClickListener {
                screentext.append("7")
                lastNumeric=true
            }
            btn8.setOnClickListener {
                screentext.append("8")
                lastNumeric=true
            }
            btn9.setOnClickListener {
                screentext.append("9")
                lastNumeric=true
            }
            btn0.setOnClickListener {
                screentext.append("0")
                lastNumeric=true
            }
            btnclr.setOnClickListener {
                screentext.text=""
                lastDot=false
                lastNumeric=true
            }
            btnpoint.setOnClickListener {
                if(lastNumeric && !lastDot)
                {
                    screentext.append(".")
                    lastNumeric=false
                    lastDot=true
                }
            }
            btnplus.setOnClickListener {
                screentext?.text?.let{
                    if(lastNumeric && !isOperatorAdded(it.toString()))
                    {
                        screentext.append("+")
                        lastNumeric=false
                        lastDot=false
                    }
                }
            }
            btnmin.setOnClickListener {
                screentext?.text?.let{
                    if(lastNumeric && !isOperatorAdded(it.toString()))
                    {
                        screentext.append("-")
                        lastNumeric=false
                        lastDot=false
                    }
                }
            }
            btnmul.setOnClickListener {
                screentext?.text?.let{
                    if(lastNumeric && !isOperatorAdded(it.toString()))
                    {
                        screentext.append("*")
                        lastNumeric=false
                        lastDot=false
                    }
                }
            }
            btndiv.setOnClickListener {
                screentext?.text?.let{
                    if(lastNumeric && !isOperatorAdded(it.toString()))
                    {
                        screentext.append("/")
                        lastNumeric=false
                        lastDot=false
                    }
                }
            }
            btnequal.setOnClickListener {
                if(lastNumeric)
                {

                    var screenvalue=screentext?.text.toString()
                    var prefix=""

                    try{
                        if(screenvalue.startsWith("-")){
                            prefix="-"
                            screenvalue=screenvalue.substring(1)
                        }
                        if(screenvalue.contains("-")){
                            val splitValue=screenvalue.split("-")
                            var one=splitValue[0]
                            var two=splitValue[1]
                            if(prefix.isNotEmpty())
                            {
                                one=prefix+one
                            }
                            screentext.text=removezero((one.toDouble()-two.toDouble()).toString())
                        }
                        else if(screenvalue.contains("+")){
                            val splitValue=screenvalue.split("+")
                            var one=splitValue[0]
                            var two=splitValue[1]
                            if(prefix.isNotEmpty())
                            {
                                one=prefix+one
                            }
                            screentext.text=removezero((one.toDouble()+two.toDouble()).toString())
                        }
                        else if(screenvalue.contains("*")){
                            val splitValue=screenvalue.split("*")
                            var one=splitValue[0]
                            var two=splitValue[1]
                            if(prefix.isNotEmpty())
                            {
                                one=prefix+one
                            }
                            screentext.text=removezero((one.toDouble()*two.toDouble()).toString())
                        }
                        else if(screenvalue.contains("/")){
                            val splitValue=screenvalue.split("/")
                            var one=splitValue[0]
                            var two=splitValue[1]
                            if(prefix.isNotEmpty())
                            {
                                one=prefix+one
                            }
                            screentext.text=removezero((one.toDouble()/two.toDouble()).toString())
                        }



                    }
                    catch (e:ArithmeticException)
                    {
                        e.printStackTrace()
                    }

                }
            }



            }



        }

    }

