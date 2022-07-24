package com.beyzanuraydemir.foodorderingapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.beyzanuraydemir.foodorderingapp.R
import com.beyzanuraydemir.foodorderingapp.data.entity.Sepet
import com.beyzanuraydemir.foodorderingapp.databinding.SepetCardTasarimBinding
import com.beyzanuraydemir.foodorderingapp.ui.viewmodel.SepetFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext:Context,
                   var sepetListesi:List<Sepet>,
                   var viewModel: SepetFragmentViewModel) : RecyclerView.Adapter<SepetAdapter.SepetCardTasarimTutucu>() {

    inner class SepetCardTasarimTutucu(tasarim:SepetCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:SepetCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim : SepetCardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.sepet_card_tasarim, parent, false)
        return SepetCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SepetCardTasarimTutucu, position: Int) {
        val sepet = sepetListesi.get(position)
        val t = holder.tasarim
        t.tvSepetYemekAdi.text = "${sepet.yemek_adi}"
        t.tvSepetYemekFiyati.text = "${sepet.yemek_fiyat * sepet.yemek_siparis_adet} ₺"
        t.tvSepetYemekAdet.text = "${sepet.yemek_siparis_adet}"

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepet.yemek_resim_adi}"
        Picasso.get().load(url).into(t.ivSepetYemekResim)

        t.ivSilResim.setOnClickListener {
            Snackbar.make(it,"${sepet.yemek_adi} sepetten çıkarılsın mı?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                   viewModel.sil(sepet.sepet_yemek_id,sepet.kullanici_adi)
                }.show()
        }

        t.btnSepetEksi.setOnClickListener {
            if(sepet.yemek_siparis_adet>1){
                sepet.yemek_siparis_adet--
                t.tvSepetYemekAdet.text = "${sepet.yemek_siparis_adet}"
                t.tvSepetYemekFiyati.text = "${sepet.yemek_siparis_adet * sepet.yemek_fiyat} ₺"
            }
        }

        t.btnSepetArti.setOnClickListener {
            sepet.yemek_siparis_adet++
            t.tvSepetYemekAdet.text = "${sepet.yemek_siparis_adet}"
            t.tvSepetYemekFiyati.text = "${sepet.yemek_siparis_adet * sepet.yemek_fiyat} ₺"
        }

    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }
}