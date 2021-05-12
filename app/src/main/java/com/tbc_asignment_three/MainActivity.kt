package com.tbc_asignment_three

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Toast
import com.tbc_asignment_three.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            onSave()
        }

        binding.clearButton.setOnLongClickListener {
            onClear()
            true
        }


    }




    private fun onClear(){
        binding.emailAdressEditText.text?.clear()
        binding.userNameEditText.text?.clear()
        binding.firstNameEditText.text?.clear()
        binding.lastNameEditText.text?.clear()
        binding.ageEditText.text?.clear()
    }

    private fun onSave(){


        if (binding.userNameEditText.text!!.isNotEmpty() && binding.ageEditText.text!!.isNotEmpty()
            && binding.emailAdressEditText.text!!.isNotEmpty() && binding.firstNameEditText.text!!.isNotEmpty()
            && binding.lastNameEditText.text!!.isNotEmpty()){

            if (!isEmailValid(binding.emailAdressEditText.text.toString())) problemToast("Email is not Valid!")

            if (binding.userNameEditText.text.toString().length < 10) problemToast("username must containt  10 or more characters!")

            if (binding.ageEditText.text.toString().contains(".")) problemToast("age must be a whole number")

        }else{
            Toast.makeText(this,"fill all fields", Toast.LENGTH_SHORT).show()
        }


    }


    private fun problemToast(prm: String) = Toast.makeText(this, prm, Toast.LENGTH_SHORT).show()


    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }




}