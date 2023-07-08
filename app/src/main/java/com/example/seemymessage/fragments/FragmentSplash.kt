package com.example.seemymessage.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.navigation.fragment.findNavController
import com.example.seemymessage.R
import com.example.seemymessage.databinding.FragmentSplashBinding

class FragmentSplash : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.max = 1000

        val animation = ObjectAnimator.ofInt(binding.progressBar, "progress", binding.progressBar.max)

        animation.duration = 3000
        animation.start()
        animation.doOnEnd { findNavController().navigate(R.id.action_fragmentSplash_to_fragmentMenu) }

    }

}