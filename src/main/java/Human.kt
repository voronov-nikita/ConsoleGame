abstract class Human() {
    var health: Int = 25;
    var score: Int = 0;
    var level: Int = 1;

    /**
     * Функция атаки
     * */
    abstract fun attack(): Int;
    /**
     * Функция исцеления игрока
     * */
    abstract fun getHealth();
    /**
     * Функция получения урона
     * */
    abstract fun getDamage(damage: Int);

    /**
     * Функция вывода в терминал текущих характеристик персонажа
     * */
    abstract fun printStat();
}