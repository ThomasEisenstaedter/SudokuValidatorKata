import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

fun validate(board: Array<Array<Int>>): Boolean {
      return when {
            board.all { it.distinct().size != 9 } -> false
            board.all { it.contentEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)) } -> false
            !onlyValidNumbers(board) -> false
            else -> true
      }
}

private fun onlyValidNumbers(board: Array<Array<Int>>) = board
      .all { row -> row.all { e -> ("[1-9]".toRegex().matches(e.toString()))}}






