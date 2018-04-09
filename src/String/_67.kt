package String

class _67 {
    fun addBinary(a: String, b: String): String {
        val __M__ = 2
        val sizeA = a.length
        val sizeB = b.length
        val result = StringBuffer()
        if (sizeA >= sizeB) {
            var sizeAA = sizeA - 1
            var sizeBB = sizeB - 1
            var left = 0
            while (sizeBB >= 0) {
                val sum = a[sizeAA].toInt() + b[sizeBB].toInt() - 48 * 2 + left
                if (sum >= __M__) {
                    result.append(sum % __M__)
                    left = sum / __M__
                } else {
                    result.append(sum)
                    left = 0
                }
                sizeAA--
                sizeBB--
            }
            while (sizeAA >= 0) {
                val sum = a[sizeAA].toInt() - 48 + left
                if (sum >= __M__) {

                    result.append(sum % __M__)
                    left = sum / __M__
                } else {
                    result.append(sum)
                    left = 0
                }
                sizeAA--
            }
            if (left > 0) result.append(left)
        } else {
            return addBinary(b, a)
        }
        val size = result.length
        for (i in 0 until size / 2) {
            val temp = result[i]
            result.setCharAt(i, result[size - 1 - i])
            result.setCharAt(size - 1 - i, temp)
        }
        return result.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_67().addBinary("0", "0"))

        }
    }
}