package com.example.mytestproject.presentation.history


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestproject.R
import com.example.mytestproject.databinding.CardItemBinding
import com.example.mytestproject.domain.UseCaseModel

class HistoryAdapter (private val call:(num: String)->Unit, private val openUrl:(url: String)->Unit) : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>(){

    private var cardList = ArrayList<UseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {

        val binding : CardItemBinding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryHolder(binding)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.bind(cardList[position], call, openUrl)
    }

    fun setList (list: List<UseCaseModel>){
        cardList.clear()
        cardList.addAll(list)
    }

    class HistoryHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root){


        fun bind(card: UseCaseModel, call:(num: String)->Unit, openUrl: (url: String) -> Unit) {

            binding.apply {
                tvBin.text = card.bin
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
                    prepaid.setText(R.string.yes)
                }
                else
                    prepaid.setText(R.string.no)

                if (card.luhn == true) {
                    luhn.setText(R.string.yes)
                }
                else
                    luhn.setText(R.string.no)

                website.setOnClickListener { openUrl(card.url) }
                phoneNumber.setOnClickListener { call(card.phone) }
            }


        }
    }

}