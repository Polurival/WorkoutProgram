package com.github.polurival.workoutprogram.model

/**
 * @author Polurival on 31.03.2018.
 */
data class WorkoutModel(val workoutName: String?,
                        val weekNumber: Int,
                        val weight: Double,
                        val repetitionsNumber: Int,
                        val approachesNumber: Int = 3)