package com.udacity.shoestore.shoe_list

import android.os.Bundle
import android.view.*
import androidx.core.view.children
import androidx.core.view.isEmpty
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //inflating a ConstraintLayout, the design gets more complex with the
        //FloatingActionButton thrown in the mix
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        //populate the list with Shoes that are already saved (if necessary)
        if (binding.linearLayout.isEmpty()) {
            for (shoe in viewModel.shoes) {
                addShoeItem(shoe)
            }
            //disable shoeListChanged if in case it was called,
            //since updating the view is no longer needed
            viewModel.shoeListChangeComplete()
        }

        viewModel.shoeListChanged.observe(this, Observer {
            if (it) {
                addShoeItem(viewModel.shoes.last())
                viewModel.shoeListChangeComplete()
            }
        })

        binding.floatingActionButton.setOnClickListener() {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> logout()
        }
        return super.onOptionsItemSelected(item)
    }



    private fun logout() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
    }

    fun addShoeItem(shoe: Shoe) {
        //inflating a simple LinearLayout, where the views are neatly in order
        val shoeViewBinding = DataBindingUtil.inflate<ItemShoeBinding>(
            layoutInflater,
            R.layout.item_shoe, binding.linearLayout, true
        )
        shoeViewBinding.nameText.text = shoe.name
        shoeViewBinding.sizeText.text = shoe.size.toString()
        shoeViewBinding.companyText.text = shoe.company
        shoeViewBinding.descriptionText.text = shoe.description
    }


}
