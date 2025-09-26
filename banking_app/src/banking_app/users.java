package banking_app;

public class users {
    private int userId;
    private String username;
    private String pwd;
    private double balance;

    // Constructors
    public users() {}

    public users(int userId, String username, String passwordHash, double balance) {
        this.userId = userId;
        this.username = username;
        this.pwd = passwordHash;
        this.balance = balance;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getpwd() {
        return pwd;
    }

    public void setpwd(String passwordHash) {
        this.pwd = passwordHash;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}