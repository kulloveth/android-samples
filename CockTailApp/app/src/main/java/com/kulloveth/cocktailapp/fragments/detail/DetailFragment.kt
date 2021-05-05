package com.kulloveth.cocktailapp.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.kulloveth.cocktailapp.api.Api
import com.kulloveth.cocktailapp.api.Repository
import com.kulloveth.cocktailapp.databinding.FragmentDetailBinding
import com.kulloveth.cocktailapp.fragments.main.MainFragment
import com.kulloveth.cocktailapp.fragments.main.MainFragment.Companion.ID_ARGS


class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private val viewModel by lazy {
        ViewModelProvider(this, DetailFragmentViewModelFactory(Repository(Api.apiService))).get(
            DetailFragmentViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id =""
        arguments?.let {
            id = it.getString(ID_ARGS).toString()
        }
        viewModel.fetchDetails(id)
        viewModel.detailLiveData.observe(this, Observer {
            binding?.thumbIv?.load(it[0].thumbNail)
            binding?.instructionTv?.text = it[0].instruction
            activity?.title = it[0].drinkName
        })
    }
}