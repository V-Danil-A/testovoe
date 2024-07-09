package com.danil.techtest.navigation_impl

import android.content.Context
import android.os.Bundle
import com.danil.navigation.FilmsNavigation
import com.danil.techtest.R
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class FilmsNavigationImpl @Inject constructor(
@ActivityContext
val activityContext: Context
) : BaseNavigatorImpl(activityContext), FilmsNavigation {
    override fun goToCharacterScreen(filmUrl: String) {
        val bundle = Bundle()
        bundle.putString("FILM_URL", filmUrl)
        navController().navigate(R.id.action_filmsScreenFragment_to_characterScreenFragment, bundle)
    }

}