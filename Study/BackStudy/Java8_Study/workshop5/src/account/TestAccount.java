package account;

public class TestAccount {

	public static void main(String[] args) {

		/*
		 * 계좌정보: 441-0290-1203 현재잔액: 500000 출금 할 수 없습니다. 계좌정보: 441-0290-1203 현재잔액:
		 * 520000 이자: 37960.0
		 */
		Account a = new Account("441-0290-1203", 500000, 7.3);
		System.out.println("계좌정보:" + a.getAccount() + " 현재잔액:" + a.getBalance());
		a.deposit(600000);
		a.withdraw(20000);
		System.out.println("계좌정보:" + a.getAccount() + " 현재잔액:" + a.getBalance());
		System.out.println("이자: " + a.calculateInterest());

	}

}
