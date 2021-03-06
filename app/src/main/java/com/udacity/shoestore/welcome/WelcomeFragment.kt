package com.udacity.shoestore.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment: Fragment(){

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //inflating a simple LinearLayout, since there are only a few items to display
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome,
            container,
            false)

        binding.lifecycleOwner = this

        binding.buttonWelcomeContinue.setOnClickListener{
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}