package Hash_Table

// NO AC
class _205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        var index1 = 0
        val map1 = HashMap<Char, Int>()

        var newS1 = ""
        var index2 = 0
        val map2 = HashMap<Char, Int>()
        var newS2 = ""
        for (i in 0 until s.length) {
            val item1 = s[i]
            val item2 = t[i]
            var b1 = false
            var b2 = false
            if (map1.containsKey(item1)) {
                newS1 += map1[item1].toString()
                b1 = true
            }
            if (map2.containsKey(item2)) {
                newS2 += map2[item2].toString()
                b2 = true
            }
            if (!b1) {
                newS1 += index1.toString()
                map1.put(item1, index1++)
            }
            if (!b2) {
                newS2 += index2.toString()
                map2.put(item2, index2++)
            }
            if (!newS1.equals(newS2)) return false
        }


        return newS1.equals(newS2)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_205().isIsomorphic("egg8990", "add0887"))
        }
    }
}