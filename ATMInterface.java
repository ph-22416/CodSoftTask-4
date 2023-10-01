import java.util.Scanner;

public class ATMInterface {
    private account account;

    public ATMInterface(account account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ATM Interface:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + account.getBalance());
                    break;

                case 2:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposited: $" + depositAmount);
                    break;

                case 3:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawn: $" + withdrawAmount);
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        account myAccount = new account(1000);  // Starting with $1000 balance
        ATMInterface atm = new ATMInterface(myAccount);
        atm.start();
    }
}
