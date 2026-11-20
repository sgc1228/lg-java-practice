package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();

		try {
			System.out.println("=== 계좌 생성 ===");
			bank.createSavingsAccount("홍길동", 10000, 3.0);
			bank.createCheckingAccount("김철수", 20000, 5000);
			bank.createSavingsAccount("이영희", 30000, 2.0);
			System.out.println();

			bank.printAllAccounts();
			System.out.println();

			System.out.println("=== 입금/출금 테스트 ===");
			bank.deposit("AC1000", 5000);
			bank.withdraw("AC1001", 3000);
			System.out.println();

			System.out.println("=== 이자 적용 테스트 ===");
			Account account = bank.findAccount("AC1000");
			if (account instanceof SavingsAccount) {
				SavingsAccount savingsAccount = (SavingsAccount) account;
				savingsAccount.applyInterest();
			}
			System.out.println();

			System.out.println("=== 계좌 이체 테스트 ===");
			bank.transfer("AC1002", "AC1001", 5000);
			System.out.println();

			bank.printAllAccounts();
		} catch (AccountNotFoundException | InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		try {
			bank.withdraw("AC1001", 30000);
		} catch (WithdrawalLimitExceededException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		try {
			bank.withdraw("AC1001", 6000);
		} catch (WithdrawalLimitExceededException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.out.println("예외 발생: " + e.getMessage());
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		try {
			bank.findAccount("AC9999");
		} catch (AccountNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}
	}
}
