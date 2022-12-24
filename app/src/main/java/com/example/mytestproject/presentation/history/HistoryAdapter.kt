package com.example.mytestproject.presentation.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestproject.R
import com.example.mytestproject.databinding.CardItemBinding
import com.example.mytestproject.domain.UseCaseModel

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>(){

    private var cardList = emptyList<UseCaseModel>()


    class HistoryHolder(item: View): RecyclerView.ViewHolder(item){

        val binding = CardItemBinding.bind(item)
        fun bind(card: UseCaseModel) = with (binding){

            binding.apply {
                schemeNetwork.text = card.scheme
                type.text = card.type
                brand.text = card.brand
                length.text = card.length.toString()
                country.text = card.country
                latitude.text = card.latitude.toString()
                longitude.text = card.longitude.toString()
                bank.text = card.name
                website.text = card.url
                phoneNumber.text = card.phone

                if (card.prepaid == true) {
                    prepaid.text = R.string.yes.toString()
                }
                else
                    prepaid.text = R.string.no.toString()

                if (card.luhn == true) {
                    luhn.text = R.string.yes.toString()
                }
                else
                    luhn.text = R.string.no.toString()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false)
        return HistoryHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList (list: List<UseCaseModel>){
        cardList = list
        notifyDataSetChanged()
    }

}