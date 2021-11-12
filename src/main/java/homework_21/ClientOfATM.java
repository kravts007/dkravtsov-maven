package homework_21;

import java.util.Random;

public class ClientOfATM {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ATM atm = new ATM(10, 1000, 1000);
        System.out.println("\n" + atm + "\n");
        ATM.User1 user1 = new ATM.User1(atm);
        ATM.User2 user2 = new ATM.User2(atm);
        new Thread(user1).start();
        new Thread(user2).start();
    }
}
