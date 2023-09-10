fun main() {
    val fruechte = listOf(
        "Apfel", "Birne", "Orange", "Banane", "Erdbeere", "Kirsche", "Kiwi",
        "Mango", "Pfirsich", "Ananas", "Traube", "Zitrone", "Melone",
        "Heidelbeere", "Granatapfel", "Aprikose", "Kokosnuss", "Feige",
        "Guave", "Pflaume"
    )

    val obst = listOf(
        "Banane", "Traube", "Kirsche", "Apfel", "Birne", "Erdbeere", "Kiwi",
        "Mango", "Pfirsich", "Ananas", "Zitrone", "Melone", "Heidelbeere",
        "Granatapfel", "Aprikose", "Kokosnuss", "Feige", "Guave", "Pflaume"
    )

    do {
        print("Möchten Sie Früchte oder Obst kaufen? (fruechte/obst): ")
        val kategorie = readLine()?.trim()?.toLowerCase()

        when (kategorie) {
            "fruechte" -> {
                zeigeVerfuegbareOptionen(fruechte)
                val ausgewaehlteFruechte = waehleOptionenZumKaufen(fruechte)
                zeigeAusgewaehlteOptionen(ausgewaehlteFruechte)
            }
            "obst" -> {
                zeigeVerfuegbareOptionen(obst)
                val ausgewaehltesObst = waehleOptionenZumKaufen(obst)
                zeigeAusgewaehlteOptionen(ausgewaehltesObst)
            }
            else -> {
                println("Ungültige Auswahl. Bitte wählen Sie 'fruechte' oder 'obst'.")
            }
        }

        print("Möchten Sie in einer anderen Kategorie einkaufen? (ja/nein): ")
    } while (readLine()?.trim()?.toLowerCase() == "ja")
}

fun zeigeVerfuegbareOptionen(optionen: List<String>) {
    println("Verfügbare Optionen:")
    for ((index, option) in optionen.withIndex()) {
        println("${index + 1}. $option")
    }
}

fun waehleOptionenZumKaufen(optionen: List<String>): List<String> {
    val ausgewaehlteOptionen = mutableListOf<String>()

    do {
        print("Geben Sie die Nummer der Option ein, die Sie kaufen möchten (0 zum Beenden): ")
        val eingabe = readLine()?.toIntOrNull()

        if (eingabe == 0) {
            break
        }

        if (eingabe != null && eingabe in 1..optionen.size) {
            ausgewaehlteOptionen.add(optionen[eingabe - 1])
        } else {
            println("Ungültige Eingabe. Bitte geben Sie eine gültige Nummer ein.")
        }

        print("Möchten Sie weitere Optionen kaufen? (ja/nein): ")
    } while (readLine()?.trim()?.toLowerCase() == "ja")

    return ausgewaehlteOptionen
}

fun zeigeAusgewaehlteOptionen(ausgewaehlteOptionen: List<String>) {
    if (ausgewaehlteOptionen.isNotEmpty()) {
        println("Ausgewählte Optionen:")
        for (option in ausgewaehlteOptionen) {
            println(option)
        }
    } else {
        println("Sie haben keine Optionen ausgewählt.")
    }
}
