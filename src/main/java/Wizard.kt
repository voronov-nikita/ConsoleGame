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



}