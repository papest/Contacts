fun isReversed(pair: Pair<String, String>): Triple<String, String, Boolean> =
    Triple(pair.first, pair.second, pair.first.lowercase().reversed() == pair.second.lowercase())