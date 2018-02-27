package Backtracking

class _401 {
    enum class E(val num: Int, val type: Char) {
        _1(1, 'h'),
        _2(2, 'h'),
        _3(4, 'h'),
        _4(8, 'h'),
        _5(1, 's'),
        _6(2, 's'),
        _7(4, 's'),
        _8(8, 's'),
        _9(16, 's'),
        _10(32, 's')
    }

    private fun end(num: Int, temp: StringBuffer): Boolean {
        val size = temp.length
        for (i in 0 until num) {
            if (temp[size - 1 - i] == '0') return false
        }
        return true
    }

    fun readBinaryWatch(num: Int): List<String> {
        val list = ArrayList<String>()
        val temp = StringBuffer()
        var numTemp = num
        val size = E.values().size
        for (i in 0 until size) {
            temp.append(if (numTemp-- > 0) '1' else '0')
        }
        val eList = arrayListOf<E>()



        eList.clear()
        for (i in 0 until size) {
            if (temp[i] == '1') eList.add(E.values()[i])
        }
        var h = 0
        var m = 0
        eList.forEach {
            when (it.type) {
                'h' -> {
                    h += it.num
                }
                's' -> {
                    m += it.num
                }
            }
        }
        if (h >= 12 || m > 59) {
        } else if (m.toString().length < 2) {
            list.add(h.toString() + ":0" + m.toString())
        } else {
            list.add(h.toString() + ":" + m.toString())

        }
        while (!end(num, temp)) {
            val index = temp.indexOf("10")

            temp.replace(index, index + 2, "01")

            val cnt = StringBuffer()
            for (i in 0 until index) {
                if (temp[i] == '1') cnt.append('1')
            }
            if (!cnt.isNullOrEmpty()) {
                while (cnt.length < index) {
                    cnt.append('0')
                }
                temp.replace(0, index, cnt.toString())
            }

            println(temp)

            eList.clear()
            for (i in 0 until size) {
                if (temp[i] == '1') eList.add(E.values()[i])
            }


            h = 0
            m = 0
            eList.forEach {
                when (it.type) {
                    'h' -> {
                        h += it.num
                    }
                    's' -> {
                        m += it.num
                    }
                }
            }
            if (h >= 12 || m > 59) {
            } else if (m.toString().length < 2) {
                list.add(h.toString() + ":0" + m.toString())
            } else {
                list.add(h.toString() + ":" + m.toString())

            }
        }
        return list
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cgf = _401()
            val list = cgf.readBinaryWatch(2)
            list.forEach {
                print(it + "\t")
            }
        }
    }

    /*
        1           2           3               4
    1              (1, 2)       (1, 3)          (1, 4)
    2                           (2, 3)          (2, 4)
    3                                           (3, 4)
    4


        (1, 2)  (1, 3)  (1, 4)   (2, 3)         (2, 4)      (3, 4)
    1                            (1, 2, 3)      (1, 2, 4)   (1, 3, 4)
    2                                                       (2, 3, 4)
    3
    4



        1           2           3               4           5
    1               (1, 2)      (1, 3)          (1, 4)      (1, 5)
    2                           (2, 3)          (2, 4)      (2, 5)
    3                                           (3, 4)      (3, 5)
    4                                                       (4, 5)
    5


        (1, 2)  (1, 3)  (1, 4)  (1, 5)      (2, 3)         (2, 4)       (2, 5)           (3, 4)          (3, 5)                  (4, 5)
    1                                       (1, 2, 3)      (1, 2, 4)    (1, 2, 5)        (1, 3, 4)       (1, 3, 5)               (1, 4, 5)
    2                                                                                    (2, 3, 4)       (2, 3, 5)               (2, 4, 5)
    3                                                                                                                            (3, 4, 5)
    4
    5

    */

}