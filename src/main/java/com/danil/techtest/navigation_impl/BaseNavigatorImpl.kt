package com.danil.techtest.navigation_impl

import android.app.Activity
import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.danil.techtest.R

abstract class BaseNavigatorImpl(private val activityContext: Context) {
    fun navController() : NavController {
        return (activityContext as Activity).findNavController(R.id.main_fragment_container)
    }
}