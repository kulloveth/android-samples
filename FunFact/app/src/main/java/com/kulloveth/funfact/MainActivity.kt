package com.kulloveth.funfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.kulloveth.funfact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var adapter:FactAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpFunFact()
    }


    private fun setUpFunFact(){
        adapter = FactAdapter(this,DummyData.funFacts.toMutableList())
        binding?.factLv?.adapter = adapter
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}