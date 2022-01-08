package com.udacity.shoestore.shoe_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoe_list.ShoeViewModel

class ShoeDetailsFragment: Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShoeViewModel
    var shoe= Shoe("",0.0,"","")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //inflating a simple LinearLayout, the items here are orderly and don't overlap
        binding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_shoe_details,
        container,
        false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.shoe = shoe

        binding.saveButton.setOnClickListener{
            viewModel.addShoe(shoe)
            findNavController().popBackStack()

        }

        return binding.root
    }

}