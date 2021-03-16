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
    val expectedResponse = ListResponse(results = listOf(result))
    val result = ListResponse(results = listOf(result))

    `when`(repository.getPopular())
      .thenReturn(Observable.just(expectedResponse))

    assertEquals(expectedResponse, result)
  }

}