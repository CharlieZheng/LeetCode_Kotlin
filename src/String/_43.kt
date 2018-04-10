package String

class _43 {
    fun addBinary(a: String, b: String): String {
        val __M__ = 10
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

    fun multiply(num1: String, num2: String): String {
        val size1 = num1.length
        val size2 = num2.length
//        var size1_ = size1
        var i2 = size2 - 1
        var sum = "0"
        if (size1 >= size2) {
            while (i2 >= 0) {
                for (i in size1 - 1 downTo 0) {
                    val firstNum = (num2[i2].toInt() - 48).times(num1[i].toInt() - 48)
                    if (firstNum > 0) {
                        val temp = StringBuffer().append(firstNum)
                        for (j in 0 until size1 - 1 - i + size2 - 1 - i2) {
                            temp.append(0)
                        }

                        sum = addBinary(sum, temp.toString())
                    }
                }
                i2--
            }
        } else {
            return multiply(num2, num1)
        }
        return sum
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_43().multiply("43", "2045"))
            println(_43().addBinary("534", "535"))
            println('5'.toInt() - 48)
        }
    }
}