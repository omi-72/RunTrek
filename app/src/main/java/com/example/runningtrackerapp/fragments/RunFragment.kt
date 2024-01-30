package com.example.runningtrackerapp.fragments

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.databinding.FragmentRunBinding
import com.example.runningtrackerapp.databinding.FragmentSetupBinding
import com.example.runningtrackerapp.other.Constants.REQUEST_CODE_LOCATION_PERMISSION
import com.example.runningtrackerapp.other.TrackingUtility
import com.example.runningtrackerapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class RunFragment : Fragment(R.layout.fragment_run) , EasyPermissions.PermissionCallbacks {

   private lateinit var binding : FragmentRunBinding

   private val viewModel: MainViewModel by viewModels()

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      binding = FragmentRunBinding.inflate(inflater)
      return binding.root

   }
   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      requestPermission()

      initListener()
   }

   private fun initListener() {
      binding.fab.setOnClickListener {
         it.findNavController().navigate(R.id.action_runFragment2_to_trackingFragment)
      }

      binding.layoutRun.setOnClickListener {
         replaceFragment(RunFragment())
         binding.imageViewRun.visibility = View.GONE
         binding.textViewRun.visibility = View.GONE
         binding.imageViewRunYellow.visibility = View.VISIBLE
         binding.textViewRunTellow.visibility = View.VISIBLE

         binding.imageViewStatistic.visibility = View.VISIBLE
         binding.textViewStatistic.visibility = View.VISIBLE
         binding.imageViewStatisticYellow.visibility = View.GONE
         binding.textViewStatisticYellow.visibility = View.GONE

         binding.imageViewSetting.visibility = View.VISIBLE
         binding.textViewSettings.visibility = View.VISIBLE
         binding.imageViewSettingYellow.visibility = View.GONE
         binding.textViewSettingsYellow.visibility = View.GONE
      }

      binding.layoutStatistics.setOnClickListener {
         replaceFragment(StatisticsFragment())
         binding.fab.visibility = View.GONE
         binding.rvRuns.visibility = View.GONE
         binding.spFilter.visibility = View.GONE
         binding.tvFilterBy.visibility = View.GONE

         binding.imageViewStatistic.visibility = View.GONE
         binding.textViewStatistic.visibility = View.GONE
         binding.imageViewStatisticYellow.visibility = View.VISIBLE
         binding.textViewStatisticYellow.visibility = View.VISIBLE

         binding.imageViewSetting.visibility = View.VISIBLE
         binding.textViewSettings.visibility = View.VISIBLE
         binding.imageViewSettingYellow.visibility = View.GONE
         binding.textViewSettingsYellow.visibility = View.GONE

         binding.imageViewRun.visibility = View.VISIBLE
         binding.textViewRun.visibility = View.VISIBLE
         binding.imageViewRunYellow.visibility = View.GONE
         binding.textViewRunTellow.visibility = View.GONE
      }

      binding.layoutSettings.setOnClickListener {
         replaceFragment(SettingsFragment())
         binding.fab.visibility = View.GONE
         binding.rvRuns.visibility = View.GONE
         binding.spFilter.visibility = View.GONE
         binding.tvFilterBy.visibility = View.GONE
         binding.imageViewSetting.visibility = View.GONE
         binding.textViewSettings.visibility = View.GONE
         binding.imageViewSettingYellow.visibility = View.VISIBLE
         binding.textViewSettingsYellow.visibility = View.VISIBLE

         binding.imageViewStatistic.visibility = View.VISIBLE
         binding.textViewStatistic.visibility = View.VISIBLE
         binding.imageViewStatisticYellow.visibility = View.GONE
         binding.textViewStatisticYellow.visibility = View.GONE

         binding.imageViewRun.visibility = View.VISIBLE
         binding.textViewRun.visibility = View.VISIBLE
         binding.imageViewRunYellow.visibility = View.GONE
         binding.textViewRunTellow.visibility = View.GONE
      }
   }

   private fun replaceFragment(fragment: Fragment) {
      val fragmentManager = childFragmentManager
      val fragmentTransaction = fragmentManager.beginTransaction()
      fragmentTransaction.replace(R.id.fargmentContainer, fragment)
      fragmentTransaction.commit()
   }

   private fun requestPermission(){
   if (TrackingUtility.hasLocationPermission(requireContext())){
      return
   }
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
         EasyPermissions.requestPermissions(
            this,
            "You need to accept location permissions to use this app.",
            REQUEST_CODE_LOCATION_PERMISSION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
         )
      } else {
         EasyPermissions.requestPermissions(
            this,
            "You need to accept location permissions to use this app.",
            REQUEST_CODE_LOCATION_PERMISSION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
         )
      }
   }



   override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
      if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)){
         AppSettingsDialog.Builder(this).build().show()
      } else{
         requestPermission()
      }
   }
   override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}

   override fun onRequestPermissionsResult(
      requestCode: Int,
      permissions: Array<out String>,
      grantResults: IntArray
   ) {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults)
      EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
   }


}