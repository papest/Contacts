sealed class Color {
    object Blue : Color()
    object Red : Color()
    object Green : Color()
    class CustomColor(var hex: String) : Color()
}
