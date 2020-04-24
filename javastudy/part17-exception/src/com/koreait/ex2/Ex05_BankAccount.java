package com.koreait.ex2;

//은행계좌의 예외
@SuppressWarnings("serial")
class BankAccountException extends Exception {
	// 필드
	private int errCode;

	// Constructor
	public BankAccountException(int errCode, String message) {
		super(message);
		this.errCode = errCode;
	}

	public int getErrCode() {
		return errCode;
	}
}

//입금예외
@SuppressWarnings("serial")
class DepositException extends BankAccountException {// 에러코드1000

	public DepositException( String message) {
		super(1000, message);//예외코드1000
		
	}
	public DepositException(int errCode, String message) {
		super(errCode, message);
	
	}
   
	
	

	
}

//출금예외
class WithdeawException extends BankAccountException {// 에러코드2000

	
	public WithdeawException(int errCode, String message) {
		super(errCode, message); //예외코드 : 2000(음수)2001(잔고보다 큰출금)구분을위해 파라미터로 전달 받아야 한다..._.
	}
		

}

class BankAccount {
	// 필드
	private String no; // 계좌번호
	private long balance;// 잔액
	// constructor

	BankAccount(String no, long balance) {
		this.no = no;
		this.balance = balance;
	}

	// method
	// 1.입금
	public void deposit(long money) throws DepositException {
		if (money < 0) {
//			throw new DepositException("마이너스 금액은 입금불가");
			throw new DepositException(1000,"마이너스 금액은 입금불가");

		}
		balance += money;

	}

	// 2.출금
	public long withdraw(long money) throws WithdeawException {
		if (balance < money ) {
			throw new WithdeawException(2001,"잔고보다 출금액이 더큽니다");

		}else if(money < 0) {
			throw new WithdeawException(2000,"마이너스 금액은 출금불가");
		}
		balance -= money;
		return money;
	}

	// 3.조회
	public void inquiry() {
		System.out.println("계좌번호 " + no + "잔액은 :" + balance);
	}

	// 4.이체
	public void transfer(BankAccount you, long money) throws DepositException,WithdeawException {
		// 나의 출금은 곧 너의 입금.
		you.deposit(withdraw(money));
	}
}

public class Ex05_BankAccount {
	public static void main(String[] args) {
		BankAccount me = new BankAccount("123-456", 50_000);
		BankAccount you = new BankAccount("789-000", 100_000);
//		me.deposit(-10000);// 불가
//		me.deposit(10_000); // 현재잔액 60_000
//		me.withdraw(-10000);// 불가
//		me.withdraw(100000);// 불가
//		me.withdraw(10000);// 현재잔액 50_000
//		me.transfer(you, -10_000);// 불가
//		me.transfer(you, 10_000_000); // 불가
//		me.transfer(you, 10_000); // 현재잔액 40000 /you 110_000

		try {
			//me.transfer(you, 10_000);
//			me.transfer(you, -10000);
			me.deposit(-10000);
			me.transfer(you, 10000);
			me.inquiry();
			you.inquiry();
			
		}catch(BankAccountException e) {
			System.out.println("에러코드 : "+e.getErrCode() +" 에러메시지 : "+e.getMessage());
		}		
		
	}
}
