package Hero

import Gegner.Boss
import Items.Item


class Magier(name: String, lifePoints: Int, mana: Int, deffBuff: Boolean, poisen: Boolean) :
    Hero(name, lifePoints, mana, deffBuff, poisen) {


    var bigDmg = 70..100
    var lowDmg = 30..50
    var dotDmg = 15..30
    var minusManaBig = 80
    var minusManaLow = 50
    var beschreibung = ""


    fun arkanSchlag(boss: Boss, hero: Hero) {


        this.beschreibung = "Verursacht bei treffer 70 - 100 schaden."

        val hit = bigDmg.random()
        val markedDmg = hit * 1.15.toInt()

        /*        if (hero.mana < 40) {
                    println("$name hat zu wenig ${(blau + ("mana") + reset)}")
                } else {

                    hero.mana = -minusManaBig

         */

        if (boss.marked == true) {
            boss.takeDMG(markedDmg)
            println("${boss.name} erhält $markedDmg schaden.")
        } else {

            boss.takeDMG(hit)

            println("$name trifft ${boss.name} mit 'Arkanschlag' $hit.")
            println("$name hat noch $mana Mana.")
            println("${boss.name} - ${boss.lifePoints}hp")
        }
    }


    fun feuerSchlag(boss: Boss) {

        val hit = lowDmg.random()
        val dothit = dotDmg.random()

        boss.takeDMG(hit)
        Thread.sleep(300)

        println("$name setz 'Feuerschlag' ein und trifft ${boss.name} mit ${rot + hit + reset}schaden.")
        Thread.sleep(300)
        println("${boss.name} hat noch ${grün + boss.lifePoints + reset}hp")
        Thread.sleep(300)

        boss.takeDMG(dothit)
        boss.poison = true

        println("${boss.name} 'brennt' und erleidet ${rot + dothit + reset}schaden.")
        Thread.sleep(300)
    }

    fun feuerWall(hero: Hero) {

        this.beschreibung = "Schützt 1 Runde vor sämtlichen eingehenden Schaden."

        Thread.sleep(300)
        println("$name setzt 'Feuerwall' ein und ist für eine runde vor sämtlichen schaden geschützt.")

        hero.deffBuff = true
        Thread.sleep(300)
    }

    fun arkaneBlitze(boss: Boss) {

        when ((1..5).random()) {

            1 -> {
                val hit = lowDmg.random()

                boss.takeDMG(hit)
                Thread.sleep(300)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit + reset)}schaden. ")
                Thread.sleep(1000)
                println("${boss.name} hat noch ${rot + boss.lifePoints + reset}")
            }

            2 -> {
                val hit = lowDmg.random()

                boss.takeDMG(hit)
                Thread.sleep(300)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit + reset)}schaden. ")
                Thread.sleep(300)

                val hit2 = lowDmg.random()
                boss.takeDMG(hit2)
                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit2 + reset)}schaden. ")
                Thread.sleep(1000)
                println("${boss.name} hat noch ${rot + boss.lifePoints + reset}")
            }

            3 -> {
                val hit = lowDmg.random()

                boss.takeDMG(hit)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit + reset)}schaden. ")
                Thread.sleep(300)

                val hit2 = lowDmg.random()
                boss.takeDMG(hit2)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit2 + reset)}schaden. ")
                Thread.sleep(200)

                val hit3 = lowDmg.random()
                boss.takeDMG(hit3)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit3 + reset)}schaden. ")
                Thread.sleep(1000)

                println("${boss.name} hat noch ${rot + boss.lifePoints + reset}")
            }

            4 -> {
                val hit = lowDmg.random()

                boss.takeDMG(hit)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit + reset)}schaden. ")
                Thread.sleep(200)

                val hit2 = lowDmg.random()

                boss.takeDMG(hit2)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit2 + reset)}schaden. ")
                Thread.sleep(200)

                val hit3 = lowDmg.random()

                boss.takeDMG(hit3)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit3 + reset)}schaden. ")
                Thread.sleep(200)

                val hit4 = lowDmg.random()

                boss.takeDMG(hit4)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit4 + reset)}schaden. ")
                Thread.sleep(300)

                println("${boss.name} hat noch ${rot + boss.lifePoints + reset}")
                Thread.sleep(300)
            }

            5 -> {
                val hit = lowDmg.random()

                boss.takeDMG(hit)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit + reset)}schaden. ")
                Thread.sleep(200)

                val hit2 = lowDmg.random()

                boss.takeDMG(hit2)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit2 + reset)}schaden. ")
                Thread.sleep(200)

                val hit3 = lowDmg.random()

                boss.takeDMG(hit3)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit3 + reset)}schaden. ")
                Thread.sleep(200)

                val hit4 = lowDmg.random()

                boss.takeDMG(hit4)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit4 + reset)}schaden. ")

                val hit5 = lowDmg.random()

                boss.takeDMG(hit5)

                println("$name setzt 'Arkaneblitze' ein ${boss.name} erleidet ${(rot + hit5 + reset)}schaden. ")
                Thread.sleep(300)
                println("${boss.name} hat noch ${rot + boss.lifePoints + reset}")
                Thread.sleep(1000)

            }
        }
    }

    override fun aktionAuswahl(boss: Boss, hero: Hero) {

        println("========================================")
        println()
        println(name)
        Thread.sleep(300)
        println("------------------------")
        println("Whähle eine Attacke aus.")
        Thread.sleep(400)
        println()
        println("1 - Arkanschlag")
        Thread.sleep(400)
        println("2 - Feuerschlag")
        Thread.sleep(400)
        println("3 - Arkane Blitze")
        Thread.sleep(400)
        println("4 - Feuerwall")
        Thread.sleep(400)
        /*        println("5 -> Tränke")
                Thread.sleep(400)
         */
        println()
        println("========================================")
        println()
        Thread.sleep(1000)

        var auswahl = readln().toInt()

        when (auswahl) {
            1 -> {
                arkanSchlag(boss, hero)
            }

            2 -> {
                feuerSchlag(boss)
            }

            3 -> {
                arkaneBlitze(boss)
            }

            4 -> {
                feuerWall(hero)
            }

            else -> {
                println(rot + "Das war keine korrekte eingabe" + reset)
                aktionAuswahl(boss, hero)
            }
        }
    }
}