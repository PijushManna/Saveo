package com.example.saveo.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo.R
import com.example.saveo.databinding.LayoutListItemBinding
import com.example.saveo.models.Result


class MainListAdapter(private val viewModel: MainViewModel) : ListAdapter<Result,MainListAdapter.ViewHolder>(MainDiffItemCallback()) {

    class ViewHolder(private val binding: LayoutListItemBinding,private val viewModel: MainViewModel):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Result){
            binding.model = item.picture
            binding.executePendingBindings()
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
        if(position == itemCount-1){
            viewModel.apiCall()
            Log.i("Adapter","APi Called")
        }
    }

    class MainDiffItemCallback : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }
}