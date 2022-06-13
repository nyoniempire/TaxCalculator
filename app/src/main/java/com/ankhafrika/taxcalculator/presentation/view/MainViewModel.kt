package com.ankhafrika.taxcalculator.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankhafrika.taxcalculator.data.model.UserDetails
import com.ankhafrika.taxcalculator.util.helper.TaxCalculator

class MainViewModel : ViewModel() {

    private val taxDue = MutableLiveData(0.00)

    fun getTaxDue(): LiveData<Double> {
        return taxDue
    }

    fun calculateTaxDue(user: UserDetails) {
        taxDue.postValue(Math.round(TaxCalculator(user).calculate() * 100) / 100.toDouble())
    }

}