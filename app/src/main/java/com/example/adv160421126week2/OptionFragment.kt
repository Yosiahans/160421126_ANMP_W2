package com.example.adv160421126week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.adv160421126week2.databinding.FragmentOptionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class OptionFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentOptionBinding
    private val level = arrayOf("Easy","Medium","Hard")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOptionBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_dropdown_item_1line,level)
        binding.txtLevel.setAdapter(adapter)


    }



}