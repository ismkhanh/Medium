package com.ik.navigationjetpack

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        //adding bottom navigation
        setUpBottomNavigation(navController)
    }

    private fun setUpBottomNavigation(navController: NavController) {
        bottom_navigation?.let {
            Navigation.setViewNavController(it, navController)

            it.setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_first_fragment -> {
                        navController.navigate(R.id.firstFragment, null)
                        true
                    }

                    R.id.menu_second_fragment -> {
                        navController.navigate(R.id.secondFragment, null)
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }

    }

    /**
     * Handling back button
     */
    override fun onNavigateUp() = navController.navigateUp()
}
