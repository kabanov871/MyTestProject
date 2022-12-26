package com.example.mytestproject.presentation.request


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytestproject.R
import com.example.mytestproject.databinding.FragmentRequestBinding
import com.example.mytestproject.domain.UseCaseModel
import com.example.mytestproject.presentation.TestApp
import com.example.mytestproject.presentation.ViewModelFactory
import javax.inject.Inject


class RequestFragment : Fragment() {

    lateinit var binding: FragmentRequestBinding
    private lateinit var viewModel: RequestViewModel
    lateinit var card: UseCaseModel
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
        binding = FragmentRequestBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[RequestViewModel::class.java]
        binding.button.setOnClickListener {

            val bin = binding.textInput.text.toString()

            viewModel.saveCard(bin)

             card = viewModel.getCard(bin)

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
                 } else
                     prepaid.text = R.string.no.toString()

                 if (card.luhn == true) {
                     luhn.text = R.string.yes.toString()
                 } else
                     luhn.text = R.string.no.toString()

                 website.setOnClickListener { openUrl(card.url) }
                 phoneNumber.setOnClickListener { call(card.phone) }
             }

        }

        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance() = RequestFragment()
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