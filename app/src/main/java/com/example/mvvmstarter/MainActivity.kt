package com.example.mvvmstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmstarter.ui.main.MainFragment
import com.example.mvvmstarter.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}