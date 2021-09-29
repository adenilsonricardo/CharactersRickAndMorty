package com.example.charactersrickandmorty.model.models

data class CharactersResponse(
    val info: Info,
    val results: List<Characters>
)