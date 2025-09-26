package banking_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fetch_deets {
	Connection connection;

	public fetch_deets(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public users getUserByUsername(String username) throws SQLException{
		String query = "Select * from users where username =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                users user = new users();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setpwd(rs.getString("pwd"));
                return user;
            }
        }
		return null;
	}
	
	public double getBalance(int userId) throws SQLException {
	    String query = "SELECT balance FROM users WHERE user_id = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, userId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getDouble("balance");
	        }
	    }
	    return 0.0;
	}
	
	
	public boolean updateBalance(int userId, double newBalance) throws SQLException {
	    String query = "UPDATE users SET balance = ? WHERE user_id = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setDouble(1, newBalance);
	        stmt.setInt(2, userId);
	        return stmt.executeUpdate() > 0;
	    }
	}
	
	
	public boolean updatePassword(int userId, String newPassword) throws SQLException {
        String query = "UPDATE users SET pwd = ? WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, userId);
            return stmt.executeUpdate() > 0;
        }
    }
	
//	public boolean updateName(int userId, String newName) throws SQLException {
//        String query = "UPDATE personal_deets SET name = ? WHERE user_id = ?";
//        String query2 = "UPDATE users SET name = ? WHERE user_id = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setString(1, newName);
//            stmt.setInt(2, userId);
//            return stmt.executeUpdate() > 0;
//        }
//    }
	
	
	public boolean updateName(int userId, String newName) throws SQLException {
	    String query1 = "UPDATE personal_deets SET name = ? WHERE user_id = ?";
	    String query2 = "UPDATE users SET username = ? WHERE user_id = ?";

	    boolean success1 = false;
	    boolean success2 = false;

	    try (
	        PreparedStatement stmt1 = connection.prepareStatement(query1);
	        PreparedStatement stmt2 = connection.prepareStatement(query2)
	    ) {
	        // Update personal_deets
	        stmt1.setString(1, newName);
	        stmt1.setInt(2, userId);
	        success1 = stmt1.executeUpdate() > 0;

	        // Update users
	        stmt2.setString(1, newName);
	        stmt2.setInt(2, userId);
	        success2 = stmt2.executeUpdate() > 0;
	    }

	    // Return true only if both updates succeed
	    return success1 && success2;
	}

	
	public boolean updateAddress(int userId, String newAddress) throws SQLException {
        String query = "UPDATE personal_deets SET address = ? WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newAddress);
            stmt.setInt(2, userId);
            return stmt.executeUpdate() > 0;
        }
    }
	
	public boolean updateEmail(int userId, String newEmail) throws SQLException {
        String query = "UPDATE personal_deets SET email = ? WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, userId);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updatePhone(int userId, String newPhone) throws SQLException {
        String query = "UPDATE personal_deets SET phone = ? WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newPhone);
            stmt.setInt(2, userId);
            return stmt.executeUpdate() > 0;
        }
    }
	
}
