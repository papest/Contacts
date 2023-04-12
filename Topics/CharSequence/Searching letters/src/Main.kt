fun containsLetters(source: CharSequence, letters: CharSequence): Boolean {
    var index = -1
    for (ch in letters) {
        index = source.indexOf(ch, index + 1)
        if (index < 0) return false
    }
    return true
}