import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner sc;
    private ArrayList<Transaction> transactions;

    public ATM(Bank bank, Scanner sc) {
        this.bank = bank;
        this.sc = sc;
        this.transactions = new ArrayList<>();
    }

    public void start() {

        System.out.println("=================================");
        System.out.println("          ATM INTERFACE");
        System.out.println("=================================");

        Account account = login();

        if (account == null) {
            System.out.println("Access Denied!");
            return;
        }

        System.out.println("\nLogin successful!");
        System.out.println("Welcome, " + account.getUserId());

        boolean running = true;

        while (running) {

            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Balance Check");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showTransactionHistory();
                    break;

                case 2:
                    withdraw(account);
                    break;

                case 3:
                    deposit(account);
                    break;

                case 4:
                    transfer(account);
                    break;

                case 5:
                    System.out.println(
                            "Current Balance: Rs." + account.getBalance()
                    );
                    break;

                case 6:
                    System.out.println("\nThank you for using the ATM!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private Account login() {

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("\nEnter User ID: ");
            String userId = sc.next();

            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            Account account = bank.authenticate(userId, pin);

            if (account != null) {
                return account;
            }

            attempts++;

            System.out.println("Invalid User ID or PIN.");
            System.out.println("Attempts remaining: " + (3 - attempts));
        }

        return null;
    }

    private void withdraw(Account account) {

        System.out.print("\nEnter withdrawal amount: Rs.");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (account.withdraw(amount)) {

            transactions.add(
                    new Transaction(
                            "WITHDRAW",
                            amount,
                            "Cash withdrawn"
                    )
            );

            System.out.println("Withdrawal successful!");
            System.out.println("Remaining Balance: Rs."
                    + account.getBalance());

        } else {

            System.out.println("Insufficient Funds!");
        }
    }

    private void deposit(Account account) {

        System.out.print("\nEnter deposit amount: Rs.");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        account.deposit(amount);

        transactions.add(
                new Transaction(
                        "DEPOSIT",
                        amount,
                        "Cash deposited"
                )
        );

        System.out.println("Deposit successful!");
        System.out.println("Current Balance: Rs."
                + account.getBalance());
    }

    private void transfer(Account account) {

        System.out.print("\nEnter recipient account ID: ");
        String recipientId = sc.next();

        Account recipient = bank.findAccount(recipientId);

        if (recipient == null) {
            System.out.println("Recipient account not found!");
            return;
        }

        if (recipient.getAccountId().equals(account.getAccountId())) {
            System.out.println("You cannot transfer to your own account!");
            return;
        }

        System.out.print("Enter transfer amount: Rs.");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (account.withdraw(amount)) {

            recipient.deposit(amount);

            transactions.add(
                    new Transaction(
                            "TRANSFER",
                            amount,
                            "Transferred to account "
                                    + recipient.getAccountId()
                    )
            );

            System.out.println("Transfer successful!");
            System.out.println("Remaining Balance: Rs."
                    + account.getBalance());

        } else {

            System.out.println("Insufficient Funds!");
        }
    }

    private void showTransactionHistory() {

        System.out.println("\n====== TRANSACTION HISTORY ======");

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}