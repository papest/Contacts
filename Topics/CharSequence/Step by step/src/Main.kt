fun removeEveryOtherChar(input: CharSequence): CharSequence =
    input.indices.filter { it % 2 == 0 }.map { input[it] }.joinToString("")