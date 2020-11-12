package com.example.todayscocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.todayscocktail.databinding.ActivityMainBinding
import com.example.todayscocktail.repository.CocktailsListRepository
import com.example.todayscocktail.view.CocktailsAdapter
import com.example.todayscocktail.viewmodel.CocktailsListViewModel
import com.example.todayscocktail.viewmodel.CocktailsListViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val recycleView = binding.itemsRecyclerView
        val adapter = CocktailsAdapter()
        recycleView.adapter = adapter

        val viewModelFactory = CocktailsListViewModelFactory(CocktailsListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailsListViewModel::class.java)
        val list = viewModel.cocktailList

        val cocktailsItems = viewModel.cocktailList
        cocktailsItems.observe(this, Observer { adapter.dataList = it })
    }

}