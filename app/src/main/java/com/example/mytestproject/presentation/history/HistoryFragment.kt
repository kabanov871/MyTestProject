package com.example.mytestproject.presentation.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestproject.databinding.FragmentHistoryBinding
import com.example.mytestproject.domain.UseCaseModel


class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : HistoryAdapter
    lateinit var viewModel: HistoryViewModel
    private var cardList = ArrayList<UseCaseModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)

        cardList.addAll(viewModel.getList())

        init()

        return binding.root
    }
    private fun init(){
        binding.rv.layoutManager = LinearLayoutManager(context)
        recyclerView = binding.rv
        adapter = HistoryAdapter()
        recyclerView.adapter = adapter
        adapter.setList(cardList)
    }
    companion object {
        @JvmStatic
        fun newInstance() = HistoryFragment()
    }
}