package com.beyzanuraydemir.foodorderingapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.beyzanuraydemir.foodorderingapp.R
import com.beyzanuraydemir.foodorderingapp.databinding.FragmentOdemeBinding
import com.beyzanuraydemir.foodorderingapp.util.gecisYap

class OdemeFragment : Fragment() {
    private lateinit var tasarim : FragmentOdemeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim  = DataBindingUtil.inflate(inflater,R.layout.fragment_odeme, container, false)

        tasarim.backButtonOdeme.setOnClickListener {
            activity?.onBackPressed()
        }

        tasarim.btnAlisverisTamamla.setOnClickListener {
            Navigation.gecisYap(it,R.id.odeme_odersuccesss_gecis)
        }

        return tasarim.root
    }

}