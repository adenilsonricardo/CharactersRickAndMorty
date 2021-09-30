package com.example.charactersrickandmorty.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.charactersrickandmorty.databinding.ActivityMainBinding
import com.example.charactersrickandmorty.databinding.ListItemBinding
import com.example.charactersrickandmorty.model.models.Characters
import com.example.charactersrickandmorty.view.CharactersAdapater.ViewHolder
import com.squareup.picasso.Picasso

class CharactersAdapater (var list: MutableList<Characters>):
    RecyclerView.Adapter<CharactersAdapater.ViewHolder>(){

    class ViewHolder (val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(characters: Characters){
            binding.characterName.text = characters.name
            binding.characterGender.text = characters.gender
            binding.characterSpecies.text = characters.species
            Picasso.get().load(characters.image).into(binding.imageCharacer)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characters = list[position]
        holder.onBind(characters)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun updateList(newList: MutableList<Characters>) {
        this.list.removeAll(list)
        if (newList != null) {
            this.list = newList
        }
        notifyDataSetChanged()
    }

}