import Gegner.Boss
import Hero.*

val reset = "\u001b[0m"
val rot = "\u001b[31m"
val grün = "\u001B[32m"
val blau = "\u001B[34m"
val gelb = "\u001B[33m"

fun main() {

    val boss = Boss("Thanos", 100, false, false, false)

    val hunter = Jäger("Hawkeye", 150, 0, false, false)
    val mage = Magier("Dr.  Strange", 150, 200, false, false)
    val warri = Krieger("Odin", 200, 0, false, false)
    val priest = Priester("Peter", 150, 200, false, false)

    val group = mutableListOf<Hero>(mage, hunter, warri, priest)

    val counter = 0

    while (hunter.lifePoints >= 0 || mage.lifePoints >= 0 || warri.lifePoints >= 0 || priest.lifePoints >= 0 && boss.lifePoints >= 0) {


        println()
        println()
        println("Boss")
        Thread.sleep(300)
        println((rot + boss.name + reset))
        Thread.sleep(300)
        println("${(grün + boss.lifePoints + reset)}hp")
        println("-------------------------")
        Thread.sleep(1000)
        println("Heldengruppe")
        println("-------------------------")
        Thread.sleep(300)
        println("${warri.name} - ${(grün + warri.lifePoints + reset)}hp")
        Thread.sleep(300)
        println("${mage.name} - ${(grün + mage.lifePoints + reset)}hp")
        Thread.sleep(300)
        println("${priest.name} - ${(grün + priest.lifePoints + reset)}hp")
        Thread.sleep(300)
        println("${hunter.name} - ${(grün + hunter.lifePoints + reset)}hp")
        println()
        println()

        if (mage.poison == true) {
            boss.dotDmG(mage)
            mage.poison = false
        }
        (mage as Magier).aktionAuswahl(boss, mage)
        Thread.sleep(1000)
        if (boss.lifePoints <= 0) {
            val win = "${boss.name} ist Tod....\n" +
                    grün + "DU HAST _!_GEWONNEN_!_ " + reset

            for (i in 0 until win.length) {
                print(win[i])
                Thread.sleep(50)
            }
            println()
            break
        }

        if (warri.poison == true) {
            boss.dotDmG(warri)
            warri.poison = false
        }
        (warri as Krieger).aktionAuswahl(boss, warri)
        Thread.sleep(1000)
        if (boss.lifePoints <= 0) {
            val win = "${boss.name} ist Tod....\n" +
                    grün + "DU HAST _!_GEWONNEN_!_ " + reset

            for (i in 0 until win.length) {
                print(win[i])
                Thread.sleep(50)
            }
            println()
            break
        }

        if (priest.poison == true) {
            boss.dotDmG(priest)
            priest.poison = false
        }
        (priest as Priester).aktionAuswahl(boss, priest, group)
        Thread.sleep(1000)
        if (boss.lifePoints <= 0) {
            val win = "${boss.name} ist Tod....\n" +
                    grün + "DU HAST _!_GEWONNEN_!_ " + reset

            for (i in 0 until win.length) {
                print(win[i])
                Thread.sleep(50)
            }
            println()
            break
        }

        if (hunter.poison == true) {
            boss.dotDmG(hunter)
            hunter.poison = false
        }
        (hunter as Jäger).aktionAuswahl(boss, hunter)
        Thread.sleep(1000)

        if (boss.lifePoints <= 0) {
            val win = "${boss.name} ist Tod....\n" +
                    grün + "DU HAST _!_GEWONNEN_!_ " + reset

            for (i in 0 until win.length) {
                print(win[i])
                Thread.sleep(50)
            }
            println()
            break
        }

        if (counter <= 3) {

            if (boss.poison == true) {
                hunter.poisenDmg(boss)
                boss.poison = false
            }
            if (boss.wound == true) {
                warri.dotDmg(boss)
                boss.wound = false
            }
        }

        repeat(3) {

            boss.randomAttack(group)
            Thread.sleep(1000)

            if (hunter.lifePoints <= 0) {
                group.remove(hunter)
                println("${hunter.name} ist Tod.")
            }
            if (mage.lifePoints <= 0) {
                group.remove(mage)
                println("${mage.name} ist Tod.")
            }
            if (warri.lifePoints <= 0) {
                group.remove(warri)
                println("${warri.name} ist Tod.")
            }
            if (priest.lifePoints <= 0) {
                group.remove(priest)
                println("${priest.name} ist Tod.")
            }
            if (hunter.lifePoints <= 0 && mage.lifePoints <= 0 && warri.lifePoints <= 0 && priest.lifePoints <= 0) {

                val win = "Alle Helden sind Tod...\n" +
                        (rot + "DU HAST _!_VERLOREN_!_ " + reset)

                for (i in 0 until win.length) {
                    print(win[i])
                    Thread.sleep(50)
                }
                println()
            }

        }

        var counter = 0
        if (counter == 3) {
            boss.poison = false
            boss.wound = false
        }

        counter += 1

        println("Runde: $counter")
    }
}








