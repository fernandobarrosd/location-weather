package com.fernando.locationweather.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fernando.locationweather.R
import com.fernando.locationweather.databinding.ActivityMainBinding
import com.fernando.locationweather.ui.adapters.WeatherItemAdapter
import com.fernando.locationweather.ui.viewmodels.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupViewCompat()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        initObservers()
        weatherViewModel.initWeathers()
    }

    private fun initObservers() {
        weatherViewModel.weathers.observe(this) { weathers ->
            val weatherItemAdapter = WeatherItemAdapter(weathers)
            binding?.weathersRecyclerview?.adapter = weatherItemAdapter
        }
    }

    private fun setupViewCompat() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}