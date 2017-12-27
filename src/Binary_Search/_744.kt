package Binary_Search

class _744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        letters.sort()
        letters.forEach {
            if (it.toInt() > target.toInt()) return it
        }
        return letters[0]
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(_744().nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'c'))
        }
    }
}