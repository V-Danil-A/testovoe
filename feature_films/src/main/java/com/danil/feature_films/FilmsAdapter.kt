package com.danil.feature_films

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danil.domain.Film
import com.danil.feature_films.databinding.ItemViewFilmBinding

class FilmsAdapter (
    private val onClick:(filmUrl: String)->Unit
): RecyclerView.Adapter<FilmsAdapter.FilmViewHolder>() {
    var listFilms: List<Film> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemBinding =
            ItemViewFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemBinding)
    }

    override fun getItemCount() = listFilms.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(listFilms[position])
    }

    inner class FilmViewHolder(private val binding: ItemViewFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(film: Film) {
                binding.filmNameText.text = film.title
                binding.directorText.text = film.director
                binding.producerText.text = film.producer
                binding.releaseDateText.text = film.releaseDate
                itemView.setOnClickListener {
                    onClick(film.filmUrl)
                }
            }

    }
}