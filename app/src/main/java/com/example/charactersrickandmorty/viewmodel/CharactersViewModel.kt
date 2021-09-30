package com.example.charactersrickandmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.charactersrickandmorty.model.models.CharactersResponse
import com.example.charactersrickandmorty.model.models.RetrofitService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharactersViewModel: ViewModel() {
    val disposable = CompositeDisposable()
    val charactersResult: MutableLiveData<CharactersResponse> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getCharacters(){
        disposable.add(
            RetrofitService.service.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    charactersResult.value = it
                },{ e ->
                    error.value = e.message
                })
        )
    }

}