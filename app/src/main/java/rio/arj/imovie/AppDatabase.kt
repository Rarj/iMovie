package rio.arj.imovie

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import rio.arj.imovie.repository.favorite.dao.DetailMovieDao
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

@Database(
  entities = [DetailMovieEntity::class],
  version = 1
)
abstract class AppDatabase : RoomDatabase() {

  abstract fun detailMovieDao(): DetailMovieDao

  companion object {
    var INSTANCE: AppDatabase? = null

    fun getAppDataBase(context: Context): AppDatabase? {
      if (INSTANCE == null) {
        synchronized(AppDatabase::class) {
          INSTANCE =
            Room.databaseBuilder(
              context.applicationContext,
              AppDatabase::class.java, "Favorite.db"
            ).build()
        }
      }
      return INSTANCE
    }
  }

}