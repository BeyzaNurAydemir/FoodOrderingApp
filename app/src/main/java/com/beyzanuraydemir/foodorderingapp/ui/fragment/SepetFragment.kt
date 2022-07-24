package com.beyzanuraydemir.foodorderingapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyzanuraydemir.foodorderingapp.R
import com.beyzanuraydemir.foodorderingapp.data.entity.Sepet
import com.beyzanuraydemir.foodorderingapp.databinding.FragmentSepetBinding
import com.beyzanuraydemir.foodorderingapp.ui.adapter.SepetAdapter
import com.beyzanuraydemir.foodorderingapp.ui.viewmodel.SepetFragmentViewModel
import com.beyzanuraydemir.foodorderingapp.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var tasarim : FragmentSepetBinding
    private lateinit var viewModel : SepetFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_sepet, container, false)
        tasarim.sepetFragment = this
        tasarim.sepetToolbarBaslik = "Sepetim"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarSepet)


        viewModel.sepetListesi.observe(viewLifecycleOwner){
            val adapter = SepetAdapter(requireContext(),it,viewModel)
            tasarim.sepetAdapter = adapter
        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SepetFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun btnTikla(v:View){
        Navigation.gecisYap(v,R.id.sepet_odeme_gecis)
    }

    override fun onResume() {
        super.onResume()
        viewModel.sepetiYukle()
    }
}