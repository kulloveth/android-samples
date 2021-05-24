package com.kulloveth.contactlist.auth

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kulloveth.contactlist.App
import com.kulloveth.contactlist.data.db.User
import com.kulloveth.contactlist.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private var binding: ActivitySignupBinding? = null

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory((application as App).repository)
    }
    private val users = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        authViewModel.allUserLiveData.observe(this, {
            Log.d("userss", "" + it)
            users.addAll(it)
        })


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
                var user: User? = null
                users.forEach {
                    Log.d("usera", "" + it.email)
                    user = it
                }
                if (user?.email == email) {
                    Snackbar.make(view, "email already exist", Snackbar.LENGTH_LONG).show()
                    Log.d("userr", "" + user?.email)
                } else {
                    authViewModel.insertUser(User(username, email, password))
                    Snackbar.make(view, "Successfully registered", Snackbar.LENGTH_LONG).show()
                }
            }

        }
    }
}