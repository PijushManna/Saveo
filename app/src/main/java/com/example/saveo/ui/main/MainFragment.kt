package com.example.saveo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.saveo.R
import com.example.saveo.databinding.MainFragmentBinding
import androidx.recyclerview.widget.LinearSnapHelper

import androidx.recyclerview.widget.SnapHelper





class MainFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: MainFragmentBinding
    private val adapter by lazy {
        MainListAdapter(viewModel)
    }
    private val adapter2 by lazy {
        MainListAdapter(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater,container,false)
        viewModel.apiCall()
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.allData.observe(viewLifecycleOwner,{
            adapter.submitList(it)
            adapter2.submitList(it)
            adapter.notifyDataSetChanged()
            adapter2.notifyDataSetChanged()
        })
        binding.rcrItems.adapter = adapter
        binding.rcrHorList.adapter = adapter2

        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(binding.rcrHorList)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}