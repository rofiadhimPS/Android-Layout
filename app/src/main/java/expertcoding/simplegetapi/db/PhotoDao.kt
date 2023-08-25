package expertcoding.simplegetapi.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import expertcoding.simplegetapi.api.Photo

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photo")
    fun getAllPhotos(): LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photos: List<Photo>)
}
