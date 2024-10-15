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
}