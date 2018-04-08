package com.github.polurival.workoutprogram.model.factory

import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.ResourceManager
import com.github.polurival.workoutprogram.di.Injector
import com.github.polurival.workoutprogram.model.factory.benchpress.BenchAnglePressRowsFactory
import com.github.polurival.workoutprogram.model.factory.benchpress.BenchNarrowPressRowsFactory
import com.github.polurival.workoutprogram.model.factory.benchpress.BenchPressMainRowsFactory
import com.github.polurival.workoutprogram.model.factory.benchpress.BenchPressSecondaryRowsFactory
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleRow

/**
 * @author Polurival on 08.04.2018.
 */
class BenchPressFactory(weight: String) : CommonRowFactory {

    private val resourceManager: ResourceManager = Injector.appComponent().getResourceManager()

    private val mainBenchFactory = BenchPressMainRowsFactory(weight)
    private val secondaryBenchFactory = BenchPressSecondaryRowsFactory(weight)
    private val angleBenchFactory = BenchAnglePressRowsFactory(weight)
    private val narrowBenchFactory = BenchNarrowPressRowsFactory(weight)

    override fun getAllWorkout(): ArrayList<ScheduleRow> {
        val rows = arrayListOf<ScheduleRow>()

        // monday
        val mondayTitleRow = getDayRow(resourceManager, R.string.monday)
        rows.add(mondayTitleRow)

        val benchMainRows = mainBenchFactory.getAllWorkoutRows(resourceManager)
        rows.addAll(benchMainRows)
        val benchAngleRows = angleBenchFactory.getAllWorkoutRows(resourceManager)
        rows.addAll(benchAngleRows)
        val benchNarrowRows = narrowBenchFactory.getAllWorkoutRows(resourceManager)
        rows.addAll(benchNarrowRows)

        rows.add(getDividerRow())

        // friday
        val fridayTitleRow = getDayRow(resourceManager, R.string.friday)
        rows.add(fridayTitleRow)

        val benchSecondaryRows = secondaryBenchFactory.getAllWorkoutRows(resourceManager)
        rows.addAll(benchSecondaryRows)

        return rows
    }
}