package com.example.databinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myReview = Review("Excelente peli", 8.0, "22 de marzo 2023", "Excelente película de principio a fin")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myReview = myReview

        binding.btnReview.setOnClickListener {
            makeReview(it)
        }

    }

    fun makeReview(view: View){
        binding.apply {
            myReview?.userName = inputUserName.text.toString()
            invalidateAll()
            titleReview.visibility = View.VISIBLE
            reviewDate.visibility = View.VISIBLE
            valueReview.visibility = View.VISIBLE
            userName.visibility = View.VISIBLE
            textReview.visibility = View.VISIBLE
            imgStar.visibility = View.VISIBLE
            btnReview.visibility = View.GONE
            inputUserName.visibility = View.GONE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}