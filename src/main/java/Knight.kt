class Knight(): Human() {
    var power: Int = 15;

    override fun attack(): Int {
        println("Атака мечом рыцаря!")
        return this.power * this.level;
    }

    override fun getHealth() {
        println("Перевязать раны!")
        this.health += this.level*(this.power/5)
    }

    override fun getDamage(damage: Int){
        this.health -= damage;
    }

    override fun printStat() {
        println("Характеристики игрока:\n\t| Здоровье: ${this.health}\n\t| Уровень: ${this.level}\n\t| Сила: ${this.power}\n\n")
    }
}