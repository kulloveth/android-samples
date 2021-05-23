package com.kulloveth.contactlist.auth

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kulloveth.contactlist.data.Repository
import com.kulloveth.contactlist.data.db.DbAccessor
import com.kulloveth.contactlist.data.db.User
import com.kulloveth.contactlist.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private var binding: ActivitySignupBinding? = null
    private var repository: Repository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        repository = Repository(DbAccessor.db)
        val user = repository?.fetchAllUsers()
        user?.forEach {
            Log.d("users", "" + it.email)
        }

        binding?.signupBtn?.setOnClickListener { view ->
            val username = binding?.usernameEt?.text.toString()
            val email = binding?.emailEt?.text.toString()
            val password = binding?.passwordEt?.text.toString()
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(
                    password
                )
            ) {
                Snackbar.make(view, "Fields must not be empty", Snackbar.LENGTH_LONG).show()
            } else {
                        repository?.insertUser(User(username, email, password))
                        Snackbar.make(view, "Successfully registered", Snackbar.LENGTH_LONG).show()
                }

        }
    }
}