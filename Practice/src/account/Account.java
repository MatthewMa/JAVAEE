package account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	private boolean flag = false;
	private double balance;
	private String AccountNumber;
	public double getBalance() {
		return balance;
	}
	public void draw(double drawAmount) {
		lock.lock();
		try {
			if(!flag) {
				condition.await();
			}else {
				System.out.println("Draw sucessfully! Amount:" + drawAmount);
				balance = getBalance() - drawAmount;
				System.out.println("Current Balance:" + balance);
				condition.signalAll();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void deposit(double depositAmount) {
		lock.lock();
		try {
			if(!flag) {
				System.out.println("Deposit sucessfully! Amount:" + depositAmount);
				balance = getBalance() + depositAmount;
				System.out.println("Current Balance:" + balance);
				condition.signalAll();
			}else {
				condition.await();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public Account(double balance, String accountNumber) {
		super();
		this.balance = balance;
		AccountNumber = accountNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AccountNumber == null) ? 0 : AccountNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (AccountNumber == null) {
			if (other.AccountNumber != null)
				return false;
		} else if (!AccountNumber.equals(other.AccountNumber))
			return false;
		return true;
	}	
}
