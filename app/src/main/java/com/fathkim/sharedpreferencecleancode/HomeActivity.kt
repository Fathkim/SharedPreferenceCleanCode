package com.fathkim.sharedpreferencecleancode

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fathkim.sharedpreferencecleancode.databinding.ActivityHomeBinding
import com.fathkim.sharedpreferencecleancode.helper.Constant
import com.fathkim.sharedpreferencecleancode.helper.PreferenceHelper

class HomeActivity : AppCompatActivity() {
    //binding
    private lateinit var binding: ActivityHomeBinding
    //prefhelper
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init pref
        preferenceHelper = PreferenceHelper(this)
        //binding tvEmail -> getString from preference helper
        val email = preferenceHelper.getString(Constant.PREF_EMAIL)
        binding.textViewEmail.text = email
        //btnLogout onClick
        binding.btnLogout.setOnClickListener {
            preferenceHelper.clear()
            finish()
        }
    }
}