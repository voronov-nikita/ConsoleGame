fun main() {

    println("Введите класс вашего персонажа:\n[1]Маг\n[2]Робот\n[3]Рыцарь")
    // Вводим класс нашего игрока
    val hero: Any? = when (readlnOrNull()) {
        "1" -> Wizard();
        "2" -> Robot();
        "3" -> Knight();
        else -> notRass();
    }

//
    var game: Boolean = true

// цикл игры
    while (game && hero != null) {
        //
        printActions()
        val act = readln()

        when (act) {
            "1" -> game = false
            "2" -> generateNewEnemy(hero)
            "3" -> shoping()

        }
    }

    println("До новых встреч\n")
}

fun printActions() {
    println("Вы путешествуете, каковы ваши действия?\n[1] Выйти из игры\n[2] Найти противника\n[3] Зайти в магазин")
}

fun printFightActions(){
    println("Выберите действие:\n[1] Атака\n[2] Лечение\n[3] Убегаю")
}

// механика боя со случайным врагом
fun generateNewEnemy(hero: Any?) {
//    создаем врага
    val enemy: EnemyBot? = hero?.let { EnemyBot(it.level) }

    if (enemy != null) {
        while (hero.health!=0 || enemy.health!=0){
//        механика игрового процесса
            printFightActions()
            val act = readln()
            when (act){
                "1" -> enemy.getDamage(hero.attack())
            }
        }
    }

}

// виртуальный магазин игрока
fun shoping() {

}

// проверка на рассу
fun notRass(): Unit? {
    println("Вы ввели неккоректную рассу")
    return null
}