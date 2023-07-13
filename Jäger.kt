package Hero

import Gegner.Boss
import java.util.concurrent.ThreadPoolExecutor


class Jäger(name: String, lifePoints: Int, mana: Int, deffBuff: Boolean, poison: Boolean) :
    Hero(name, lifePoints, mana, deffBuff, poison) {

    var bigDmg = 80..100
    var lowDmg = 30..50
    var dotDmg = 25..35
    var beschreibung = ""

    override fun Angriff(boss: Boss) {}


    fun gezielterSchuss(boss: Boss) {

        this.beschreibung = "Verursacht beim treffen 70 - 100 schaden."

        val hit = bigDmg.random()
        val plusPercent = hit * 1.15
        val markedDmg = plusPercent.toInt()

        if (boss.marked == true) {
            boss.takeDMG(markedDmg)
            println("${boss.name} ist ${(rot + "markiert" + reset)} und erleidet ${(rot + markedDmg + reset)}schaden.")
        } else {

            boss.takeDMG(hit)

            println("$name setzt 'gezielter Schuss' ein und ${boss.name} ${(rot + hit + reset)}")
            println("${(boss.name)} hat noch ${(grün + boss.lifePoints + reset)}hp")
        }
    }

    fun giftPfeil(boss: Boss) {

        this.beschreibung = "Verursacht beim treffen 20 - 50 schaden und vergiftet das Ziel für 1 Runden mit Gift.\n " +
                "Gift verursacht 15-20 schaden."

        val dotHit = dotDmg.random()
        val hit = lowDmg.random()

        val plusPercent = hit * 1.15
        val markedDmg = plusPercent.toInt()

        if (boss.marked == true) {

            boss.takeDMG(markedDmg)

            println("${boss.name} ist 'markiert'und wird mit 'Giftpfeil' getroffen und erhält ${(rot + markedDmg + reset)}schaden.")

            boss.takeDMG(dotHit)

            println("${boss.name} erleidet 'giftschaden' ${(rot + dotHit + reset)}scahden")
            println("${boss.name} ist nun ${grün + ("'vergiftet'") + reset}")
            boss.poison = true
            Thread.sleep(300)
        } else {

            boss.takeDMG(hit)

            println("$name setzt 'Giftpfeil' ein...")
            println("${boss.name} wird mit 'Giftpfeil' getroffen und erhält ${(rot + hit + reset)}schaden.")
            println("${boss.lifePoints}")

            boss.takeDMG(dotHit)

            boss.poison = true

            println("${boss.name} ist nun vergiftet")
            Thread.sleep(300)
            println("${boss.name} erleidet 'giftschaden' ${(rot + dotHit + reset)}scahden")
        }
    }


    fun poisenDmg(boss: Boss) {

        val dotHit = dotDmg.random()

        if (boss.poison == true) {
            boss.takeDMG(dotHit)
            println("${boss.name} ist vergiftet")
            Thread.sleep(300)
            println("${boss.name} erleidet ${grün + "giftschaden" + reset} ${(rot + dotHit + reset)}scahden")
        }
    }


    fun schildkroetenpanzer() {

        this.beschreibung = "Schützt 1 Runde vor sämtlichen eingehenden Schaden."

        deffBuff = true

        println("$name setzt ${blau + "Schildkrötenpanzer" + reset} ein und ist für eine Runde vor sämtlichen schaden geschützt.")

    }


    fun zielMarkieren(boss: Boss) {

        this.beschreibung = "Markiert das Ziel für 3 Runden und erhöht sämtlichen eingehenden schaden um 20%"

        boss.marked = true
        println("$name setzt ${blau + "Ziel Markieren" + reset} auf ${(rot + boss.name + reset)} ein, sämtlicher schaden ist für die nächsten 3 Runden erhöht.")
    }


    override fun aktionAuswahl(boss: Boss, hero: Hero) {

        println("========================================")
        println()
        println(name)
        Thread.sleep(400)
        println("-----------------------")
        println("Wähle eine Attacke aus.")
        Thread.sleep(400)
        println()
        println("1 - Gezielter Schuss")
        Thread.sleep(400)
        println("2 - Giftpfeil")
        Thread.sleep(400)
        println("3 - Ziel markieren")
        Thread.sleep(400)
        println("4 - Schildkrötenpanzer")
        Thread.sleep(400)
//        println("5 - Tränke")
//        Thread.sleep(400)
        println()
        println("========================================")
        println()

        val auswahl = readln().toInt()

        when (auswahl) {
            1 -> {
                gezielterSchuss(boss)
            }

            2 -> {
                giftPfeil(boss)
            }

            3 -> {
                zielMarkieren(boss)
            }

            4 -> {
                schildkroetenpanzer()
            }

//            5 -> {
//            tränke
//        }
            else -> {
                println(rot + "Das war keine korrekte eingabe" + reset)
                aktionAuswahl(boss,hero)
            }
        }
    }
}


