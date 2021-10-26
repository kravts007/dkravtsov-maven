package homework_21;

import java.util.Scanner;

public class ATM extends Thread {
    private final int withdrawMaxValue;
    private final int putInMaxValue;
    private int sum;
    final Object lock = new Object();

    public ATM(int sum, int puttingMaxValue, int withdrawMaxValue) {
        this.withdrawMaxValue = withdrawMaxValue;
        this.putInMaxValue = puttingMaxValue;
        this.sum = sum;
    }

    Thread tr2 = new Thread("Putter");
    Thread tr1 = new Thread("Taker");

    /**
     * randomCash() - randomizer for withdrawing and depositing limit of money
     */
    private int randomCash(int maxLimit) {
        int minCash = 1;
        return (int) (Math.random() * (maxLimit - minCash) + minCash);
    }

    /**
     * getCash() - Withdraws a random amount of money from an ATM
     */
    public void getCash() {
        int cashTakeOff = randomCash(withdrawMaxValue);
        synchronized (lock) {
            if (sum >= cashTakeOff) {
                sum -= cashTakeOff;
                System.out.println(tr1.getName() + " - withdraw: " + cashTakeOff + " - Money in ATM: " + sum);
            } else {
                Scanner sc = new Scanner(System.in);
                while (sum < cashTakeOff) {
                    System.out.println(tr1.getName() + " - want to withdraw: " + cashTakeOff);
                    System.out.println("Not enough money at the ATM: " + sum);
                    System.out.println("Enter an amount less than " + sum);
                    cashTakeOff = sc.nextInt();
                    sum -= cashTakeOff;
                    System.out.println("Total money at ATM " + sum);
                }
            }
        }
    }
    /**
     * putCash() - Put a random amount of money in the ATN
     */
    public void putCash() {
        synchronized (lock) {
            int cashPutIn = randomCash(putInMaxValue);
            this.sum += cashPutIn;
            System.out.println(tr2.getName() + " - put: " + cashPutIn + " - Money in ATM: " + sum);
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
