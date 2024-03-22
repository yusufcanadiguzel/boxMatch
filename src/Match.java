import java.util.Random;

public class Match {
    Fighter fighter1;
    Fighter fighter2;
    double minWeight;
    double maxWeight;
    boolean isFirstFighter;

    Match(Fighter fighter1, Fighter fighter2, double minWeight, double maxWeight) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    void run() {
        firstHit();

        if (checkWeight()) {
            while (this.fighter1.health > 0 && this.fighter2.health > 0) {
                System.out.println("*** RAUND BAŞI ***");
                if (isFirstFighter) {
                    this.fighter1.hit(this.fighter2);
                    if (isWin())
                        break;

                    this.fighter2.hit(this.fighter1);
                    if (isWin())
                        break;
                } else {
                    this.fighter2.hit(this.fighter1);
                    if (isWin())
                        break;

                    this.fighter1.hit(this.fighter2);
                    if (isWin())
                        break;
                }

                System.out.println();
                printScore();
            }
        }
    }

    void startRound(boolean starter){
        if (starter) {

        }else{

        }
    }

    boolean checkWeight() {
        return (this.fighter1.weight >= this.minWeight && this.fighter1.weight <= this.maxWeight) && (this.fighter2.weight >= this.minWeight && this.fighter2.weight <= this.maxWeight);
    }

    void firstHit() {
        Random random = new Random();
        var result = random.nextInt(0, 2);

        this.isFirstFighter = (result == 0);
    }

    boolean isWin(){
        if (this.fighter1.health <= 0){
            System.out.println("Maçı kazanan: " + this.fighter1.name);
            return true;
        }else if (this.fighter2.health <= 0){
            System.out.println("Maçı kazanan: " + this.fighter2.name);
            return true;
        }

        return false;
    }

    void printScore(){
        System.out.println("*** ROUND SONU ***");
        System.out.println(this.fighter1.name + " kalan can: " + this.fighter1.health);
        System.out.println(this.fighter2.name + " kalan can: " + this.fighter2.health);
        System.out.println();
    }
}
