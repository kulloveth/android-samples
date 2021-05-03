package com.kulloveth.cocktailapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kulloveth.cocktailapp.R
import com.kulloveth.cocktailapp.data.api.Api
import com.kulloveth.cocktailapp.data.api.Repository
import com.kulloveth.cocktailapp.fragments.main.MainFragmentViewModel
import com.kulloveth.cocktailapp.fragments.main.MainViewModelFactory


class MainFragment : Fragment() {


    private val viewModel: MainFragmentViewModel by lazy {
        ViewModelProvider(
            this,
           MainViewModelFactory(Repository(Api.apiService))).get(MainFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.drinksLiveData.observe(this, Observer {
         Log.d("","${it.size}")
        })
    }
}