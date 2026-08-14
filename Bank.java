import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();

        accounts.add(new Account("1001", "user1", 1234, 10000));
        accounts.add(new Account("1002", "user2", 5678, 15000));
    }

    public Account authenticate(String userId, int pin) {

        for (Account account : accounts) {
            if (account.getUserId().equals(userId)
                    && account.getPin() == pin) {
                return account;
            }
        }

        return null;
    }

    public Account findAccount(String accountId) {

        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }
}