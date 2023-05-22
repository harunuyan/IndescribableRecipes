package com.ui.fragment.setting

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.util.DateManager
import com.volie.indescribablerecipes.databinding.FragmentPersonalInfoBinding
import java.util.Calendar

class PersonalInfoFragment : Fragment() {
    private var _mBinding: FragmentPersonalInfoBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentPersonalInfoBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedGender()
        selectedDateOfBirth()

    }

    private fun selectedGender() {
        val genderOptions = arrayOf("Male", "Female")

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            genderOptions
        )

        with(mBinding) {
            genderDropdown.setAdapter(adapter)

            genderDropdownLayout.setOnClickListener {
                genderDropdown.showDropDown()
            }

            genderDropdown.setOnItemClickListener { _, _, position, _ ->
                val selectedGender = adapter.getItem(position).toString()
                genderDropdownLayout.hint = selectedGender
            }
        }
    }

    private fun selectedDateOfBirth() {
        mBinding.etDateOfBirth.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                showDatePicker()
            }
        }
    }

    private fun showDatePicker() {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            val formattedDate = DateManager.formatDate(selectedYear, selectedMonth, selectedDay)
            mBinding.etDateOfBirth.setText(formattedDate)
        }, year, month, day).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _mBinding = null
    }
}