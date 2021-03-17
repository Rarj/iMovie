package rio.arj.imovie

import android.app.Application

class MovieApplication : Application() {

  var database: AppDatabase? = null

  override fun onCreate() {
    super.onCreate()

    database = AppDatabase.getAppDataBase(this)
  }

}