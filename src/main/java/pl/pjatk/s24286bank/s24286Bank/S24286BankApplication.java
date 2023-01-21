package pl.pjatk.s24286bank.s24286Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S24286BankApplication {
	private final BankingService bankingService;

	public S24286BankApplication(BankingService bankingService) {
		this.bankingService = bankingService;

		System.out.println(this.bankingService.makeTransfer("1", 100));
		System.out.println(this.bankingService.makeTransfer("1", 200));
		System.out.println(this.bankingService.depositMoney("1", 500));
	}

	public static void main(String[] args) {
		SpringApplication.run(S24286BankApplication.class, args);
	}

}
