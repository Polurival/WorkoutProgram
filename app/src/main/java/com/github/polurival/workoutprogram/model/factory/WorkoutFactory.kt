package com.github.polurival.workoutprogram.model.factory

import com.github.polurival.workoutprogram.model.factory.WorkoutType.BENCH_PRESS
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleRow

/**
 * Общая фабрика, вся работа идет с ней,
 * она скрывает внутреннюю реализацию расписаний для разных типов упражнений
 *
 * @author Polurival on 08.04.2018.
 */
class WorkoutFactory(private val workoutType: WorkoutType,
                     private val weight: String) {

    fun allWorkout(): ArrayList<ScheduleRow> {
        return getWorkoutRowsFactory().getAllWorkout()
    }

    private fun getWorkoutRowsFactory(): CommonRowFactory {
        return when (workoutType) {
            BENCH_PRESS -> BenchPressFactory(weight)
        }
    }
}