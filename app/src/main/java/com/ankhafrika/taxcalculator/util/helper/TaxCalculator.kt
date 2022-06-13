package com.ankhafrika.taxcalculator.util.helper

import com.ankhafrika.taxcalculator.data.model.AgeGroup
import com.ankhafrika.taxcalculator.data.model.UserDetails

class TaxCalculator(private val userData: UserDetails) {

    fun calculate(): Double {
        return when (userData.ageGroup) {
            AgeGroup.UNDER_65 -> {
                if (getAnnual(userData.monthlySalary) > thresHold(AgeGroup.UNDER_65))
                    getFinalTax(getAnnual(userData.monthlySalary))
                else
                    0.00
            }
            AgeGroup.BETWEEN_65_AND_74 -> {
                if (getAnnual(userData.monthlySalary) > thresHold(AgeGroup.BETWEEN_65_AND_74))
                    getFinalTax(getAnnual(userData.monthlySalary))
                else
                    0.00
            }
            AgeGroup.OVER_75 -> {
                if (getAnnual(userData.monthlySalary) > thresHold(AgeGroup.OVER_75))
                    getFinalTax(getAnnual(userData.monthlySalary))
                else
                    0.00
            }
        }
    }

    private fun getAnnual(monthly: Double) = monthly * 12

    private fun thresHold(ageGroup: AgeGroup): Double {
        return when (ageGroup) {
            AgeGroup.UNDER_65 -> 91250.00
            AgeGroup.BETWEEN_65_AND_74 -> 141250.00
            AgeGroup.OVER_75 -> 157900.00
        }
    }

    private fun getRebateAmount(ageGroup: AgeGroup): Double = when (ageGroup) {
        AgeGroup.UNDER_65 -> 16425.00
        //primary + secondary
        AgeGroup.BETWEEN_65_AND_74 -> 9000.00 + 16425.00
        //primary + secondary + tertiary
        AgeGroup.OVER_75 -> 2997.00 + 9000.00 + 16425.00
    }

    private fun getFinalTax(annual: Double): Double {
        return when {
            (annual in 1.00..226000.00) -> {
                //step 1
                val wholeTax = (0.18 * annual)
                //step 2
                val taxMinusPrimaryRebate = wholeTax - getRebateAmount(userData.ageGroup)
                //step 3
                val finalTax = taxMinusPrimaryRebate / 12
                //return
                finalTax
            }
            (annual in 226001.00..353100.00) -> {
                //step 1
                val wholeTax = (0.26 * (annual - 226000)) + 40680
                //step 2
                val taxMinusPrimaryRebate = wholeTax - getRebateAmount(userData.ageGroup)
                //step 3
                val finalTax = taxMinusPrimaryRebate / 12
                //return
                finalTax
            }
            (annual in 353101.00..488700.00) -> {
                //step 1
                val wholeTax = (0.31 * (annual - 353100)) + 73726
                //step 2
                val taxMinusPrimaryRebate = wholeTax - getRebateAmount(userData.ageGroup)
                //step 3
                val finalTax = taxMinusPrimaryRebate / 12
                //return
                finalTax
            }
            (annual in 488701.00..641400.00) -> {
                //step 1
                val wholeTax = (0.36 * (annual - 488700)) + 115762.00
                //step 2
                val taxMinusPrimaryRebate = wholeTax - getRebateAmount(userData.ageGroup)
                //step 3
                val finalTax = taxMinusPrimaryRebate / 12
                //return
                finalTax
            }
            (annual in 641401.00..817600.00) -> {
                //step 1
                val wholeTax = (0.39 * (annual - 641400)) + 170734.00
                //step 2
                val taxMinusPrimaryRebate = wholeTax - getRebateAmount(userData.ageGroup)
                //step 3
                val finalTax = taxMinusPrimaryRebate / 12
                //return
                finalTax
            }
            (annual in 817601.00..1731600.00) -> {
                //step 1
                val wholeTax = (0.41 * (annual - 817600.00)) + 239452.00
                //step 2
                val taxMinusRebate = wholeTax - getRebateAmount(userData.ageGroup)
                //step 3
                val finalTax = taxMinusRebate / 12
                //return
                finalTax
            }
            (annual > 1731601) -> {
                //step 1
                val wholeTax = (0.45 * (annual - 1731600) + 614192)
                //step 2
                val taxMinusRebate = wholeTax - getRebateAmount(userData.ageGroup)
                //step 3
                val finalTax = taxMinusRebate / 12
                //return
                finalTax
            }
            else -> {
                0.00
            }
        }
    }
}