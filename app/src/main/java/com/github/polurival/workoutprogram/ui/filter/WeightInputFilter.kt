package com.github.polurival.workoutprogram.ui.filter

import android.text.InputFilter
import android.text.Spanned

/**
 * https://stackoverflow.com/a/27689253/5349748
 *
 * @author Polurival on 31.03.2018.
 */
class WeightInputFilter : InputFilter {

    private val maxDigitsBeforeDecimalPoint = 3;
    private val maxDigitsAfterDecimalPoint = 1;

    private val weightRegex = """(([1-9])([0-9]{0,${maxDigitsBeforeDecimalPoint - 1}})?)?(\.[0-9]{0,$maxDigitsAfterDecimalPoint})?""".toRegex()

    override fun filter(source: CharSequence?, start: Int, end: Int,
                        dest: Spanned?, dstart: Int, dend: Int): CharSequence? {
        val builder = StringBuilder(dest)
        builder.replace(dstart, dend, source?.subSequence(start, end).toString())

        if (!builder.toString().matches(weightRegex)) {
            if (source?.length == 0) {
                return dest?.subSequence(dstart, dend)
            }
            return "";
        }
        return null
    }
}