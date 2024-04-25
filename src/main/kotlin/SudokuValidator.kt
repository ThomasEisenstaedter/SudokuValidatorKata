import com.sun.org.apache.xpath.internal.operations.Bool

fun validate(board: Array<Array<Int>>): Boolean {
      return when {
            board.all { it.distinct().size != 9 } -> false
            board.all { it.contentEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)) } -> false
            else -> true
      }
}
