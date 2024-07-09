package com.danil.feature_character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.danil.feature_character.databinding.FragmentCharacterScreenBinding
import com.danil.navigation.CharacterNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val FILM_URL_KEY = "FILM_URL"

@AndroidEntryPoint
class CharacterScreenFragment : Fragment() {
    private val viewModel: CharacterScreenViewModel by viewModels()
    private var _binding: FragmentCharacterScreenBinding? = null
    private val binding get() = _binding!!

    private var filmUrl: String = ""

    @Inject
    lateinit var characterNavigation: CharacterNavigation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            filmUrl = it.getString(FILM_URL_KEY, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterScreenBinding.inflate(inflater, container, false)
        setClickListenerForBackButton()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFilmByUrl(filmUrl)
        collectViewState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

    private fun renderViewState(state: CharacterScreenState) {
        binding.filmName.text = state.filmName
    }

    private fun setClickListenerForBackButton() {
        binding.btnBack.setOnClickListener {
            characterNavigation.toBack()
        }
    }

}