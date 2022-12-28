package com.natcho.weatherapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.natcho.weatherapp.databinding.FragmentHomeBinding
import com.natcho.weatherapp.extensions.toPx
import com.natcho.weatherapp.ui.WeatherBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : WeatherBaseFragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTopPadding()

        binding.btnRefresh.setOnClickListener {
            viewModel.loadCurrentWeatherInfo()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        viewModel.weatherUiState.observe(viewLifecycleOwner) {
            when (it) {
                is WeatherUiState.Loading -> {
                    Log.v("WeatherApp", "Loading")
                }
                is WeatherUiState.Success -> {
                    Log.v("WeatherApp", "Success, weatherInfo: ${it.weatherInfo}")
                    binding.tvWeatherInfo.text = it.weatherInfo.toString()
                }
                is WeatherUiState.Error -> {
                    Log.v("WeatherApp", "Error")
                }
            }
        }
    }

    private fun setTopPadding() {
        val statusBarHeight = resources.getDimensionPixelSize(
            resources.getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            )
        )
        binding.clTop.setPadding(
            binding.clTop.paddingLeft,
            statusBarHeight + 16.toPx,
            binding.clTop.paddingRight,
            binding.clTop.paddingBottom
        )
    }
}