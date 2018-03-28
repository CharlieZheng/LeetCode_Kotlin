package String

class _125 {
    private fun isDigital(c: Char): Boolean {
        val cInt = c.toInt()
        return cInt >= 48 && cInt <= 57
    }

    private fun isAlphanumeric(c: Char): Boolean {
        val cInt = c.toInt()
        return (cInt >= 65 && cInt <= 90) || (cInt >= 97 && cInt <= 122)
    }

    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) return true
        var left = 0
        var right = s.length - 1
        var result = true
        while (left < right) {
            if (!(isAlphanumeric(s[left]) || isDigital(s[left]))) {
                left++
                continue
            }
            if (!(isAlphanumeric(s[right]) || isDigital(s[right]))) {
                right--
                continue
            }

            if (s[left] == s[right] || (Math.abs(s[left] - s[right]) == 32 && isAlphanumeric(s[left]) && isAlphanumeric(s[right]))) {
                left++
                right--
            } else {
                result = false
                break
            }
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(_125().isPalindrome("6p"))
        }
    }
}