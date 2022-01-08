package com.udacity.shoestore.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoeListChanged = MutableLiveData<Boolean>()
    val shoeListChanged: LiveData<Boolean>
        get() = _shoeListChanged

    private val _shoes = mutableListOf<Shoe>()
    val shoes: List<Shoe>
        get() = _shoes

    init {
        _shoeListChanged.value = false
    }

    fun addShoe(shoe: Shoe){
        _shoes.add(shoe)
        shoeListChangeStart()
    }

    private fun shoeListChangeStart(){
        _shoeListChanged.value = true
    }

    fun shoeListChangeComplete(){
        _shoeListChanged.value = false
    }
}

