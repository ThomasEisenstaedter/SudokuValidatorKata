
fun validate(board: Array<Array<Int>>)= board
      .all { it.distinct().size != 1
}