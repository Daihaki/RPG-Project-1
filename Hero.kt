package Hero
import Gegner.Boss
import Items.Item
import Items.Traenke

open class Hero(
    var name: String,
    var lifePoints: Int,
    var mana: Int,
    var deffBuff: Boolean,
    var poison: Boolean
    ) {

    // Farbcode und reset der Farbe
    val reset = "\u001b[0m"
    val rot = "\u001b[31m"
    val grün = "\u001B[32m"
    val blau = "\u001B[34m"
    val gelb = "\u001B[33m"

    open fun Angriff(boss: Boss) {

    }

    fun takeDMG(damage: Int) {
        lifePoints -= damage
        if (this.deffBuff == true) {
            println("${this.name} ist vor sämtlichen KACK schaden geschützt")
            this.deffBuff = false
        }

 /*       if (this.lifePoints <= 0) {
            println("$name wurde besiegt")
        }

  */
    }

    open fun dotDmG(damage: Int){

        lifePoints -= damage

    }

    fun itemWahl(hero: Hero){

    }

    open fun aktionAuswahl(boss: Boss , hero: Hero) {

    }

}