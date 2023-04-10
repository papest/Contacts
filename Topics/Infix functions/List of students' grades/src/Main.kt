infix fun List<Double>.average(markLimit: Double): Double = this.filter { it >= markLimit }.average()
