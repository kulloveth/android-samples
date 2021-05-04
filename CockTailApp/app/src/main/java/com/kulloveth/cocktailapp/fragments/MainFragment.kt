package com.kulloveth.cocktailapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kulloveth.cocktailapp.R
import com.kulloveth.cocktailapp.data.api.Api
import com.kulloveth.cocktailapp.data.api.CocktailInfoModel
import com.kulloveth.cocktailapp.data.api.Repository
import com.kulloveth.cocktailapp.databinding.FragmentMainBinding
import com.kulloveth.cocktailapp.fragments.main.MainAdapter
import com.kulloveth.cocktailapp.fragments.main.MainFragmentViewModel
import com.kulloveth.cocktailapp.fragments.main.MainViewModelFactory


class MainFragment : Fragment() {

    private var binding:FragmentMainBinding? = null
    val drinks = mutableListOf<CocktailInfoModel>()

    private val viewModel: MainFragmentViewModel by lazy {
        ViewModelProvider(
            this,
           MainViewModelFactory(Repository(Api.apiService))).get(MainFragmentViewModel::class.java)
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
         Log.d("","${it.size}")
            drinks.addAll(it)
            binding?.pb?.visibility = View.GONE
            binding?.cocktailRv?.visibility = View.VISIBLE
        })
        val adapter:MainAdapter = MainAdapter(drinks)
        binding?.cocktailRv?.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding?.cocktailRv?.adapter = adapter;

    }
}