package com.beyzanuraydemir.foodorderingapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.beyzanuraydemir.foodorderingapp.R
import com.beyzanuraydemir.foodorderingapp.data.entity.BannerResimler
import com.beyzanuraydemir.foodorderingapp.databinding.FragmentAnasayfaBinding
import com.beyzanuraydemir.foodorderingapp.ui.adapter.BannerResimAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim : FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.rvBannerResimler.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        val bannerResimListe = ArrayList<BannerResimler>()
        val r1 = BannerResimler(1,"cv1")
        val r2 = BannerResimler(2,"cv2")
        val r3 = BannerResimler(3,"cv3")
        val r4 = BannerResimler(4,"cv4")
        val r5 = BannerResimler(5,"cv5")
        bannerResimListe.add(r1)
        bannerResimListe.add(r2)
        bannerResimListe.add(r3)
        bannerResimListe.add(r4)
        bannerResimListe.add(r5)

        val adapter = BannerResimAdapter(requireContext(),bannerResimListe)
        tasarim.rvBannerResimler.adapter = adapter

        return tasarim.root
    }

}