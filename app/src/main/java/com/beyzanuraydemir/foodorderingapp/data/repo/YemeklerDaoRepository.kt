package com.beyzanuraydemir.foodorderingapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.beyzanuraydemir.foodorderingapp.data.entity.*
import com.beyzanuraydemir.foodorderingapp.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository(var ydao:YemeklerDao) {
    var yemeklerListesi : MutableLiveData<List<Yemekler>>
    var sepetListesi : MutableLiveData<List<Sepet>>

    init {
        yemeklerListesi = MutableLiveData()
        sepetListesi = MutableLiveData()
    }

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun sepetiGetir() : MutableLiveData<List<Sepet>> {
        return sepetListesi
    }

    fun yemekSepeteEkle(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:Int, yemek_siparis_adet:Int, kullanici_adi:String){
        ydao.yemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                val basari = response.body()!!.success
                val mesaj = response.body()!!.message
                Log.e("Yemek sepete ekle", "$basari - $mesaj")
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun tumYemekleriAl(){
        ydao.tumYemekler().enqueue(object:Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler
                yemeklerListesi.value = liste

            }
            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}
        })
    }

    fun sepetYemekSil(sepet_yemek_id:Int,kullanici_adi:String){
        ydao.sepettenYemekSil(sepet_yemek_id,"BeyzaAydemir").enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                val basari = response.body()!!.success
                val mesaj = response.body()!!.message
                Log.e("Yemek sepete ekle", "$basari - $mesaj")
                tumSepetiGoster()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun tumSepetiGoster(){
       ydao.sepettekiYemekler("BeyzaAydemir").enqueue(object:Callback<SepetCevap>{
           override fun onResponse(call: Call<SepetCevap>?, response: Response<SepetCevap>) {
               val liste = response.body()!!.sepet_yemekler
               sepetListesi.value = liste
           }

           override fun onFailure(call: Call<SepetCevap>, t: Throwable) {}
       })
    }
}