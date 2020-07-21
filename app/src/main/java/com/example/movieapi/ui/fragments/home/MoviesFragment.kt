package com.example.movieapi.ui.fragments.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapi.Adapter.MovieAdapter
import com.example.movieapi.R
import com.example.movieapi.data.BaseFragment
import com.example.movieapi.api.MovieApiInterface
import com.example.movieapi.repositries.MoviesRepository
import com.example.movieapi.databinding.MoviesFragmentBinding
import com.example.movieapi.model.MovieModel
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment :
    BaseFragment<MoviesFragmentBinding, MoviesViewModel, MoviesViewModelFactory>(),
    MovieAdapter.OnItemClickListener {

    override fun getFragmentView(): Int = R.layout.movies_fragment

    override fun getViewModel(): Class<MoviesViewModel> = MoviesViewModel::class.java

    override fun getViewModelFactory(): MoviesViewModelFactory =
        MoviesViewModelFactory(
            MoviesRepository(MovieApiInterface())
        )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.progress.visibility = View.VISIBLE

        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            mainRecycler.apply {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = MovieAdapter(movies, this@MoviesFragment)
                binding.progress.visibility = View.GONE
            }
        })
    }

    override fun onItemClick(view: View, movie: MovieModel) {
        when (view.id) {
            R.id.movieItemRoot -> {
                Toast.makeText(requireContext(), movie.title, Toast.LENGTH_SHORT).show()
            }
        }
    }

}