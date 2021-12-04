package com.example.saveo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.saveo.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private val viewModel:MainViewModel by activityViewModels()
    private lateinit var binding:FragmentDetailsBinding 
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        viewModel.currentItem.observe(viewLifecycleOwner,{
            binding.model = it
        })
        return binding.root
    }
}