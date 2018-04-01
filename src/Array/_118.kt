package Array

class _118 {
    fun generate(numRows: Int): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        if (numRows == 0) return result
        var index = 0
        var row = ArrayList<Int>()
        val lastRow = ArrayList<Int>()
        row.add(1)
        result.add(row)
        var rowSize = 0
        while (++index < numRows) {
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
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _118()
            val result = o.generate(20)
            result.forEachIndexed { index, list ->

                val stringBuilder = StringBuilder()
                stringBuilder.append(index + 1).append(": ")
                list.forEach {
                    stringBuilder.append(it).append(",")
                }
                println(stringBuilder)
            }
        }
    }
}