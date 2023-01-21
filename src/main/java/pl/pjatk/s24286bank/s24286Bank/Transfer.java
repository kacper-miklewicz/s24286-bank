package pl.pjatk.s24286bank.s24286Bank;

public class Transfer {
    private TransferStatus status;
    private double balanceAfterTransfer;

    public Transfer(TransferStatus status, double balanceAfterTransfer) {
        this.status = status;
        this.balanceAfterTransfer = balanceAfterTransfer;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransfer;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "status=" + status +
                ", balanceAfterTransfer=" + balanceAfterTransfer +
                '}';
    }
}
