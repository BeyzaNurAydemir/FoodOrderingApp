package com.beyzanuraydemir.foodorderingapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.beyzanuraydemir.foodorderingapp.R
import com.beyzanuraydemir.foodorderingapp.data.entity.BannerResimler
import com.beyzanuraydemir.foodorderingapp.databinding.BannerCardTasarimBinding
import com.beyzanuraydemir.foodorderingapp.util.gecisYap

class BannerResimAdapter(var mContext:Context, var bannerResimlerListesi:List<BannerResimler>) :RecyclerView.Adapter<BannerResimAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:BannerCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:BannerCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim : BannerCardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.banner_card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val bannerResim = bannerResimlerListesi.get(position)
        val t = holder.tasarim
        t.imageView.setImageResource(mContext.resources.getIdentifier(bannerResim.resimAdi,"drawable",mContext.packageName))
        t.bannerCardView.setOnClickListener {
            Navigation.gecisYap(it,R.id.anaSayfa_yemekListe_Gecis)
        }
    }

    override fun getItemCount(): Int {
        return bannerResimlerListesi.size
    }
}