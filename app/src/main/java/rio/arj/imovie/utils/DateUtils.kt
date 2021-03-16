package rio.arj.imovie.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {

  fun formatDate(pattern: String, date: String): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
    val convertedDate = formatter.parse(date)

    return SimpleDateFormat(pattern, Locale("in", "ID")).format(convertedDate ?: Date())
  }

}