open class EnemyBot(private var heroLevel: Int) {

    private val Names = arrayOf("Дракон", "Гоблин", "Троль", "Злой король", "Темный маг", "Призрак")

    open var name: String = (Names).random()
    open var health: Int = (10 * heroLevel..150 * heroLevel).random()
    var power: Int = (10 * heroLevel..50 * heroLevel).random()
    var level: Int = (1 * heroLevel..5 * heroLevel).random()
    var armor: Int = ((0..1).random()) / 10

    open fun attack(): Int {
        val res = this.level * this.power
        println("${this.name} Атакует! Сила удара: $res")
        return res
    }

    private fun getHealth() {
        this.health += (this.level / 10) + 1
        println("${this.name} излечился. Теперь его здоровье: ${this.health}")
    }

    private fun protection(): Boolean {
        val res = arrayOf(true, false)[(0..1).random()]
        if (res) {
            println("Противник увернулся от удара. Его здровье: ${this.health}")
        } else {
            getDamage(10);
            println("Точное попадание! Здровье противника: ${this.health}")
        }
        return res
    }

    //    функция получения урона
    open fun getDamage(power: Int) {
        this.health -= power * (1 - this.armor)
    }

    //  Функция вызова действия у бота
//  На выбор есть 3 функции, соответсвенно при равном шансе это ~33.3% на каждое отдельное действие
    open fun action() {
        val chance: Int = (1..3).random()

        when (chance) {
            1 -> attack()
            2 -> getHealth()
            3 -> protection()
        }
    }


}