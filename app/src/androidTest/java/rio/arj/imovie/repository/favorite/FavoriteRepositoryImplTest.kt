package rio.arj.imovie.repository.favorite

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertTrue
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import rio.arj.imovie.AppDatabase
import rio.arj.imovie.MovieApplication
import rio.arj.imovie.repository.favorite.dao.DetailMovieDao
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

@RunWith(AndroidJUnit4::class)
class FavoriteRepositoryImplTest {

  private var detailMovieDao: DetailMovieDao? = null

  @Before
  fun setUp() {
    detailMovieDao =
      AppDatabase.getAppDataBase(
        ApplicationProvider.getApplicationContext<MovieApplication>()
      )?.detailMovieDao()
  }

  @Test
  fun insert_favorite() {
    val detail = DetailMovieEntity(2, "", "", "", "", 10.0)
    detailMovieDao?.addToFavorite(detail)
    val isNotEmpty = detailMovieDao?.getMovieById(2)?.isNotEmpty()

    assertEquals(true, isNotEmpty)
  }

  @Test
  fun find_movie_by_id() {
    val detail = DetailMovieEntity(22, "", "", "", "", 10.0)
    detailMovieDao?.addToFavorite(detail)

    val isNotEmpty = detailMovieDao?.getMovieById(detail.id)?.isNotEmpty()
    assertEquals(true, isNotEmpty)
  }

  @Test
  fun success_delete_favorite_movie_by_id() {
    val detail = DetailMovieEntity(222, "", "", "", "", 10.0)
    detailMovieDao?.addToFavorite(detail)

    detailMovieDao?.deleteMovieById(detail.id)
    val isEmpty = detailMovieDao?.getMovieById(detail.id)?.isEmpty()
    assertTrue(isEmpty == true)
  }

}