package com.example.runningtrackerapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.databinding.ActivityMainBinding
import com.example.runningtrackerapp.db.RunDao
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController:NavController
   // private lateinit var findNavController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


     //   prepareBottomNavigation()

        setSupportActionBar(binding.toolbar)

        //binding.bottomNavigationView.setupWithNavController(binding.navHostFragment.findNavController())
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.runFragment2, R.id.statisticsFragment, R.id.settingsFragment ->
                   binding.bottomNavigationView.visibility = View.GONE

                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }

//        binding.bottomNavigationView.setupWithNavController(binding.navHostFragment.findNavController())
//        binding.navHostFragment.findNavController()
//            .addOnDestinationChangedListener{ _, destination, _ ->
//                when(destination.id){
//                    R.id.settingsFragment, R.id.runFragment2, R.id.statisticsFragment ->
//                        binding.bottomNavigationView.visibility = View.VISIBLE
//                    else -> binding.bottomNavigationView.visibility = View.GONE
//                }
//            }

//
//        binding.bottomNavigationView.setupWithNavController(binding.navHostFragment.findNavController())
//       val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//         val navController = navHostFragment.navController
//
//
//        binding.navHostFragment.findNavController()
//            .addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.setupFragment2, R.id.trackingFragment -> binding.bottomNavigationView.visibility =
//                    View.GONE
//                else -> binding.bottomNavigationView.visibility = View.VISIBLE
//            }
//        }


//            .addOnDestinationChangedListener { _, destination, _ ->
//                when (destination.id) {
//                    R.id.setupFragment2, R.id.trackingFragment -> binding.bottomNavigationView.visibility =
//                        View.GONE
//                    else -> binding.bottomNavigationView.visibility = View.VISIBLE
//                }
//            }

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        binding.bottomNavigationView.setupWithNavController(binding.navHostFragment.findNavController())
//
//        binding.navHostFragment.findNavController()
//            .addOnDestinationChangedListener { _, destination, _ ->
//                when (destination.id) {
//                    R.id.settingsFragment , R.id.runFragment2, R.id.statisticsFragment ->
//                        binding.bottomNavigationView.visibility = View.VISIBLE
//                    else -> binding.bottomNavigationView.visibility = View.GONE
//                }
//            }

    }

//    private fun prepareBottomNavigation() {
//        val navView: BottomNavigationView = binding.bottomNavigationView
//
//        navController =
//            findNavController(R.id.navHostFragment)
//        navView.setupWithNavController(navController)
//
//        navView.setOnItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.navHostFragment -> {
//                    binding.bottomNavigationView.visibility = View.VISIBLE
//                    if (navController.currentDestination?.id != R.id.settingsFragment) {
//                        navController.popBackStack()
//                        navController.navigate(R.id.settingsFragment)
//
//                    }
//                    true
//                }
//
//                R.id.navHostFragment -> {
//                    binding.bottomNavigationView.visibility = View.VISIBLE
//                    if (navController.currentDestination?.id != R.id.runFragment2) {
//                        navController.popBackStack()
//                        navController.navigate(R.id.runFragment2)
//                    }
//                    true
//                }
//                else -> false
//            }
//        }
//    }
//
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()||super.onSupportNavigateUp()
    }




}