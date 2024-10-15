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
}