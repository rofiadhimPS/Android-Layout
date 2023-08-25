package expertcoding.simplegetapi.db

import androidx.room.Database
import androidx.room.RoomDatabase
import expertcoding.simplegetapi.api.Photo
import expertcoding.simplegetapi.db.PhotoDao

@Database(entities = [Photo::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}
