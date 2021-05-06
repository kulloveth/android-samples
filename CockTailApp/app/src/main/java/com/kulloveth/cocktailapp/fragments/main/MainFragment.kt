package com.kulloveth.cocktailapp.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kulloveth.cocktailapp.R
import com.kulloveth.cocktailapp.api.Api
import com.kulloveth.cocktailapp.api.Drink
import com.kulloveth.cocktailapp.api.Repository
import com.kulloveth.cocktailapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val drinks = mutableListOf<Drink>()
    var cocktailInfoModel: Drink? = null


    private val viewModel: MainFragmentViewModel by lazy {
        ViewModelProvider(
            this,
            MainViewModelFactory(Repository(Api.apiService))
        ).get(MainFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding?.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.drinksLiveData.observe(this, Observer {
            Log.d("", "${it.size}")
            drinks.addAll(it)
            binding?.pb?.visibility = View.GONE
            binding?.cocktailRv?.visibility = View.VISIBLE
        })
        val adapter = MainAdapter(drinks) {
            cocktailInfoModel = it
            requireView().findNavController().navigate(
                R.id.action_mainFragment_to_detailFragment, bundleOf(ID_ARGS to it.id)
            )
        }
        binding?.cocktailRv?.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding?.cocktailRv?.adapter = adapter

    }

    companion object{
        val ID_ARGS = MainFragment::class.java.simpleName + "id"
    }
}