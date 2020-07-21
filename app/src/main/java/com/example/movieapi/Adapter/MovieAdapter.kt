package com.example.movieapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi.R
import com.example.movieapi.databinding.MovieItemBinding
import com.example.movieapi.model.MovieModel

class MovieAdapter(
    private val movies: List<MovieModel>,
    private var listener: OnItemClickListener
) :
    RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    override fun getItemCount(): Int = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.movieItemBinding.movie = movies[position]
        holder.movieItemBinding.root.setOnClickListener {
            listener.onItemClick(holder.movieItemBinding.root, movies[position])
        }
    }


    inner class MoviesViewHolder(val movieItemBinding: MovieItemBinding) :
        RecyclerView.ViewHolder(movieItemBinding.root)


    interface OnItemClickListener {
        fun onItemClick(view: View, movie: MovieModel)
    }


}