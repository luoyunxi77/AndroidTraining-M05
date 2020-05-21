package com.example.androidtraining_m05

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtraining_m05.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        invokeNetwork()
    }

    private fun invokeNetwork() {
        val request = ServiceBuilder.buildService(Endpoint::class.java)
        val call = request.getMovies(getString(R.string.api_key))

        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    progressBar.visibility = View.GONE
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(context)
                        adapter = MovieAdapter(
                            listOf(
                                response.body(),
                                response.body(),
                                response.body()
                            ) as List<Movie>
                        )
                        addItemDecoration(SpacesItemDecoration(60))
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                //todo
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT)
            }
        })
    }
}
