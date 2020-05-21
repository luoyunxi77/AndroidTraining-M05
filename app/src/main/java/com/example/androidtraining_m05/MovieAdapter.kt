package com.example.androidtraining_m05

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidtraining_m05.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        return holder.bind(movieList[position])
    }
}

class MovieHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(movie: Movie) {
        Glide.with(view.context).load("http://image.tmdb.org/t/p/w500${movie.posterPath}")
            .into(view.movie_image)
        view.movie_title.text = "Title: ${movie.title}"
        view.movie_overview.text = "Overview: ${movie.overview}"
        view.movie_rating.text = "Rating: ${movie.voteAverage}"
    }
}

class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = space
    }
}