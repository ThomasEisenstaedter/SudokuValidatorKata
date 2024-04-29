fun validate(board: Array<Array<Int>>): Boolean {
    return when {
        !board.allLinesHaveUniqueNumbers() -> false
        !board.allLinesHaveOnlyOne1To9Sequence() -> false
        !board.allRowsValid() -> false
        !board.allColumnsAreUnique() -> false
        !board.allBoxesHaveValidNumbers() -> false
        else -> true
    }
}

fun Array<Array<Int>>.allRowsValid() = this.all { row -> row.isValid() }

fun Array<Int>.isValid() = this
    .all { number -> ("[1-9]".toRegex().matches(number.toString())) }

fun Array<Array<Int>>.allLinesHaveUniqueNumbers() = this.all { it.distinct().size == 9 }

fun Array<Array<Int>>.allLinesHaveOnlyOne1To9Sequence() = this.all {
    !it
        .contentEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
}

fun Array<Array<Int>>.allColumnsAreUnique(): Boolean {
    for (number in this.indices) {
        if (listOf(
                this[0][number],
                this[1][number],
                this[2][number],
                this[3][number],
                this[4][number],
                this[5][number],
                this[6][number],
                this[7][number],
                this[8][number],
            ).toSet().size != 9
        ) {
            return false
        }
    }
    return true
}

fun Array<Array<Int>>.allBoxesHaveValidNumbers(): Boolean {
    for (blockRow in 0..6 step 3) {
        for (number in this.indices step 3) {
            if (listOf(
                    this[0 + blockRow][number],
                    this[1 + blockRow][number],
                    this[2 + blockRow][number],
                    this[0 + blockRow][1 + number],
                    this[1 + blockRow][1 + number],
                    this[2 + blockRow][1 + number],
                    this[0 + blockRow][2 + number],
                    this[1 + blockRow][2 + number],
                    this[2 + blockRow][2 + number],
                ).toSet().size != 9
            ) {
                return false
            }
        }
    }
    return true
}