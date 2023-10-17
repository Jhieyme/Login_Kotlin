package com.jennifer.login_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.jennifer.login_kotlin.Fragments.CategoryFragment
import com.jennifer.login_kotlin.Fragments.CustomerFragment
import com.jennifer.login_kotlin.Fragments.FavoriteFragment
import com.jennifer.login_kotlin.Fragments.HomeFragment
import com.jennifer.login_kotlin.Fragments.PrintFragment
import com.jennifer.login_kotlin.Fragments.SearchFragment
import com.jennifer.login_kotlin.Fragments.UserFragment
import com.jennifer.login_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.open_nav, R.string.close_nav)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment(HomeFragment())
                R.id.bottom_search -> openFragment(SearchFragment())
                R.id.bottom_favorite -> openFragment(FavoriteFragment())
                R.id.bottom_user-> openFragment(UserFragment())
            }
            true
        }

        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())

        binding.fab.setOnClickListener{
            Toast.makeText(this, "add", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> openFragment(HomeFragment())
            R.id.nav_category -> openFragment(CategoryFragment())
            R.id.nav_customer -> openFragment(CustomerFragment())
            R.id.nav_print -> openFragment(PrintFragment())
            R.id.nav_logout -> Toast.makeText(this,"Logout", Toast.LENGTH_SHORT).show()

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.getOnBackPressedDispatcher().onBackPressed()
        }
        super.onBackPressed()
    }
    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}