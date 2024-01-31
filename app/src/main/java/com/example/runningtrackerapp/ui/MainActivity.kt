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
import com.example.runningtrackerapp.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT
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

        navigateToTrackingFragmentIfNeeded(intent)


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

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()||super.onSupportNavigateUp()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent?){
        if(intent?.action == ACTION_SHOW_TRACKING_FRAGMENT){
            binding.navHostFragment.findNavController().navigate(R.id.action_global_trackingFragment)
        }
    }




}