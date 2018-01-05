package Stack

import java.util.*

class _20 {
    private fun b(c1: Char, c2: Char): Boolean {
        when (c1) {
            '[' -> {
                return c2 == ']'
            }
            '{' ->
                return c2 == '}'
            '(' -> return c2 == ')'
        }
        return false
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        if (s.length > 0) stack.push(s[0])
        for (i in 1 until s.length) {
            if (stack.isEmpty()) {
                stack.push(s[i])
                continue
            }
            val item = stack[stack.size - 1]
            if (b(item, s[i])) stack.pop()
            else stack.push(s[i])
        }
        return stack.isEmpty()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(_20().isValid("()[]{}[()]"))
        }
    }
}