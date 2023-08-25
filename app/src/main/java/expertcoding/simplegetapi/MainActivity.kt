package expertcoding.simplegetapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import expertcoding.simplegetapi.adapter.PhotoAdapter
import expertcoding.simplegetapi.api.ApiService

class MainActivity : AppCompatActivity() {

    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.photoRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        photoAdapter = PhotoAdapter(emptyList())
        recyclerView.adapter = photoAdapter

        apiService = ApiService(this)

        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        apiService.getPhotos { photos ->
            Log.d("PhotoApp", "Total Photos: ${photos.size}")
            photoAdapter = PhotoAdapter(photos)
            val recyclerView = findViewById<RecyclerView>(R.id.photoRecyclerView)
            recyclerView.adapter = photoAdapter // Mengatur adapter dengan data baru
            photoAdapter.notifyDataSetChanged() // Memperbarui tampilan RecyclerView
        }
    }
}
