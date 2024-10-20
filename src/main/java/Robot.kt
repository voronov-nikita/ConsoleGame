class Robot() : Human() {
    var power: Int = 25;


    override fun attack(): Int {
        println("Атака лазерным лучом!")
        return this.power * this.level;
    }

    override fun getHealth() {
        println("Осуществляется замена шестеренок...")
        this.health += this.level;
    }

    override fun getDamage(damage: Int){
        this.health -= damage;
    }

    override fun run(): Boolean {
        val runChance: Int = (1..10).random()
        if (runChance == 5){
            println("Вы успешно сбежали от врага.\n")
            return true;
        }
        println("К сожалению сбежать от врага не получилось, он застал вас в расплох.")
        return false
    }

    override fun printStat() {
        println("Характеристики игрока:\n\t| Здоровье: ${this.health}\n\t| Уровень: ${this.level}\n\t| Сила: ${this.power}\n")
    }
}