package com.kulloveth.contactlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.kulloveth.contactlist.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private var binding: ActivityCategoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        title = "Contact Category"
        val adapter = CategoryRecyclerAdapter(Category.categories) { category ->
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(CATEGORY_ARGS, category)
            startActivity(intent)
        }
        binding?.categoryRv?.layoutManager = GridLayoutManager(this, 2)
        binding?.categoryRv?.adapter = adapter

    }

    companion object {
        val CATEGORY_ARGS = "category-args"
    }
}