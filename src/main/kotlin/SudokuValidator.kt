import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

fun validate(board: Array<Array<Int>>): Boolean {
      return when {
            board.all { it.distinct().size != 9 } -> false
            board.all { it.contentEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)) } -> false
            notOnlyValidNumbers(board) -> false
            duplicateValuesInColumns(board) -> false
            else -> true
      }
}

private fun notOnlyValidNumbers(board: Array<Array<Int>>) : Boolean {
    if (board.all { row ->
            row
                .all { number -> ("[1-9]".toRegex().matches(number.toString())) }
        }) {
        return false
    }
    return true
}

private fun duplicateValuesInColumns(board: Array<Array<Int>>): Boolean {
            for (number in board.indices) {
                println(number)
                  if(listOf(
                          board[0][number],
                          board[1][number],
                          board[2][number],
                          board[3][number],
                          board[4][number],
                          board[5][number],
                          board[6][number],
                          board[7][number],
                          board[8][number],
                 ).toSet().size !=9) {
                        return true
                 }
            }
      return false
}



