package com.github.polurival.workoutprogram.model.factory

import com.github.polurival.workoutprogram.model.factory.benchpress.BenchPressMainRowsFactory
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test


/**
 * @author Polurival on 08.04.2018.
 */
class BenchPressMainRowsFactoryTest {

    val factory = BenchPressMainRowsFactory("75.0")

    @Test
    fun calculate() {
        val workoutSchedule = factory.calculate()

        val (workoutName6, weekNumber6, weight6, numberOfRepetitions6, numberOfApproaches6) = workoutSchedule[5]
        assertThat(weekNumber6, `is`(6))
        assertThat(weight6, `is`(80.0))
        assertThat(numberOfRepetitions6, `is`(5))
        assertThat(numberOfApproaches6, `is`(3))

        val (workoutName12, weekNumber12, weight12, numberOfRepetitions12, numberOfApproaches12) = workoutSchedule.last()
        assertThat(weekNumber12, `is`(12))
        assertThat(weight12, `is`(102.5))
        assertThat(numberOfRepetitions12, `is`(1))
        assertThat(numberOfApproaches12, `is`(3))
    }
}