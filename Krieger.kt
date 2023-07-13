package Hero

import Gegner.Boss

class Krieger(name: String, healthPoints: Int, mana: Int, deffBuff: Boolean, poison: Boolean) :
    Hero(name, healthPoints, mana, deffBuff, poison) {

    var bigDmg = 80..120
    var lowDmg = 40..60
    var dotDmg = 15..20
    var marked = false
    var roundCounter = 0
    var beschreibung = ""


    fun verwunden(boss: Boss) {

        this.beschreibung =
            "Verursacht beim treffen 25- 35 schaden und verwundet das Ziel für 1 Runden mit 'Bluten' Bluten verursacht 15-20 schaden."

        val dotHit = dotDmg.random()
        val newDmg = lowDmg.random()

        boss.takeDMG(newDmg)
        Thread.sleep(300)

        println("$name trifft ${boss.name} mit 'Verwunden' ${(rot + newDmg + reset)}schaden")
        Thread.sleep(300)
        println("${boss.lifePoints}")
        Thread.sleep(300)

        boss.wound = true
        boss.takeDMG(dotHit)
        Thread.sleep(300)

        println("${boss.name} ist verwundet")
        Thread.sleep(300)
        println("${boss.name} erhält 'verwundeten Schaden' ${(rot + dotHit + reset)}schaden.")
        Thread.sleep(300)
        println((rot + boss.lifePoints + reset))
        Thread.sleep(300)
    }

    fun dotDmg(boss: Boss) {

        val dotHit = dotDmg.random()

        if (boss.wound == true) {
            boss.takeDMG(dotHit)
            Thread.sleep(300)

            println("${boss.name} erleidet ${rot + dotHit + reset}schaden")
            Thread.sleep(300)
            println("${boss.name} hat ${grün + boss.lifePoints + reset}hp")
            Thread.sleep(300)
        }
    }

    fun hieb(boss: Boss) {

        val hit = bigDmg.random()

        boss.takeDMG(hit)
        Thread.sleep(300)

        println("$name trifft ${boss.name} mit 'Hieb' für ${rot + hit + reset}schaden.")
        Thread.sleep(300)
        println("${boss.name} hat noch ${grün + boss.lifePoints + reset}hp")
        Thread.sleep(300)
    }

    fun schildschlag(boss: Boss) {

        this.beschreibung = "der Schildschlag ist nur ein schwacher angriff mit 25 - 35 schaden."

        val hit = lowDmg.random()

        boss.takeDMG(hit)
        Thread.sleep(300)

        println("$name setzt 'Schildschlag' ein und trifft ${boss.name} mit ${(rot + hit + reset)}schaden.")
        Thread.sleep(300)
        println("${boss.name} hat noch ${(grün + boss.lifePoints + reset)}hp")
        Thread.sleep(300)
    }

    fun schildwall(hero: Hero) {

        this.beschreibung = "Schützt 1 Runde vor sämtlichen eingehenden Schaden."

        hero.deffBuff = true
        println("$name setzt 'Schildwall' ein und ist für eine runde vor sämtlichen schaden geschützt.")
        Thread.sleep(300)
    }

    override fun aktionAuswahl(boss: Boss, hero: Hero) {

        println("========================================")
        println()
        println(name)
        Thread.sleep(400)
        println("------------------------")
        println("Whähle eine Attacke aus.")
        Thread.sleep(400)
        println()
        println("1 - Verwunden")
        Thread.sleep(400)
        println("2 - Hieb")
        Thread.sleep(400)
        println("3 - Schildschlag")
        Thread.sleep(400)
        println("4 - Schildwall")
        Thread.sleep(400)
        println()
        println("========================================")
        println()

        val auswahl = readln().toInt()

        when (auswahl) {
            1 -> {
                verwunden(boss)
                Thread.sleep(300)
            }

            2 -> {
                hieb(boss)
                Thread.sleep(300)
            }

            3 -> {
                schildschlag(boss)
                Thread.sleep(300)
            }

            4 -> {
                schildwall(hero)
                Thread.sleep(300)
            }
            else -> {
                println(rot + "Das war keine korrekte eingabe" + reset)
                aktionAuswahl(boss,hero)
            }
        }
    }
}


