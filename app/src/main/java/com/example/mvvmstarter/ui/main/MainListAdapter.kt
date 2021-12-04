package com.example.mvvmstarter.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmstarter.R
import com.example.mvvmstarter.databinding.LayoutListItemBinding
import com.example.mvvmstarter.models.Result


class MainListAdapter(private val viewModel: MainViewModel) : ListAdapter<Result,MainListAdapter.ViewHolder>(MainDiffItemCallback()) {

    class ViewHolder(private val binding: LayoutListItemBinding,private val viewModel: MainViewModel):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Result){
            binding.model = item.picture
            binding.imageView.setOnClickListener {
                viewModel.currentItem.postValue(item)
                it.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lyt = LayoutListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(lyt,viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MainDiffItemCallback : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }
}