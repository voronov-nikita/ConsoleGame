import java.util.Objects

fun main() {
    println("Введите класс вашего персонажа:\n[1]Маг\n[2]Робот\n[3]Рыцарь")
    // Вводим класс нашего игрока
    val hero: Any? = when (readlnOrNull()) {
        "1" -> Wizard();
        "2" -> Robot();
        "3" -> Knight();
        else -> notRass();
    }

    // переменная для включения цикла игры
    var game: Boolean = true

    // цикл игры
    while (game && hero != null) {

        printActions()
        val act = readln()

        when (act) {
            "1" -> game = false
            "2" -> if (!generateNewEnemy(hero)) game = false
            "3" -> shoping()
        }
    }

    println("До новых встреч\n\n")
}

/**
 * Функция вывода в терминал вариантов действий
 * */
fun printActions() {
    println("Вы путешествуете, каковы ваши действия?\n[1] Выйти из игры\n[2] Найти противника\n[3] Зайти в магазин\n")
}

/**
 * Функция вывода в терминал вариантов действий при сражении (после того, как герой встретил врага)
 * */
fun printFightActions(){
    println("Выберите действие:\n[1] Атака\n[2] Лечение\n[3] Убегаю")
}

/**
* Механика боя со случайным врагом.
 * Требуется передать пераметр @param pers
 */
fun generateNewEnemy(pers: Any): Boolean{

    // переопределение игрока по
    val hero = when (pers::class) {
        Wizard::class-> Wizard();
        Robot::class-> Robot();
        Knight::class -> Knight();
        else -> return false;
    }

    // создаем врага
    val enemy: EnemyBot = EnemyBot(hero.level)
    enemy.initEnemy()

    while (hero.health>0 && enemy.health > 0){

        // вывод параметров
        enemy.printStat()
        hero.printStat()

        // <----------- ИГРОК ХОДИТ ПЕРВЫМ --------------->
        printFightActions()
        // выбираем действие
        val heroAct = readln()
        when (heroAct){
            "1" -> enemy.getDamage(hero.attack())
            "2" -> hero.getHealth()
        }

        // <----------- ДАЛЕЕ ХОДИТ БОТ --------------->

        // пусть действие врага будут случайными
        val enemyAct = (1..3).random()
        when (enemyAct){
            1 -> hero.getDamage(enemy.attack())
            2 -> enemy.getHealth()
            3 -> enemy.protection()
        }

    }

    if (hero.health < 0){
        println("ПОРАЖЕНИЕ!\nВы погибли, начинайте сначала.\n")
        return false;
    }
    if (enemy.health < 0){
        println("ПОЗДРАВЛЯЮ!\nВы победили, уровень увеличен.\n")
    }
    // функция вернет true если игрок остался живым
    return true;

}

/**
 * Виртуальный магазин игрока
 * */
fun shoping() {
    println("----------------- В процессе разработки -------------")
}

/**
 * Вывод о неккоректности введенного типа персонажа
 * */
fun notRass(): Unit? {
    println("Вы ввели неккоректную рассу")
    return null
}