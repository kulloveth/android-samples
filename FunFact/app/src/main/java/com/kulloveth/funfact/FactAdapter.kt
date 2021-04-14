package com.kulloveth.funfact

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FactAdapter(context: Context, facts: MutableList<FactModel>) :
    ArrayAdapter<FactModel>(context, 0, facts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val fact = getItem(position)
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)
        }

        val logoIv = view?.findViewById<ImageView>(R.id.logoIv)
        val nameTv = view?.findViewById<TextView>(R.id.nameTv)
        fact?.logo?.let {
            logoIv?.setImageResource(fact.logo)
        }
        nameTv?.text = fact?.name

        view?.setOnClickListener {
            val intent = Intent(parent.context,DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRA,fact?.logo)
            intent.putExtra(DETAIL_EXTRA,fact?.fact)
            intent.putExtra(NAME_EXTRA,fact?.name)
            parent.context.startActivity(intent)
        }
        return view!!
    }


    companion object{
        val NAME_EXTRA = "name_extra"
        val LOGO_EXTRA = "logo_extra"
        val DETAIL_EXTRA = "detail extra"
    }

}