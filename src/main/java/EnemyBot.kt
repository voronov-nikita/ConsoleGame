open class EnemyBot(private var heroLevel: Int) {

    private val Names = arrayOf("Дракон", "Гоблин", "Троль", "Злой король", "Темный маг", "Призрак")

    open var name: String = (Names).random()
    open var health: Int = (10 * heroLevel..150 * heroLevel).random()
    var power: Int = (10 * heroLevel..50 * heroLevel).random()
    var level: Int = (1 * heroLevel..5 * heroLevel).random()
    var armor: Int = ((0..1).random()) / 10

    // функция инициализации врага перед игроком
    open fun initEnemy() {
        println("Вам встретился ${this.name}")
    }

    /**
     * Вывод информации о текущем состоянии бота
     */
    open fun printStat() {
        println("Характеристики ${this.name}:\n\t| Здоровье: ${this.health}\n\t| Уровень: ${this.level}\n\t| Сила: ${this.power}\n")
    }

    /**
    Функция атаки врага
    Вернет значение, которое нужно отнять у игрока
     */
    open fun attack(): Int {
        val res = this.level * this.power
        println("${this.name} атакует! Сила удара: $res")
        return res
    }

    /**
    Функция исцеления бота
     */
    open fun getHealth() {
        this.health += (this.level / 10) + 1
        println("${this.name} излечился. Теперь его здоровье: ${this.health}")
    }

    /**
     * Функция защиты.
     * Противник не получил урона
     */
    open fun protection() {
        println("Противник увернулся от удара. Его здровье: ${this.health}")
    }

    /**
     * Функция получение урона.
     * Есть шанс, что противнику удасться увернуться от удара
     */
    open fun getDamage(power: Int) {
        val protChance: Int = (1..5).random()
        if (protChance == 3) {
            protection()
        }else{
            this.health -= power * (1 - this.armor)
        }
    }


}