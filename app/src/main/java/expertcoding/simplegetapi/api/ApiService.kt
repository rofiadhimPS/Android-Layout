package expertcoding.simplegetapi.api

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class ApiService(context: Context) {
    private val queue: RequestQueue = Volley.newRequestQueue(context)
    private val baseUrl = "https://jsonplaceholder.typicode.com"

    fun getPhotos(callback: (List<Photo>) -> Unit) {
        val url = "$baseUrl/photos"

        val request = JsonArrayRequest(Request.Method.GET, url, null,
            { response ->
                val photos = Gson().fromJson(response.toString(), Array<Photo>::class.java).toList()
                callback(photos)
            },
            { error ->
                Log.e("ApiService", "Error: ${error.message}")
            }
        )

        queue.add(request)
    }
}
