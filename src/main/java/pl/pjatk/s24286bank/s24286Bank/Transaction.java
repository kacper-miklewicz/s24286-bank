package pl.pjatk.s24286bank.s24286Bank;

public class Transaction {
    private TransactionStatus status;
    private double balanceAfterTransaction;

    public Transaction(TransactionStatus status, double balanceAfterTransaction) {
        this.status = status;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "status=" + status +
                ", balanceAfterTransaction=" + balanceAfterTransaction +
                '}';
    }
}
