package Two_Pointers

class _28 {

    fun strStr(haystack: String, needle: String): Int {
        val size1 = haystack.length
        val size2 = needle.length
        if (size1 < size2) return -1
        if (size1 == 0 && size2 == 0) return 0
        var found = true
        for (index in 0 until size1) {
            if (index + size2 - 1 > size1 - 1) break
            found = true
            for (i in 0 until size2) {
                if (needle[i] != haystack[index + i]) {
                    found = false
                    break
                }
            }
            if (found) return index else continue
        }
        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_28().strStr("mississippi",
                    "sippia"))
        }
    }
}