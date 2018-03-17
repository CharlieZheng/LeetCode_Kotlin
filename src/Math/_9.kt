package Math

class _9 {
    fun isPalindrome(array: ArrayList<Char>): Boolean {
        for (i in 0 until array.size) {
            if (array[i] != array[array.size - 1 - i]) return false
        }
        return true
    }

    fun isPalindrome(x: Int): Boolean {
        val array = ArrayList<Char>()
        var xx = x
        while (xx >= 10) {
            array.add((xx % 10).toChar())
            xx = xx / 10
        }
        array.add(xx.toChar())
        return isPalindrome(array)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(_9().isPalindrome(3343))
        }
    }
}