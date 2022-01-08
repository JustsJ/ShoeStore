package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.login.LoginFragment
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = findNavController(R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

        setSupportActionBar(findViewById(R.id.toolbar))
        Timber.plant(Timber.DebugTree())

    }

}
