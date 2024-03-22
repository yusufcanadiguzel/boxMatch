import java.util.Random;

public class Fighter {
    String name;
    int damage;
    int health;
    double weight;
    double dodge;

    Fighter(String name, int damage, int health, double weight, double dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = (dodge <= 0) || (dodge >= 100) ? 0 : dodge;
    }

    void hit(Fighter foe) {
        if (!foe.isDodge()) {
            foe.health -= this.damage;
            System.out.println(this.name + " " + this.damage + " hasar verdi.");
        } else {
            System.out.println(foe.name + " hasar almadı.");
        }
    }

    boolean isDodge() {
        Random random = new Random();
        var chance = random.nextInt(0, 101);

        return chance <= this.dodge;
    }
}
