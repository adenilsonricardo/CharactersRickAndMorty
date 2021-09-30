package com.example.charactersrickandmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charactersrickandmorty.R
import com.example.charactersrickandmorty.databinding.ActivityMainBinding
import com.example.charactersrickandmorty.model.models.Characters
import com.example.charactersrickandmorty.viewmodel.CharactersViewModel

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharactersViewModel
    
    private val list = mutableListOf<Characters>()
    private val adapter = CharactersAdapater(list)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        viewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)
        
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        
        viewModel.getCharacters()
        
        viewModel.charactersResult.observe(this, Observer{
            adapter.updateList(it.results)
        })
    }
}