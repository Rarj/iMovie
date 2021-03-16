package rio.arj.imovie.utils

import junit.framework.Assert.assertEquals
import org.junit.Test

class DateUtilsTest {

  @Test
  fun `should return date 16 Maret 2021`() {
    val dateFormatted = DateUtils().formatDate("dd MMMM yyy", "2021-03-16")
    assertEquals("16 Maret 2021", dateFormatted)
  }

  @Test
  fun `should return date 16 Mar 2021`() {
    val dateFormatted = DateUtils().formatDate("dd MMM yyy", "2021-03-16")
    assertEquals("16 Mar 2021", dateFormatted)
  }

}