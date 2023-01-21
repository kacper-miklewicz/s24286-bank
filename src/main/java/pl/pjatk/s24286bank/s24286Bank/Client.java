package pl.pjatk.s24286bank.s24286Bank;

public class Client {
    private String ID;
    private double balance;

    public Client(String ID, double initialBalance) {
        this.ID = ID;
        this.balance = initialBalance;
    }

    public String getID() {
        return ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double value) {
        this.balance = value;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID='" + ID + '\'' +
                ", balance=" + balance +
                '}';
    }
}
