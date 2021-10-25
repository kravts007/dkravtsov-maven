package homework_21;

import java.util.Random;

public class ClientOfATM {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ATM atm = new ATM(10, 1000, 1000);
        System.out.println("\n" + atm + "\n");

        for (int i = 0; i < 10; i++) {
            int rand = RANDOM.nextInt(10);
            atm.putCash();
            if (rand % 2 == 0) {
                atm.getCash();
            }
        }
    }
}
