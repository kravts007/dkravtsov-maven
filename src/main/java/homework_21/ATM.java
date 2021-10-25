package homework_21;

import java.util.Scanner;

public class ATM {
    private final int withdrawMaxValue;
    private final int putInMaxValue;
    private int sum;

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
     * getCash() - Withdraws a random amount of money from an ATM
     */
    public void getCash() {
        int cashTakeOff = randomCash(withdrawMaxValue);
        if (sum >= cashTakeOff) {
            sum -= cashTakeOff;
            System.out.println(Thread.currentThread().getName() + " - withdraw: " + cashTakeOff + " - Money in ATM: " + sum);
        } else {
            Scanner sc = new Scanner(System.in);
            while (sum < cashTakeOff) {
                System.out.println(Thread.currentThread().getName() + " - want to withdraw: " + cashTakeOff);
                System.out.println("Not enough money at the ATM: " + sum);
                System.out.println("Enter an amount less than " + sum);
                cashTakeOff = sc.nextInt();
                sum -= cashTakeOff;
                System.out.println("Total money at ATM " + sum);
            }
        }
    }

    /**
     * putCash() - Put a random amount of money in the ATN
     */
    public void putCash() {
        int cashPutIn = randomCash(putInMaxValue);
        this.sum += cashPutIn;
        System.out.println(Thread.currentThread() + " - put: " + cashPutIn + " - Money in ATM: " + sum);

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
