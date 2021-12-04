package com.example.mvvmstarter.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvmstarter.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: MainFragmentBinding
    private val adapter by lazy {
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
        })
        binding.rcrItems.adapter = adapter
        viewModel.currentItem.observe(this,{
            Log.i("Details", it.toString())
        })
        return binding.root
    }

}