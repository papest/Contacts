fun getCamelStyleString(inputString: String): String {
    return inputString.split("_").map { it.lowercase() }
        .joinToString("") {
            it.replaceFirstChar { i -> i.uppercase() }
        }
}