import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        ATM atm = new ATM(bank, sc);

        atm.start();

        sc.close();
    }
}