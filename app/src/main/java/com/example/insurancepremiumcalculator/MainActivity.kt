package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    lateinit var myData: PremiumModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener(){

            pricetxt.text = "RM %.2f".format(calPremium() )

            myData.premiumAmount = calPremium()
            display()
        }
        buttonReset.setOnClickListener(){
            reset()
        }
        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)
        display()

    }

    fun calPremium():Double{

        return when(spinnerAge.selectedItemPosition){
            0 -> 60.00
            1 -> 70.00 +
                    (if(radioButtonMale.isChecked) 50.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 100.00 else 0.0)
            2 -> 90.00 +
                    (if(radioButtonMale.isChecked) 100.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 150.00 else 0.0)
            3 -> 120.00 +
                    (if(radioButtonMale.isChecked) 150.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 200.00 else 0.0)
            4 -> 150.00 +
                    (if(radioButtonMale.isChecked) 200.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 250.00 else 0.0)
            else -> 150.00 +
                    (if(radioButtonMale.isChecked) 200.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 300.00 else 0.0)
        }
//        if(spinnerAge.selectedItemPosition == 0){
//            price = 60.00
//        }
//        else if(spinnerAge.selectedItemPosition == 1){
//            price = 70.00
//            if(radioButtonMale.isChecked){
//                price += 50.00
//            }
//            if(checkBoxSmoker.isChecked){
//                price += 100.00
//            }
//        }
//        else if(spinnerAge.selectedItemPosition == 2){
//            price = 90.00
//            if(radioButtonMale.isChecked){
//                price += 100.00
//            }
//            if(checkBoxSmoker.isChecked){
//                price += 150.00
//            }
//        }
//        else if(spinnerAge.selectedItemPosition == 3){
//            price = 120.00
//            if(radioButtonMale.isChecked){
//                price += 100.00
//            }
//            if(checkBoxSmoker.isChecked){
//                price += 150.00
//            }
//        }
//        else{
//            price = 150.00
//            if(radioButtonMale.isChecked){
//                price += 200.00
//            }
//            if(checkBoxSmoker.isChecked && spinnerAge.selectedItemPosition == 4){
//                price += 250.00
//            }
//            if(checkBoxSmoker.isChecked && spinnerAge.selectedItemPosition == 5){
//                price += 300.00
//            }
//        }
    }

    fun display(){
        if(myData.premiumAmount != 0.0)
            pricetxt.text = "RM %s".format(myData.premiumAmount.toString())//
    }

    fun reset(){
        spinnerAge.setSelection(0)
        radioGroupGender.clearCheck()
        checkBoxSmoker.setChecked(false)
        pricetxt.text = ""
        myData.premiumAmount = 0.0
    }
}
