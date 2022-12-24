package com.example.mytestproject.presentation.request


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mytestproject.R
import com.example.mytestproject.databinding.FragmentRequestBinding


class RequestFragment : Fragment() {

    lateinit var binding: FragmentRequestBinding
    lateinit var viewModel: RequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRequestBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            val card = viewModel.getAndSave(binding.textInput.text.toString())

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

        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance() = RequestFragment()
    }

}