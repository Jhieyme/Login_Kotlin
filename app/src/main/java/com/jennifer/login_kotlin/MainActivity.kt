package com.jennifer.login_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jennifer.login_kotlin.Fragments.FavoriteFragment
import com.jennifer.login_kotlin.Fragments.HomeFragment
import com.jennifer.login_kotlin.Fragments.SearchFragment
import com.jennifer.login_kotlin.Fragments.UserFragment
import com.jennifer.login_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_search -> {
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.bottom_add -> {
                    Toast.makeText(this, "Add new product" , Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.bottom_favorite -> {
                    replaceFragment(FavoriteFragment())
                    true
                }
                R.id.bottom_user -> {
                    replaceFragment(UserFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}