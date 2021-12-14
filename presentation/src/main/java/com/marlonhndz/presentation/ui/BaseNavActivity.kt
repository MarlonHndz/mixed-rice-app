package com.marlonhndz.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

abstract class BaseNavActivity : AppCompatActivity() {

    protected abstract val navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActivityView()
    }

    abstract fun setActivityView()
}
