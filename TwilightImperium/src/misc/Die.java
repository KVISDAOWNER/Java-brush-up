package misc;
import java.util.concurrent.ThreadLocalRandom;

public class Die {
    int min;
    int max;
    public Die(int min, int max){ //inclusive
        this.min = min;
        this.max = max;
    }

    public int roll(){
        return ThreadLocalRandom.current().nextInt(min, max + 1); //+1 so its inclusive
    }
}
