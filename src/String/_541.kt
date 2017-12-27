package String

class _541 {
    fun reverseStrBefore(s: String, start: Int, end: Int): String {
        val sArray = s.toCharArray()
        for (i in start until start + (end - start) / 2 + 1) {
            val temp = sArray[start + end - i]
            sArray[start + end - i] = sArray[i]
            sArray[i] = temp
        }
        return String(sArray)
    }

    fun reverseStr(s: String, k: Int): String {
        var index = 0
        var m = s
        while (index < m.length && index + k - 1 < m.length) {
            m = reverseStrBefore(m, index, index + k - 1)
            index += 2 * k
        }
        if (index < m.length) {
            m = reverseStrBefore(m, index, m.length - 1)
        }
        return m
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_541().reverseStr("abcdefg", 2))
            // cbadjgerkjgkwerleegf
        }
    }
}