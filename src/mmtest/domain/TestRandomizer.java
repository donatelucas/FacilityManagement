package mmtest.domain;
import java.util.Random;

public class TestRandomizer {
    public static void main(String[] args) {
        Randomizer r = new Randomizer();
        int numberOfTests = 300;
        double percentageBeingTested = 0.05;
        r.setRandom();
        System.out.println("Double in Randomizer is: " + r.getRandom());
        double d = r.getRandom();

        if (d == r.getRandom()){
            System.out.println("setRandom: TRUE");
        } else {
            System.out.println("setRandom: FALSE");
        }

        for (int i = 0; i < numberOfTests; i++){
            r.setRandom();
            if (r.getRandom() < percentageBeingTested)
                System.out.println(r.getRandom() + ": TRUE");
            else {
                System.out.println(r.getRandom() + ": FALSE");
            }
        }
    }
}
