package Others

class _482 {
    fun licenseKeyFormatting(S: String, K: Int): String {
        var s = ""
        val list = S.split("-")
        var sum = 0
        list.forEach {
            sum += it.length
        }
        var subSize = sum % K
        var startIndex: Int
        for (i in 0 until list.size) {
            val item = list[i]
            startIndex = 0
            while (item.length > startIndex) {
                if (item.length >= subSize + startIndex) {
                    s += item.substring(startIndex, subSize + startIndex).toUpperCase() + "-"
                    startIndex = subSize + startIndex
                    subSize = K
                } else {
                    s += item.substring(startIndex, item.length).toUpperCase()
                    subSize = subSize - (item.length - startIndex)
                    break
                }
            }
        }
        if (s.endsWith('-')) s = s.substring(0, s.length - 1)
        if (s.startsWith('-')) s = s.substring(1, s.length)
        return s
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_482().licenseKeyFormatting("2-4A0r7-4k", 3))
//            print("243".substring(1, 3))
        }
    }
}