package com.kulloveth.contactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kulloveth.contactlist.databinding.ContactItemLayoutBinding

class ContactListAdapter:RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private  var  contacts = mutableListOf<Contact>()

   inner class ViewHolder(private val binding: ContactItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
       fun bind(contact: Contact){
           binding.nameTv.text = contact.name
           binding.noTv.text = contact.number
       }
   }

    fun setupList(contactList: List<Contact>){
        contacts.addAll(contactList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { 
        return ViewHolder(ContactItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}