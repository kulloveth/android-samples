package com.kulloveth.contactlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.kulloveth.contactlist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpDialog(binding)
    }

    private fun setUpDialog(binding: ActivityMainBinding) {
        val builder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.add_new_contact_layout, null)
        builder.setView(dialogView)

        val et = dialogView.findViewById<TextInputEditText>(R.id.nameEt)
        val noEt = dialogView.findViewById<TextInputEditText>(R.id.numberEt)
        val saveBtn = dialogView.findViewById<MaterialButton>(R.id.saveBt)
        noEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBtn.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        val alertDialog: AlertDialog = builder.create()
        binding.addFab.setOnClickListener {
            alertDialog.show()
        }

    }
}