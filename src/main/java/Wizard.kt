class Wizard(): Human() {

    var power: Int = 20;

    override fun attack(): Int {
        println("Огненый шар!")
        return this.power * this.level;
    }

    override fun getHealth() {
        println("Магия исцеления!")
        this.health += this.level * 2
    }

    override fun getDamage(damage: Int){
        this.health -= damage;
    }

    override fun printStat() {
        println("Характеристики игрока:\n\t| Здоровье: ${this.health}\n\t| Уровень: ${this.level}\n\t| Сила: ${this.power}\n\n")
    }

}