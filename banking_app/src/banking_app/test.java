package banking_app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		System.out.println("welcome to BANK bank!");
		
		Scanner scanner = new Scanner(System.in);
        Connection connection = jdbc_connection.getConnection();
        if (connection == null) {
            System.out.println("❌ Unable to connect to the database. Exiting...");
            return;
        }
        
        fetch_deets fetchDeets = new fetch_deets(connection);
        user_deets userDeets = new user_deets(0, 0, "", "", "", ""); // Placeholder
        BankService bankService = new BankService(userDeets, fetchDeets);
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users user = null;
        try {
            user = fetchDeets.getUserByUsername(username);
        } catch (SQLException e) {
            System.out.println("❌ Error fetching user.");
            e.printStackTrace();
        }

        if (user == null) {
            System.out.println("❌ User not found.");
            return;
        }

        // 🔍 Add these lines here for debugging
        System.out.println("Fetched password: " + user.getpwd());
        System.out.println("Entered password: " + password);

        // 🔐 Password check
        if (!user.getpwd().trim().equals(password.trim())) {
            System.out.println("❌ Invalid credentials. Access denied.");
            return;
        }


        int userId = user.getUserId();
        
        int flag = 1;
        // menu loop 
        while(flag == 1) {
        	System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check Balance");
            System.out.println("4. Edit Profile");
            System.out.println("5. Change Password");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        if (bankService.deposit(userId, depositAmount)) {
                            System.out.println("✅ Deposit successful.");
                        } else {
                            System.out.println("❌ Deposit failed.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();
                        if (bankService.withdraw(userId, withdrawAmount)) {
                            System.out.println("✅ Withdrawal successful.");
                        } else {
                            System.out.println("❌ Withdrawal failed.");
                        }
                        break;

                    case 3:
                        double balance = bankService.checkBalance(userId);
                        System.out.println("💰 Current Balance: ₹" + balance);
                        break;

                    case 4:
                        System.out.println("Edit Profile:");
                        System.out.println("1. Change Name");
                        System.out.println("2. Change Address");
                        System.out.println("3. Change Email");
                        System.out.println("4. Change Phone");
                        int editChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (editChoice) {
                            case 1:
                                System.out.print("Enter new name: ");
                                String newName = scanner.nextLine();
                                bankService.updateUserName(userId, newName);
                                System.out.println("✅ Name updated.");
                                break;
                            case 2:
                                System.out.print("Enter new address: ");
                                String newAddress = scanner.nextLine();
                                bankService.updateUserAddress(userId, newAddress);
                                System.out.println("✅ Address updated.");
                                break;
                            case 3:
                                System.out.print("Enter new email: ");
                                String newEmail = scanner.nextLine();
                                bankService.updateUserEmail(userId, newEmail);
                                System.out.println("✅ Email updated.");
                                break;
                            case 4:
                                System.out.print("Enter new phone: ");
                                String newPhone = scanner.nextLine();
                                bankService.updateUserPhone(userId, newPhone);
                                System.out.println("✅ Phone updated.");
                                break;
                            default:
                                System.out.println("❌ Invalid profile option.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        bankService.changePassword(userId, newPassword);
                        System.out.println("✅ Password changed.");
                        break;

                    case 6:
                        System.out.println("👋 Thank you for using Bank Bank. Goodbye!");
                        return;

                    default:
                        System.out.println("❌ Invalid choice. Try again.");
                }
            }
            catch (SQLException e) {
                System.out.println("❌ Operation failed due to a database error.");
                e.printStackTrace();
            }
            
            System.out.print("\n Do you want to continue? 1. for yes, 2. for no");
            flag = scanner.nextInt();
            if (flag==2) {
            	System.out.println("thank you, bubye");

            }
//            if(answer=="yes") {
//            	flag=1;
//            }
//            else {
//            	flag = 0;
//            	System.out.println("thank you");
//            }
            
        }
	}

}
