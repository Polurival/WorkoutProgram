package com.github.polurival.workoutprogram.ui.recyclerview


import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.ui.recyclerview.RowType.*

/**
 * https://www.raywenderlich.com/172711/intermediate-recyclerview
 *
 * @author Polurival on 01.04.2018.
 */
class ScheduleAdapter(private var scheduleList: ArrayList<ScheduleRow>) : RecyclerView.Adapter<DefaultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutId = when (viewType) {
        // todo сделать разные лэйауты
            DIVIDER.ordinal -> R.layout.schedule_divider_item
            DAY.ordinal -> R.layout.schedule_header_item
            HEADER.ordinal -> R.layout.schedule_header_item
            HEADER_ROW.ordinal -> R.layout.schedule_header_item
            ROW.ordinal -> R.layout.schedule_row_item
            else -> throw IllegalArgumentException("Wrong type of ViewHolder")
        }
        val rowView = layoutInflater.inflate(layoutId, parent, false)
        return DefaultViewHolder(rowView)
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onBindViewHolder(holder: DefaultViewHolder, position: Int) {
        val scheduleRow = scheduleList[position]
        val workOutModel = scheduleRow.schedule

        when (scheduleRow.type) {
            DAY, HEADER, HEADER_ROW -> {
                workOutModel.workoutName?.let { holder.setText(R.id.workout_name_text_view, it) }
            }
            ROW -> {
                workOutModel.weekNumber?.let { holder.setText(R.id.week_text_view, it) }
                workOutModel.weight?.let { holder.setText(R.id.weight_text_view, it) }
                workOutModel.repetitionsNumber?.let { holder.setText(R.id.repetitions_number_text_view, it) }
                workOutModel.approachesNumber?.let { holder.setText(R.id.approaches_number_text_view, it) }
            }
            DIVIDER -> {
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return scheduleList[position].type.ordinal
    }

    fun updateSchedule(newScheduleList: ArrayList<ScheduleRow>) {
        DiffUtil.calculateDiff(ScheduleRowDiffCallback(scheduleList, newScheduleList), false)
                .dispatchUpdatesTo(this)
        scheduleList = newScheduleList
    }

    fun removeRow(row: Int) {
        scheduleList.removeAt(row)
        notifyItemRemoved(row)
    }
}

class ScheduleRowDiffCallback(private val oldRows: ArrayList<ScheduleRow>, private val newRows: ArrayList<ScheduleRow>)
    : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRow = oldRows[oldItemPosition]
        val newRow = newRows[newItemPosition]
        return oldRow.type == newRow.type
    }

    override fun getOldListSize(): Int = oldRows.size

    override fun getNewListSize(): Int = newRows.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRow = oldRows[oldItemPosition]
        val newRow = newRows[newItemPosition]
        return oldRow == newRow
    }
}