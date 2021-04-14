package com.kulloveth.funfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kulloveth.funfact.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var binding: ActivityDetailBinding? = null
    private var logo = 0
    private var detail: String? = null
    private var name:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        logo = intent.getIntExtra(FactAdapter.LOGO_EXTRA, 0)
        detail = intent.getStringExtra(FactAdapter.DETAIL_EXTRA)
        name = intent.getStringExtra(FactAdapter.NAME_EXTRA)
        setUpDetailActivity()
    }

    private fun setUpDetailActivity() {
        binding?.logoIv?.setImageResource(logo)
        binding?.detailsTv?.text = detail
        title = name
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}