package com.kulloveth.contactlist

object ContactListHelper {
    private lateinit var contacts: List<Contact>

    fun setContactList(list: List<Contact>) {
        this.contacts = list
    }

    fun getItemSize() = contacts.size

    fun getContactList() = contacts


    fun addContact(contact: Contact) {
        contacts.toMutableList().add(contact)
    }

    fun deleteContact(contact: Contact){
        contacts.toMutableList().remove(contact)
    }

    fun deleteAllContact(contacts:List<Contact>){
        contacts.toMutableList().removeAll(contacts)
    }
}