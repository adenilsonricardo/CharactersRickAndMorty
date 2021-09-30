package com.example.charactersrickandmorty.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.charactersrickandmorty.databinding.ListItemBinding
import com.example.charactersrickandmorty.model.models.Characters
import com.squareup.picasso.Picasso
import okhttp3.internal.toImmutableList

class CharactersAdapter (var list: MutableList<Characters>):
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>(){

    class ViewHolder (val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(characters: Characters){
            binding.characterName.text = characters.name
            binding.characterSpecies.text = characters.species
            binding.characterGender.text = characters.gender
            Picasso.get().load(characters.image).into(binding.characterImage)
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