package Hash_Table

class _3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        val set = HashSet<Char>()
        for (i in 0 until s.length) {
            set.clear()
            for (j in i until s.length) {
                if (!set.contains(s[j])) {
                    set.add(s[j])
                } else {
                    break
                }
            }
            if (set.size > max) {
                max = set.size
            }
        }
        return max
    }

    companion object {


        @JvmStatic
        fun main(args: Array<String>) {
            val o = _3()
            print(o.lengthOfLongestSubstring("d"))
        }
    }
}