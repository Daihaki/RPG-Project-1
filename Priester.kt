package Hero

import Gegner.Boss


class Priester(name: String, lifePoints: Int, mana: Int, deffBuff: Boolean, poisen: Boolean) :
    Hero(name, lifePoints, mana, deffBuff, poisen) {


    var groupHeal = 50..80
    var singleHeal = 100..120
    var lowDmg = 40..70
    var bigDmg = 70..90
    var beschreibung = ""
    var roundcounter = 0


    fun gruppenHeal(heros: List<Hero>) {

        val heal = groupHeal.random()

        for (hero in heros)
            hero.lifePoints += heal

        Thread.sleep(300)
        println("$name heilt die Gruppe mit $heal ")
        Thread.sleep(300)
        println()
        println("${heros[0].name} hat ${heros[0].lifePoints}")
        Thread.sleep(300)
        println("${heros[1].name} hat ${heros[1].lifePoints}")
        Thread.sleep(300)
        println("${heros[2].name} hat ${heros[2].lifePoints}")
        Thread.sleep(300)
        println("${heros[3].name} hat ${heros[3].lifePoints}")
        Thread.sleep(300)
    }


    fun einzelHeal(heros: List<Hero>) {

        Thread.sleep(300)
        println("welchen Helden möchtest du Heilen ?")
        Thread.sleep(300)
        println("1 -> 'Magier' - ${heros[0].name}")
        Thread.sleep(300)
        println("2 -> 'Jäger' - ${heros[1].name}")
        Thread.sleep(300)
        println("3 -> 'Krieger' - ${heros[2].name}")
        Thread.sleep(300)
        println("4 -> 'Priester' - ${heros[3].name}")
        Thread.sleep(300)


        val input = readln().toInt()

        val heal = singleHeal.random()

        when (input) {

            1 -> {
                heros[0].lifePoints += heal
                Thread.sleep(300)
                println("${heros[0].name} wirkt eine große Heilung auf ${heros[0].name}, der Held hat nun ${(heros[0].lifePoints)}")
                Thread.sleep(1000)
            }

            2 -> {
                heros[1].lifePoints += heal
                Thread.sleep(300)
                println("${heros[1].name} wirkt eine große Heilung auf ${heros[1].name}, der Held hat nun ${(heros[1].lifePoints)}")
                Thread.sleep(1000)
            }

            3 -> {
                heros[2].lifePoints += heal
                Thread.sleep(300)
                println("${heros[2].name} wirkt eine große Heilung auf ${heros[2].name}, der Held hat nun ${(heros[2].lifePoints)}")
                Thread.sleep(1000)
            }

            4 -> {
                heros[3].lifePoints += heal
                Thread.sleep(300)
                println("${heros[3].name} wirkt eine große Heilung auf ${heros[3].name}, der Held hat nun ${(heros[3].lifePoints)}")
                Thread.sleep(1000)
            }
            else -> {
                println(rot + "Das war keine korrekte eingabe" + reset)
                Thread.sleep(300)
                einzelHeal(heros)
            }
        }
    }


    fun schattenSchlag(boss: Boss) {

        val hit = bigDmg.random()

        boss.takeDMG(hit)
        Thread.sleep(300)
        println("$name setzt 'Schattenschlag' ein und triff ${boss.name} mit ${(rot + hit + reset)}schaden")
        Thread.sleep(300)
        println("${boss.name} hat noch ${boss.lifePoints}")
        Thread.sleep(1000)
    }

    fun akraknesEI(hero: Hero) {

        hero.deffBuff = true

        if (roundcounter <= 0) {
            println("$name ist für eine Runde vor sämtlichen schaden geschützt.")
            hero.deffBuff = true
            roundcounter = +1
        } else {
            println("$name ist schon geschützt und kann nicht noch einen Deffbuff nutzen")
        }
    }

    fun aktionAuswahl(boss: Boss, hero: Hero, heros: List<Hero>) {
        println("========================================")
        println()
        println(name)
        println("------------------------")
        println("Whähle eine Attacke aus.")
        Thread.sleep(400)
        println()
        println("1 - Gruppen Heilung")
        Thread.sleep(400)
        println("2 - Einzel Heilung")
        Thread.sleep(400)
        println("3 - Schattenschlag")
        Thread.sleep(400)
        println("4 - Arkanes Ei")
        Thread.sleep(400)
        println()
        println("========================================")
        println()

        val auswahl = readln().toInt()


        when (auswahl) {
            1 -> {
                gruppenHeal(heros)
            }

            2 -> {
                einzelHeal(heros)
            }

            3 -> {
                schattenSchlag(boss)
            }

            4 -> {
                akraknesEI(hero)
            }

        }
    }
}