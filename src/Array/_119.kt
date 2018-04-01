package Array

class _119 {
    fun getRow(rowIndex: Int): List<Int> {
        var rowIndex2 = rowIndex + 1

        var row = ArrayList<Int>()
        val result = ArrayList<ArrayList<Int>>()
        if (rowIndex2 == 0) return row
        var index = 0
        val lastRow = ArrayList<Int>()
        row.add(1)
        result.add(row)
        var rowSize = 0
        while (++index < rowIndex2) {
            lastRow.clear()
            lastRow.addAll(result.get(result.size - 1))
            row = ArrayList<Int>()
            row.add(1)
            rowSize = lastRow.size

            lastRow.forEachIndexed { index, i ->
                if (index == rowSize - 1) {

                    row.add(1)
                } else {
                    row.add(i + lastRow[index + 1])

                }
            }
            result.add(row)
        }
        return row
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _119()
            val result = o.getRow(20)
            result.forEachIndexed { index, list ->


                print(list.toString() + " ")
            }
        }
    }
}