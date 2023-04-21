const val VOWELS = "aeiouAEIOU"
fun countVowels(charSequence: CharSequence): Int = charSequence.filter { it in VOWELS }.length
