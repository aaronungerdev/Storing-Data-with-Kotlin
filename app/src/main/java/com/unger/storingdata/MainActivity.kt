package com.unger.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.unger.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPref : SharedPreferences
    var ageFromPref: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // SharedPreferences - XML - Key Value
        sharedPref = getSharedPreferences("com.unger.storingdata",Context.MODE_PRIVATE )

        ageFromPref= sharedPref.getInt("age",0)

        if (ageFromPref==0){
            binding.resultTxt.text="Your age: "
        }
        else{
            binding.resultTxt.text ="Result: ${ageFromPref}"
        }
    }

    fun save(view: View){

        val myAge = binding.ageTxt.text.toString().toIntOrNull()

        if(myAge != null) {

            binding.resultTxt.text= "Result: ${myAge}"
            sharedPref.edit().putInt("age",myAge).apply()
        }
        else{
            binding.resultTxt.text= "Enter your Age!"
        }


    }

    fun delete(view: View){

        ageFromPref = sharedPref.getInt("age",0)

        if (ageFromPref != 0 ){

            sharedPref.edit().remove("age").apply()
            binding.resultTxt.text= " Your Age: "

        }


    }
}