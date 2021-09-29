package com.example.charactersrickandmorty.model.api

import com.example.charactersrickandmorty.model.models.CharactersResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CharactersApi {

    @GET("character")
    fun getCharacters(): Single<CharactersResponse>
}