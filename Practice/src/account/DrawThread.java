package account;

public class DrawThread extends Thread {
	private Account account;
	private double drawAmount;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public double getDrawAmount() {
		return drawAmount;
	}
	public void setDrawAmount(double drawAmount) {
		this.drawAmount = drawAmount;
	}
	
	
	public DrawThread(String threadName, Account account, double drawAmount) {
		super(threadName);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	@Override
	public void run() {
		getAccount().draw(drawAmount);
	}

}
