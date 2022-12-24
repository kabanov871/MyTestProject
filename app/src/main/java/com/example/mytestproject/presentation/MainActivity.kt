package com.example.mytestproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytestproject.R
import com.example.mytestproject.databinding.ActivityMainBinding
import com.example.mytestproject.presentation.history.HistoryFragment
import com.example.mytestproject.presentation.request.RequestFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.frame, RequestFragment.newInstance()).commit()

        binding.bNav.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.item1 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame, RequestFragment.newInstance()).commit()
                }
                R.id.item2 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame, HistoryFragment.newInstance()).commit()
                }

            }
            true
        }
    }
}