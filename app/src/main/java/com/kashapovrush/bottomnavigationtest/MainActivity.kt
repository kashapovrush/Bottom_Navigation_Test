package com.kashapovrush.bottomnavigationtest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kashapovrush.bottomnavigationtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

        binding.bottomNavView.setupWithNavController(navController)
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    Log.d("MainActivityTest", "selected homeFragment")
                    true
                }
                R.id.searchFragment -> {
                    Log.d("MainActivityTest", "selected searchFragment")
                    true
                }
                R.id.profileFragment -> {
                    Log.d("MainActivityTest", "selected profileFragment")
                    true
                }

                else -> {false}
            }
        }

        binding.bottomNavView.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    Log.d("MainActivityTest", "reselected homeFragment")
                }
                R.id.searchFragment -> {
                    Log.d("MainActivityTest", "reselected searchFragment")
                }
                R.id.profileFragment -> {

                    Log.d("MainActivityTest", "reselected profileFragment")
                }

                else -> {}
            }
        }

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if (destination.id == R.id.homeFragment ||
//                destination.id == R.id.searchFragment || destination.id == R.id.profileFragment
//            ) {
//                navController.currentBackStackEntry?.savedStateHandle?.apply {
//                    set("shouldPopToRoot", false)
//                }
//            } else {
//                navController.currentBackStackEntry?.savedStateHandle?.apply {
//                    set("shouldPopToRoot", true)
//                }
//            }
//        }
    }

}
