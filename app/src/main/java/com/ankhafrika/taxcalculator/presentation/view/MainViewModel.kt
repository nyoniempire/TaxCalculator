package com.ankhafrika.taxcalculator.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankhafrika.taxcalculator.data.model.UserDetails
import com.ankhafrika.taxcalculator.util.helper.TaxCalculator

class MainViewModel : ViewModel() {

    private val _taxDue = MutableLiveData(Pair(0.00, 0.00)) //Pair<Salary left, Tax Due>

    fun getTaxDue(): LiveData<Pair<Double, Double>> {
        return _taxDue
    }

    @Synchronized
    fun calculateTaxDue(user: UserDetails) {
        val taxDue = Math.round(TaxCalculator(user).calculate() * 100) / 100.toDouble()
        val salaryDue = Math.round(user.monthlySalary * 100) / 100.toDouble() - taxDue
        _taxDue.postValue(
            Pair(
                salaryDue,
                taxDue
            )
        )
    }

}