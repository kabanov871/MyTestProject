package com.example.mytestproject.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytestproject.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var adapter: HistoryAdapter
    private lateinit var viewModel: MainViewModel
    lateinit var number: String
    lateinit var link: String

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as TestApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        initRecycler()
        displayCards()

        binding.button.setOnClickListener {

            val bin = binding.textImput.text.toString()
            viewModel.saveCard(bin)
            initRecycler()
            displayCards()

        }
    }

    private fun initRecycler(){
        binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = HistoryAdapter({num: String ->call(num)}, {url: String ->openUrl(url)})
        binding.rv.adapter = adapter

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun displayCards(){

        viewModel.getList().observe(this

        ) {
            adapter.setList(it.asReversed())
            adapter.notifyDataSetChanged()
        }
    }
    fun call(num: String){
        number = num
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(number)))
        startActivity(intent)
    }
    fun openUrl(url: String){
        link = url
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://" + Uri.encode(url)))
        startActivity(intent)
    }
}