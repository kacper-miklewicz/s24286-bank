package pl.pjatk.s24286bank.s24286Bank;

public class Client {
    private String ID;
    private String name;
    private String surname;
    private double balance;

    public Client(String ID, String name, String surname, double initialBalance) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.balance = initialBalance;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }
}
