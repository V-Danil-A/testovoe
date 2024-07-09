package com.danil.feature_films

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.danil.domain.Film
import com.danil.feature_films.databinding.FragmentFilmsScreenBinding
import com.danil.navigation.FilmsNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FilmsScreenFragment : Fragment() {
    private val viewModel: FilmsScreenViewModel by viewModels()

    @Inject
    lateinit var filmsNavigation: FilmsNavigation

    private lateinit var binding: FragmentFilmsScreenBinding
    private lateinit var adapterListFilms: FilmsAdapter

    private val flowListFilms: MutableStateFlow<List<Film>> = MutableStateFlow(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmsScreenBinding.inflate(inflater, container, false)
        initRecyclerFilms()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectListFilms()
        collectViewState()
        addTextChangedListenerForSearch()
        addSwipeRefreshListener()
        viewModel.screenReady()
    }

    private fun collectViewState() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.viewState.collect {
                    renderViewState(it)
                }
            }
        }
    }

    private fun collectListFilms() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                flowListFilms.collect {
                    adapterListFilms.listFilms = it
                }
            }
        }
    }

    private suspend fun renderViewState(state: FilmsScreenState) {
        flowListFilms.emit(state.listFilms)
        binding.swipeRefresh.isRefreshing = state.isLoading
        binding.searchEditText.isEnabled = !state.isLoading
        binding.listFilms.isEnabled = !state.isLoading
    }



    private fun initRecyclerFilms() {
        adapterListFilms = FilmsAdapter {
            filmsNavigation.goToCharacterScreen(it)
        }
        binding.listFilms.adapter = adapterListFilms
    }

    private fun addTextChangedListenerForSearch() {
        binding.searchEditText.addTextChangedListener {
            viewModel.searchFilmsByQuery(it.toString().trim())
        }
    }

    private fun addSwipeRefreshListener() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refreshFilms()
        }
    }

}