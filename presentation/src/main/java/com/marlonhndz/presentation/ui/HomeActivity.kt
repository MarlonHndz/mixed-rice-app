package com.marlonhndz.presentation.ui

import androidx.navigation.fragment.NavHostFragment
import com.marlonhndz.presentation.R
import com.marlonhndz.presentation.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.home_nav_host_fragment

class HomeActivity : BaseNavActivity() {

    private lateinit var binding: ActivityHomeBinding

    override val navHostFragment: NavHostFragment
        get() = home_nav_host_fragment as NavHostFragment

    override fun setActivityView() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        defineStartDestination()
        setContentView(binding.root)
    }

    private fun defineStartDestination() {
        val graphInflater = navHostFragment.navController.navInflater
        val navGraph = graphInflater.inflate(R.navigation.home_nav_graph)
        val navController = navHostFragment.navController
        navGraph.startDestination = R.id.home_list_fragment

        navController.graph = navGraph
    }
}
