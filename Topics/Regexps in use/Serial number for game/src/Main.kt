fun findSerialNumberForGame(listGames: List<String>) {
    val gameName = readln()

    for (serial in listGames) {
        val gameArray = serial.split("@")
        if (gameArray[0] == gameName) {
            println("Code for Xbox - ${gameArray[1]}, for PC - ${gameArray[2]}")
            break
        }
    }
}