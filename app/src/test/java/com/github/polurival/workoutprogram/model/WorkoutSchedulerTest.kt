package com.github.polurival.workoutprogram.model

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * @author Polurival on 01.04.2018.
 */
class WorkoutSchedulerTest {

    val scheduler: WorkoutScheduler = WorkoutScheduler()

    @Test
    fun checkStandardProgram() {
        val workoutSchedule = scheduler.calculateProgram(75.0)

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