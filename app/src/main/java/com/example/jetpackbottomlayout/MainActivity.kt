package com.example.jetpackbottomlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Handle Home item click
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_explore -> {
                    // Handle Explore item click
                    replaceFragment(ExploreFragment())
                    true
                }
                R.id.nav_settings -> {
                    // Handle Settings item click
                    replaceFragment(SettingsFragment())
                    true
                }
                R.id.nav_profile -> {
                    // Handle Profile item click
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        // Display the initial fragment on app launch
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
