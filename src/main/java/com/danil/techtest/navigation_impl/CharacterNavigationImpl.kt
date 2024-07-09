package com.danil.techtest.navigation_impl

import android.content.Context
import com.danil.navigation.CharacterNavigation
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class CharacterNavigationImpl@Inject constructor(
    @ActivityContext
    val activityContext: Context
) :BaseNavigatorImpl(activityContext), CharacterNavigation {
    override fun toBack() {
        navController().popBackStack()
    }
}