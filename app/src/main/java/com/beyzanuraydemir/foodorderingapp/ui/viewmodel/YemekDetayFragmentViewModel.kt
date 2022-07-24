package com.beyzanuraydemir.foodorderingapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.beyzanuraydemir.foodorderingapp.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YemekDetayFragmentViewModel @Inject constructor (var yrepo:YemeklerDaoRepository) : ViewModel() {

    fun sepeteEkle(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:Int, yemek_siparis_adet:Int, kullanici_adi:String){
       yrepo.yemekSepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }
}