package rio.arj.imovie.repository.list

import io.reactivex.Observable
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import rio.arj.imovie.repository.list.model.ListResponse
import rio.arj.imovie.repository.list.model.Result

class ListRepositoryImplTest {

  @Mock
  lateinit var repository: ListRepositoryImpl

  @Mock
  lateinit var result: Result

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)
  }

  @Test
  fun `fetch valid response from popular remote`() {
    val expectedResponse = ListResponse(results = arrayListOf(Result(1, "", "", "", "", 5.1)))
    var result = ListResponse(results = arrayListOf(result))

    `when`(repository.getPopular(1))
      .thenReturn(Observable.just(expectedResponse))

    repository.getPopular(1)
      .subscribe {
        result = it
      }

    assertEquals(expectedResponse, result)
  }

}