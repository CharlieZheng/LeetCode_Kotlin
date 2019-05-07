package Hash_Table

class _49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = ArrayList<ArrayList<String>>()
        val all = ArrayList<ArrayList<Char>>()
        val noContains = { item: String ->
            val allItem = ArrayList<Char>()
            item.forEach {

                allItem.add(it)
            }
            all.add(allItem)
            val resultItem = ArrayList<String>()
            resultItem.add(item)
            result.add(resultItem)
        }
        for (i in 0 until strs.size) {
            val item = strs[i]
            if (all.isEmpty()) {
                noContains(item)
            } else {
                var contains = true
                val jkj = jkj@{
                    all.forEachIndexed { index, it ->
                        contains = true
                        it.sort()
                        val itemArray = item.toCharArray()
                        itemArray.sort()
                        it.forEachIndexed fjekj@{ index, c ->
                            if (index >= itemArray.size) {
                                contains = false
                                return@fjekj
                            }
                            if (itemArray[index] != c) {
                                contains = false
                                return@fjekj
                            }

                        }
                        if (item.length != it.size) {
                            contains = false
                        }
                        if (contains) {
                            if (index >= result.size) throw     Exception("越界")
                            result[index].add(item)
                            return@jkj
                        }
                    }
                }
                jkj()
                if (!contains) {
                    noContains(item)
                }
            }
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = _49().groupAnagrams(arrayOf())
            result.forEach {
                it.forEach {
                    print("$it\t")
                }
                println()
            }
        }
    }
}