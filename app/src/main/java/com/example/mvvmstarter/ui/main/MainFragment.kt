package com.example.mvvmstarter.ui.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvmstarter.R
import com.example.mvvmstarter.databinding.MainFragmentBinding


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
        viewModel.allData.observe(this,{
            adapter.submitList(it)
            adapter2.submitList(it)
        })
        binding.rcrItems.adapter = adapter
        binding.rcrHorList.adapter = adapter2
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