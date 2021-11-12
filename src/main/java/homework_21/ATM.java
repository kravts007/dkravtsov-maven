package homework_21;

import java.util.Random;
import java.util.Scanner;

public class ATM extends Thread {
    private final int withdrawMaxValue;
    private final int putInMaxValue;
    private int sum;
    public static final Object lock = new Object();
    private static final Random RANDOM = new Random();

    public ATM(int sum, int puttingMaxValue, int withdrawMaxValue) {
        this.withdrawMaxValue = withdrawMaxValue;
        this.putInMaxValue = puttingMaxValue;
        this.sum = sum;
    }

    /**
     * randomCash() - randomizer for withdrawing and depositing limit of money
     */
    private int randomCash(int maxLimit) {
        int minCash = 1;
        return (int) (Math.random() * (maxLimit - minCash) + minCash);
    }

    /**
     * putCash() - Put a random amount of money in the ATN
     */
    public void putCash() {
        synchronized (lock) {
            int cashPutIn = randomCash(putInMaxValue);
            this.sum += cashPutIn;
            System.out.println(Thread.currentThread().getName() + " - put: " + cashPutIn + " - Money in ATM: " + sum);
        }
    }

    /**
     * getCash() - Get a random amount of money from the ATN
     */
    public void getCash() {
        int cashTakeOff = randomCash(withdrawMaxValue);
        synchronized (lock) {
            while (cashTakeOff < 0 || cashTakeOff >= sum) {
                System.out.println(Thread.currentThread().getName() + " try to withdraw invalid value " + cashTakeOff);
                System.out.println("Money at the ATM: " + sum);
                System.out.println("Enter an amount less than " + sum + " and above 0");
                Scanner sc = new Scanner(System.in);
                cashTakeOff = sc.nextInt();
            }
            sum -= cashTakeOff;
            System.out.println(Thread.currentThread().getName() + " - withdraw: " + cashTakeOff + " - Money in ATM: " + sum);
        }
    }

    /**
     * Thread User1
     */
    public static class User1 implements Runnable {
        ATM atm;

        public User1(ATM atm) {
            this.atm = atm;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                int rand = RANDOM.nextInt(5);
                atm.putCash();
                if (rand % 2 == 0) {
                    atm.getCash();
                }
            }
        }
    }

    /**
     * Thread User2
     */
    public static class User2 implements Runnable {
        ATM atm;

        public User2(ATM atm) {
            this.atm = atm;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                int rand = RANDOM.nextInt(5);
                atm.putCash();
                if (rand % 2 == 0) {
                    atm.getCash();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ATM{" +
                "withdrawMaxValue=" + withdrawMaxValue +
                ", putInMaxValue=" + putInMaxValue +
                ", sum=" + sum +
                '}';
    }
}


