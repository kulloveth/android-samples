package com.kulloveth.contactlist.category

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.kulloveth.contactlist.contact.ContactActivity
import com.kulloveth.contactlist.data.db.DbAccessor
import com.kulloveth.contactlist.data.db.User
import com.kulloveth.contactlist.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private var binding: ActivityCategoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        title = "Contact Category"
        val adapter = CategoryRecyclerAdapter(Category.categories) { category ->
            val intent = Intent(this, ContactActivity::class.java)
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