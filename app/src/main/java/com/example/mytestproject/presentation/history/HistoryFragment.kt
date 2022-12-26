package com.example.mytestproject.presentation.history

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytestproject.databinding.FragmentHistoryBinding
import com.example.mytestproject.presentation.TestApp
import com.example.mytestproject.presentation.ViewModelFactory
import javax.inject.Inject


class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding
    lateinit var adapter : HistoryAdapter
    private lateinit var viewModel: HistoryViewModel
    lateinit var number: String
    lateinit var link: String

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as TestApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[HistoryViewModel::class.java]

        initRecycler()
        displayCards()

        return binding.root
    }
    private fun initRecycler(){
        binding.rv.layoutManager = LinearLayoutManager(context)
        adapter = HistoryAdapter({num: String ->call(num)}, {url: String ->openUrl(url)})
        binding.rv.adapter = adapter

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun displayCards(){

        viewModel.getList().observe(viewLifecycleOwner

        ) {
            adapter.setList(it.asReversed())
            adapter.notifyDataSetChanged()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = HistoryFragment()
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