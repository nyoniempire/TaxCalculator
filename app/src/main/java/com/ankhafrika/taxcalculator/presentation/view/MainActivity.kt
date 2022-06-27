package com.ankhafrika.taxcalculator.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ankhafrika.taxcalculator.R
import com.ankhafrika.taxcalculator.data.model.AgeGroup
import com.ankhafrika.taxcalculator.data.model.UserDetails
import com.ankhafrika.taxcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel.getTaxDue().observe(this) { taxDue ->
            taxDue?.let {
                binding.apply {
                    tvTaxDue.text = "Your Tax due is: \n R${taxDue.second}"
                    tvSalaryDue.text = "Your salary is \n R${taxDue.first}"
                }
            }
        }

        setup()
    }

    private fun setup() {
        binding.apply {
            rbUnder65.isSelected = true
            btnCalculate.setOnClickListener {
                if (!tietMonthlyIncome.text.isNullOrBlank()) {
                    val ageGroup = when (rgAgeGroup.checkedRadioButtonId) {
                        rbUnder65.id -> AgeGroup.UNDER_65
                        rbBetween6575.id -> AgeGroup.BETWEEN_65_AND_74
                        rbOver75.id -> AgeGroup.OVER_75
                        else -> AgeGroup.UNDER_65
                    }

                    val user = UserDetails(ageGroup, tietMonthlyIncome.text.toString().toDouble())
                    mainViewModel.calculateTaxDue(user)
                }
            }
        }
    }


    /*@Composable
    fun MainView(){
        Column(){
            TextField("TaxDue is :",{})
            TextField("",{})

            EditText(this@MainActivity)



        }
    }

    @Composable
    @Preview
    fun MainViewPreview(){
        MainView()
    }*/
}

