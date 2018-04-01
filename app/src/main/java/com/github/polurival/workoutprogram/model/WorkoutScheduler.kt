package com.github.polurival.workoutprogram.model

/**
 * @author Polurival on 01.04.2018.
 */
class WorkoutScheduler {

    /**
     * todo В дальнейшем передавать сюда название упражнения и сделать какую-то фабрику,
     * которая будет для каждого упражнения по разному составлять план весов и повторов по неделям
     */
    fun calculateProgram(enteredWeight: Double): ArrayList<WorkoutModel> {
        val workoutSchedule = arrayListOf<WorkoutModel>()

        var weight = enteredWeight - 7.5
        var repeatCount = 10

        for (weekNumber in 1..12) {
            if (weekNumber == 3 || weekNumber == 5 || weekNumber == 6 ||
                    weekNumber == 8 || weekNumber == 9 || weekNumber == 11) {
                weight += 2.5
            } else if (weekNumber == 4 || weekNumber == 7 || weekNumber == 10 || weekNumber == 12) {
                weight += 5
            }

            if (weekNumber == 3 || weekNumber == 8) {
                repeatCount -= 2
            } else if (weekNumber == 5) {
                repeatCount -= 3
            } else if (weekNumber == 10 || weekNumber == 12) {
                repeatCount--
            }

            workoutSchedule.add(WorkoutModel(null, weekNumber, weight, repeatCount))
        }
        return workoutSchedule
    }
}