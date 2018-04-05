package String

class _38 {
    fun countAndSay(n: Int): String {
        var temp = "1"
        if (n == 1) return temp
        var cnt = 0
        var stringBuilder = StringBuilder()
        while (cnt++ < n - 1) {
            stringBuilder = StringBuilder()
            val size = temp.length
            var lastInt = temp[0].toInt() - 48
            var num = 1




            for (i in 1 until size) {
                val c = temp[i]
                val curInt = c.toInt() - 48
                if (curInt == lastInt) {
                    num++


                } else {
                    stringBuilder.append(num).append(lastInt)
                    num = 1


                }
                lastInt = curInt
            }
            stringBuilder.append(num).append(lastInt)
            temp = stringBuilder.toString()

        }
        return stringBuilder.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_38().countAndSay(2))

            println('5'.toInt() - 48)
        }
    }
}