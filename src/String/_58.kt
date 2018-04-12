package String

class _58 {
    fun lengthOfLastWord(s: String): Int {
        val size = s.length
        var result = 0
        var b = false
        for (i in size - 1 downTo 0) {
            if (s[i] == ' ') {
                if (b)
                    return result

            } else {
                b = true
                result++
            }

        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_58().lengthOfLastWord("fjejffjek   efe "))

        }
    }
}