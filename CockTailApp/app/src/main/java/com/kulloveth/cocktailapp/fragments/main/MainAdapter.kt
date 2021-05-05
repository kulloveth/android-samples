package com.kulloveth.cocktailapp.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kulloveth.cocktailapp.api.CocktailInfoModel
import com.kulloveth.cocktailapp.databinding.ItemRvBinding

class MainAdapter(
    private val drinks: List<CocktailInfoModel>,
    private val listener: (CocktailInfoModel) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktailInfoModel: CocktailInfoModel) {
            binding.title.text = cocktailInfoModel.drinkName
            binding.thumbIv.load(cocktailInfoModel.thumbNail)
            binding.root.setOnClickListener{
                listener.invoke(cocktailInfoModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(drinks[position])
    }

    override fun getItemCount(): Int {
        return drinks.size
    }
}