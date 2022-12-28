package com.natcho.weatherapp.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.natcho.weatherapp.databinding.ActivityMainBinding
import com.natcho.weatherapp.extensions.toPx
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableFullscreen()
    }

    private fun enableFullscreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            val insects = window.decorView.rootView.rootWindowInsets
//            val statusBarHeight = insects.systemWindowInsetTop
//            Log.v("WA", "enableFullscreen # statusBarHeight: $statusBarHeight")
//
//            binding.weatherContainer.bottom = statusBarHeight
//        }

//        val statusBarHeight = resources.getDimensionPixelSize(
//            resources.getIdentifier(
//                "status_bar_height",
//                "dimen",
//                "android"
//            )
//        )
//        binding.myNavHostFragment.setPadding(
//            binding.myNavHostFragment.paddingLeft,
//            statusBarHeight + 16.toPx,
//            binding.myNavHostFragment.paddingRight,
//            binding.myNavHostFragment.paddingBottom
//        )

    }

//    private fun enableFullscreen() {
//        window.decorView.systemUiVisibility = (
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
//        window.statusBarColor = Color.TRANSPARENT
//    }

//    private fun enableFullscreen() {
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
//    }
}