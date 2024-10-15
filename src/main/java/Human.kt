abstract class Human() {
    var health: Int = 25;
    var score: Int = 0;
    var level: Int = 1;

    abstract fun attack(): Int;
    abstract fun getHealth();

    open fun printStat(){
        println("Характеристики персонажа:\n| Здоровье: ${this.health}\n| Уровень: ${this.level}\n | Счет: ${this.score}\n")
    }
}