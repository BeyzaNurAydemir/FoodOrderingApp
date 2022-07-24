package com.beyzanuraydemir.foodorderingapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.beyzanuraydemir.foodorderingapp.R
import com.beyzanuraydemir.foodorderingapp.data.repo.YemeklerDaoRepository
import com.beyzanuraydemir.foodorderingapp.databinding.FragmentOrderSuccessBinding
import com.beyzanuraydemir.foodorderingapp.util.gecisYap

class OrderSuccessFragment : Fragment() {
    private lateinit var tasarim : FragmentOrderSuccessBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_order_success, container, false)
        return tasarim.root
    }


}