package com.ankhafrika.taxcalculator.data.model

data class UserDetails(val ageGroup: AgeGroup, val monthlySalary: Double)

enum class AgeGroup {
    UNDER_65,
    BETWEEN_65_AND_74,
    OVER_75
}
