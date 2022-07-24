package com.beyzanuraydemir.foodorderingapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beyzanuraydemir.foodorderingapp.data.entity.Sepet
import com.beyzanuraydemir.foodorderingapp.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetFragmentViewModel @Inject constructor (var yrepo:YemeklerDaoRepository) : ViewModel() {
    var sepetListesi = MutableLiveData<List<Sepet>>()

    init {
        sepetiYukle()
        sepetListesi = yrepo.sepetiGetir()
    }

    fun sil(sepet_yemek_id:Int,kullanici_adi:String){
        yrepo.sepetYemekSil(sepet_yemek_id,kullanici_adi)
    }

    fun sepetiYukle(){
        yrepo.tumSepetiGoster()
    }

}