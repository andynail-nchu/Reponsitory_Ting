open class Human(open val name: String?){
    open fun attack() {
        println("${name} use Fist Attack!");
        mana += 10;
    }
}

class Mage(override val name: String?): Human(name){
    override fun attack() {
        if(mana >= 30) {
            println("${name} use Fireball!");
            mana -= 30;
        }
        else println("${name} has poor mana...");
    }
}

internal var mana = 0;

fun main(){
    println("Assignment Q4");
    Human("Peter").attack();
    println("Assignment Q5");
    mana = 100;
    Mage("Derek").attack();
    game@while(true) {
        try{
            mana = 0;
            println("Enter your name：");
            val name = readLine();
            println("Choose your job：1.Human 2.Mage");
            val job: Int = Integer.valueOf(readLine());
            if (job < 1 || job > 2) {
                println("Something wrong, try again!");
                continue;
            } else {
                println("Hello ${name}!");
                while(true){
                    println("Give a movement: 0.Exit 1.Fist Attack(mana+10) 2.Magic Skill(mana-30)");
                    val mv: Int = Integer.valueOf(readLine());
                    if (mv < 0 || mv > 2) {
                        println("Wrong movement");
                        continue;
                    } else {
                        when {
                            mv == 0 -> break@game;
                            mv == 1 -> {
                                Human(name).attack();
                                if (job == 2) println("mana: ${mana}");
                            }
                            mv == 2 && job == 1 -> println("Human has no magic skill!");
                            mv == 2 && job == 2 -> {
                                Mage(name).attack();
                                println("mana: ${mana}");
                            }
                        }
                    }
                }
            }
        }catch (exception: Exception) {
            println("Something wrong, try again!");
            continue;
        }
    }
    println("Good Bye!");
}