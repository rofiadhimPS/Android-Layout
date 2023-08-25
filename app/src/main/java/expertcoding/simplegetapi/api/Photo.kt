package expertcoding.simplegetapi.api

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Photo(
    @PrimaryKey val id: Int,
    val title: String,
    val url: String
)
