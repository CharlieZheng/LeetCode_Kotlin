class Test {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val list = ArrayList<Int>()
            list.add(4)
            list.add(90)
            list.apply { filter { it < 70 }.forEach { println(it) } }
            list.forEach { println(it) }
        }
    }
}