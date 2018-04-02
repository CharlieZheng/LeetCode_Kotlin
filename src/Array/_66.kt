package Array

class _66 {
    fun plusOne(digits: IntArray): IntArray {
        var size = digits.size - 1

        if (size >= 0)
            digits[size] = digits[size] + 1
        while (size > 0) {
            var small = digits[size]
            var big = 0
            if (small > 9) {
                big = small / 10
                small = small % 10
            }
            digits[size] = small
            digits[size - 1] += big
            size--
        }
        size = digits.size
        if (digits[0] > 9) {
            val first = digits[0] / 10
            val second = digits[0] % 10
            val result = IntArray(size + 1)
            digits.forEachIndexed { index, i ->
                result[index + 1] = digits[index]
            }
            result[0] = first
            result[1] = second
            return result
        } else {
            return digits
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _66()
            o.plusOne(kotlin.IntArray(1, { it -> 0 })).forEach {
                print(it.toString() + "\t")
            }

        }
    }
}