package com.github.polurival.workoutprogram.model.factory

import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.ResourceManager
import com.github.polurival.workoutprogram.ui.recyclerview.AdapterModel
import com.github.polurival.workoutprogram.ui.recyclerview.RowType
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleRow

/**
 * Фабрика создающее расписание
 * - название упражнения
 * - шапка таблицы (номер недели, вес, кол-во повторов, кол-во подходов)
 * - 12 рядов с циферками
 *
 * @author Polurival on 08.04.2018.
 */
interface ScheduleFactory {

    fun createTitleRow(resourceManager: ResourceManager): ScheduleRow

    fun createHeaderRow(resourceManager: ResourceManager): ScheduleRow {
        return ScheduleRow(RowType.ROW,
                AdapterModel(null,
                        resourceManager.getString(R.string.week),
                        resourceManager.getString(R.string.weight),
                        resourceManager.getString(R.string.repetitions_number),
                        resourceManager.getString(R.string.approaches_number)))
    }

    fun createBodyRow(): ArrayList<ScheduleRow>

    fun getAllWorkoutRows(resourceManager: ResourceManager) : ArrayList<ScheduleRow> {
        val allRows = ArrayList<ScheduleRow>()
        allRows.add(createTitleRow(resourceManager))
        allRows.add(createHeaderRow(resourceManager))
        allRows.addAll(createBodyRow())
        return allRows
    }
}