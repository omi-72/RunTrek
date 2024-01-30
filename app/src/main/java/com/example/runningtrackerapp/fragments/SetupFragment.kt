package com.example.runningtrackerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.databinding.ActivityMainBinding
import com.example.runningtrackerapp.databinding.FragmentSetupBinding
import com.google.android.material.snackbar.Snackbar

class SetupFragment : Fragment(R.layout.fragment_setup) {

    private lateinit var binding : FragmentSetupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetupBinding.inflate(inflater)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding.tvContinue.setOnClickListener {
            it.findNavController().navigate(R.id.action_setupFragment2_to_runFragment2)
        }
    }
}