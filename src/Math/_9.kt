package Math

class _9 {
    private fun isPalindrome(array: ArrayList<Int>): Boolean {
        for (i in 0 until array.size) {
            if (array[i] != array[array.size - 1 - i]) return false
        }
        return true
    }

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val array = ArrayList<Int>()
        var xx = x
        while (xx >= 10) {
            array.add(xx % 10)
            xx = xx / 10
        }
        array.add(xx)
        return isPalindrome(array)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(_9().isPalindrome(-324))
        }
    }
}