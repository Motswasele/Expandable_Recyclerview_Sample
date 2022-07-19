package com.example.expandable_recyclerview_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expandable_recyclerview_sample.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentViewPager()
    }

    private fun fragmentViewPager() {

        val fragment1 = AnimalsFragment()

        val pageAdapter = CustomPageAdapter(this)

        pageAdapter.addFragment(fragment1,"Animal One")

        binding.contentMain.viewPager.adapter = pageAdapter

        TabLayoutMediator(binding.contentMain.tabLayout, binding.contentMain.viewPager){tab, position ->
            tab.text = pageAdapter.getPageTitle(position)
        }.attach()
    }
}