package banking_app;

import java.sql.SQLException;

public class BankService {
	
	user_deets userdeets;
	fetch_deets fetchdeets;
	public BankService(user_deets userdeets, fetch_deets fetchdeets) {
		super();
		this.userdeets = userdeets;
		this.fetchdeets = fetchdeets;
	}
	
	
	public boolean deposit(int userID, double amount) throws SQLException{
		double currentBalance = fetchdeets.getBalance(userID);
		double newBalance = currentBalance + amount;
		return fetchdeets.updateBalance(userID,  newBalance);
	}
	
	public boolean withdraw(int userId, double amount) throws SQLException {
        double currentBalance = fetchdeets.getBalance(userId);
        if (currentBalance >= amount) {
            double newBalance = currentBalance - amount;
            return fetchdeets.updateBalance(userId, newBalance);
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }
	
	 // Check balance
    public double checkBalance(int userId) throws SQLException {
        return fetchdeets.getBalance(userId);
    }
    
    // Change password
    public boolean changePassword(int userId, String newPassword) throws SQLException {
        return fetchdeets.updatePassword(userId, newPassword);
    }
    
    
    public boolean updateUserName(int userId, String newName) throws SQLException {
        return fetchdeets.updateName(userId, newName);
    }

    public boolean updateUserAddress(int userId, String newAddress) throws SQLException {
        return fetchdeets.updateAddress(userId, newAddress);
    }

    public boolean updateUserEmail(int userId, String newEmail) throws SQLException {
        return fetchdeets.updateEmail(userId, newEmail);
    }

    public boolean updateUserPhone(int userId, String newPhone) throws SQLException {
        return fetchdeets.updatePhone(userId, newPhone);
    }

    

}
