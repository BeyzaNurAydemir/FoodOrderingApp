package com.beyzanuraydemir.foodorderingapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beyzanuraydemir.foodorderingapp.data.entity.Yemekler
import com.beyzanuraydemir.foodorderingapp.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YemekListeFragmentViewModel @Inject constructor (var yrepo:YemeklerDaoRepository) : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }

    fun yemekleriYukle(){
        yrepo.tumYemekleriAl()
    }
}