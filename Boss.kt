package Gegner

import Hero.*

open class Boss(
    var name: String,
    var lifePoints: Int,
    var marked: Boolean,
    var poison: Boolean,
    var wound: Boolean,
) {

    val bigDmg = 40..70
    val midDmg = 30..45
    val lowDmg = 15..25
    val dotDmg = 10..20

    val reset = "\u001b[0m"
    val rot = "\u001b[31m"
    val grün = "\u001B[32m"
    val blau = "\u001B[34m"
    val gelb = "\u001B[33m"


    fun randomAttack(heros: List<Hero>) {
        var hero = heros.random()

        when ((1..3).random()) {

            1 -> {
                if (hero.deffBuff == false) {
                    infinitySchlag(hero)
                } else {
                    println("${hero.name} ist geschützt")
                    hero.deffBuff = false
                }
            }

            2 -> {
                if (hero.deffBuff == false) {
                    spalten(heros)
                } else {
                    println("${hero.name} ist geschützt")
                    hero.deffBuff = false
                }
            }

            3 -> {
                if (hero.deffBuff == false) {
                    zerreissen(hero)
                } else if (hero.lifePoints <= 0) {
                    println("${hero.name} ist geschützt")
                    hero.deffBuff = false
                }
            }

        }

    }

    fun takeDMG(damage: Int) {

        lifePoints -= damage

    }

    fun infinitySchlag(hero: Hero) {

        var hit = bigDmg.random()

        if (hero.deffBuff == true) {
            println("${hero.name} wehrt den angriff ab.")
            println("===========================================================")
            hero.deffBuff = false
        } else {

            hero.takeDMG(hit)

            println("$name setzt 'Infinity Schlag' ein...")
            println("${hero.name} wird mit ${(rot + hit + reset)}dmg getroffen.")
            println("===========================================================")

        }
    }

    private fun spalten(heros: List<Hero>) {

        var hit = midDmg.random()

        for (hero in heros)
            hero.lifePoints -= hit

        println("$name setzt 'Spalten' ein...")
        println("alle Helden erhalten ${rot + hit + reset}schaden")
        Thread.sleep(300)
        println("===========================================================")
        println("${heros[0].name} hat ${heros[0].lifePoints}")
        Thread.sleep(300)
        println("${heros[1].name} hat ${heros[1].lifePoints}")
        Thread.sleep(300)
        println("${heros[2].name} hat ${heros[2].lifePoints}")
        Thread.sleep(300)
        println("${heros[3].name} hat ${heros[3].lifePoints}")
        println("===========================================================")
        Thread.sleep(300)

    }

    private fun zerreissen(hero: Hero) {

        var hit = midDmg.random()

        hero.takeDMG(hit)
        println("$name setzt 'Zerreissen' auf ${hero.name} ein und trifft mit ${(rot + hit + reset)}schaden.")
        println("${hero.name} 'blutet'...")
        println("${hero.name} hat noch ${(grün + hero.lifePoints + reset)}hp")
        println("===========================================================")
        hero.poison = true
    }


    fun dotDmG(hero: Hero) {

        var dotHit = dotDmg.random()

        if (this.poison == true)
            hero.takeDMG(dotHit)
        println("${hero.name} erleidet ${(rot + dotHit + reset)}dmg")
        hero.poison = false
    }
}