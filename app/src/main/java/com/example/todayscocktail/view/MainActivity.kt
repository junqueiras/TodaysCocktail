package com.example.todayscocktail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.todayscocktail.R
import com.example.todayscocktail.repository.CocktailsListRepository
import com.example.todayscocktail.viewmodel.CocktailsListViewModel
import com.example.todayscocktail.viewmodel.CocktailsListViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = CocktailsListViewModelFactory(CocktailsListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailsListViewModel::class.java)
        val list = viewModel.cocktailList

    }
}