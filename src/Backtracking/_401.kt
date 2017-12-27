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

    fun readBinaryWatch(num: Int): List<String> {

        val list = ArrayList<Set<E>>()
        E.values().forEach {
              val set = HashSet<E>()
            set.add(it)
            list.add(set)
        }
        return ArrayList<String>()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

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