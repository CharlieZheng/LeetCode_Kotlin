package String

class _443 {
    private fun cnt1(i: Int): Int {
        var cnt = 1
        var j = i
        while (j >= 10) {
            j /= 10
            cnt++
        }
        return if (i == 1) 0 else cnt
    }

    private fun cnt2(i: Int): ArrayList<Char> {
        val result = ArrayList<Char>()
        var j = i
        while (j >= 10) {
            result.add((j % 10 + 48).toChar())
            j /= 10
        }
        result.add((j % 10 + 48).toChar())
        for (index in 0..(result.size / 2 - 1)) {
            val temp = result[result.size - index - 1]
            result[result.size - index - 1] = result[index]
            result[index] = temp
        }
        return if (result.size < 1 || (result.size <= 1 && result[0] == '1')) ArrayList() else result
    }

    fun compress(chars: CharArray): Int {
        var curCnt = 1
        var lastChar = chars[0]
        var result = 0
        val cp1 = CharArray(chars.size)
        var index = 0
        if (chars.size > 0)
            for (i in 1 until chars.size) {
                val item = chars[i]
                if (lastChar == item) {
                    curCnt++
                } else {
                    val count = cnt1(curCnt) + 1
                    cp1[index++] = lastChar
                    cnt2(curCnt).forEach {
                        cp1[index++] = it

                    }
                    result += count
                    curCnt = 1
                }
                lastChar = item
            }
        val count = cnt1(curCnt) + 1
        cp1[index++] = lastChar
        cnt2(curCnt).forEach {
            cp1[index++] = it
        }
        result += count
        val cp2 = CharArray(result)
        for (i in 0 until cp2.size) {
            cp2[i] = cp1[i]
        }
        cp2.forEach { println(it) }
        for (i in 0 until chars.size) {
            if (i < cp2.size)
                chars[i] = cp2[i]
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(_443().compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')))
        }
    }
}