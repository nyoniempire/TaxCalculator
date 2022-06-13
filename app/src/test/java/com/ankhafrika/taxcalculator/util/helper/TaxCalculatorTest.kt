package com.ankhafrika.taxcalculator.util.helper

import com.ankhafrika.taxcalculator.data.model.AgeGroup
import com.ankhafrika.taxcalculator.data.model.UserDetails
import org.junit.Assert.*
import org.junit.Test

class TaxCalculatorTest {

    @Test
    fun `user below 65 earning below threshold should return 0`() {
        val user = UserDetails(AgeGroup.UNDER_65, 6000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(0.00, result, 0.00)
    }

    @Test
    fun `user below 65 earning over threshold should return amount over 0`() {
        val user = UserDetails(AgeGroup.UNDER_65, 12000.00)

        val result = TaxCalculator(user).calculate()

        assertTrue(result > 0)
    }

    @Test
    fun `user between 65 and 74 below threshold should return 0`() {
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74, 6000.00)
        val result = TaxCalculator(user).calculate()
        assertEquals(0.00, result, 0.00)
    }

    @Test
    fun `user between 65 and 74 above threshold should return amount over 0`() {
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74, 15000.00)
        val result = TaxCalculator(user).calculate()

        assertTrue(result > 0.00)
    }

    @Test
    fun `user over 75 earning below threshold should return 0`() {
        val user = UserDetails(AgeGroup.OVER_75, 6000.00)
        val result = TaxCalculator(user).calculate()

        assertEquals(0.00, result, 0.00)
    }

    @Test
    fun `user over 75 earning above threshold should return amount over 0`() {
        val user = UserDetails(AgeGroup.OVER_75, 25000.00)
        val result = TaxCalculator(user).calculate()

        assertTrue(result > 0)
    }

    @Test
    fun `user below 65 earning twelve should return seven nine`() {
        val user = UserDetails(AgeGroup.UNDER_65, 12000.00)
        val result = TaxCalculator(user).calculate()

        assertEquals(791.25, Math.round(result*100)/100.toDouble(), 0.00)
    }

    @Test
    fun `user between 65 - 75 earning twelve should return plus forty`(){
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74,12000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(41.25,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user over 75 earning twelve should return 0`(){
        val user = UserDetails(AgeGroup.OVER_75,12000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(0.00,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user below 65 earning twenty k should return plus two k`() {
        val user = UserDetails(AgeGroup.UNDER_65, 20000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(2324.58, Math.round(result*100)/ 100.toDouble(), 0.00)
    }

    @Test
    fun `user between 65 - 75 earning twenty should return plus one point five k`(){
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74,20000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(1574.58,Math.round(result*100)/100.toDouble(),0.00)

    }

    @Test
    fun `user over 75 earning 20 should return plus one point three k`(){
        val user = UserDetails(AgeGroup.OVER_75,20000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(1324.83,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user below 65 earning forty k should return plus 8 k`(){
        val user = UserDetails(AgeGroup.UNDER_65,40000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(8053.33,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user between 65 - 75 earning forty k should return plus seven k`(){
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74,40000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(7303.33, Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user over 75 earning forty k should return plus seven k`(){
        val user = UserDetails(AgeGroup.OVER_75,40000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(7053.58, Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user below 65 earning fifty should return plus eleven k`(){
        val user = UserDetails(AgeGroup.UNDER_65, 50000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(11617.08,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user between 65 - 75 earning fifty should return plus ten point 8 k`(){
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74,50000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(10867.08,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user over 75 earning fifty should return plus ten point six k`(){
        val user = UserDetails(AgeGroup.OVER_75,50000.00)
        val result = TaxCalculator(user).calculate()

        assertEquals(10617.33, Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user over 65 earning sixty should return plus fifteen k`(){
        val user = UserDetails(AgeGroup.UNDER_65,60000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(15413.58,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user between 65 - 75 earning sixty should return plus fourteen pint six k`(){
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74,60000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(14663.58,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user over 75 earning sixty k should return plus fourteen k`(){
        val user = UserDetails(AgeGroup.OVER_75,60000.00)

        val result = TaxCalculator(user).calculate()

        assertEquals(14413.83,Math.round(result*100)/100.toDouble(),0.00)
    }

    @Test
    fun `user under 65 earning seventy k should return plus nineteen point three k`(){
        val user = UserDetails(AgeGroup.UNDER_65,70000.00)

        val result = Math.round((TaxCalculator(user).calculate())*100)/100.toDouble()

        assertEquals(19350.92,result,0.00)
    }

    @Test
    fun `user between 65 - 75 earning seventy k should return plus eighteen point six k`(){
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74,70000.00)
        val result = Math.round((TaxCalculator(user).calculate())*100)/100.toDouble()

        assertEquals(18600.92,result,0.00)
    }

    @Test
    fun `user over 75 earning seventy k should return plus eighteen point three k`(){
        val user = UserDetails(AgeGroup.OVER_75,70000.00)
        val result = Math.round((TaxCalculator(user).calculate())*100)/100.toDouble()

        assertEquals(18351.17,result,0.00)
    }

    @Test
    fun `user under 65 earning 150 k should return plus 52 k`(){
        val user = UserDetails(AgeGroup.UNDER_65,150000.00)
        val result = Math.round((TaxCalculator(user).calculate())*100)/100.toDouble()

        assertEquals(52378.92,result,0.00)
    }

    @Test
    fun `user between 65 - 75 earning 150k should return 51 point 6 k`(){
        val user = UserDetails(AgeGroup.BETWEEN_65_AND_74,150000.00)
        val result = Math.round((TaxCalculator(user).calculate())*100)/100.toDouble()

        assertEquals(51628.92,result,0.00)
    }

    @Test
    fun `user over 75 earning 150k should return plus 51 point 3 k`(){
        val user = UserDetails(AgeGroup.OVER_75,150000.00)

        val result = Math.round((TaxCalculator(user).calculate())*100)/100.toDouble()

        assertEquals(51379.17,result,0.00)
    }
}