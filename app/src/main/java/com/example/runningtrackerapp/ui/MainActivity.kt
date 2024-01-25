package com.example.runningtrackerapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.databinding.ActivityMainBinding
import com.example.runningtrackerapp.db.RunDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        binding.bottomNavigationView.setupWithNavController(binding.navHostFragment.findNavController())
        binding.navHostFragment.findNavController()
            .addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.settingsFragment , R.id.runFragment2, R.id.statisticsFragment ->
                        binding.bottomNavigationView.visibility =
                        View.GONE
                    else -> binding.bottomNavigationView.visibility = View.VISIBLE
                }
            }

    }
}