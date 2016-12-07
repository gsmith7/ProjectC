public class BankAccount
{
	private String accountNumber;
	private String FormatedBalance;
	private double balance = 0;
	private double withdrawalFee = 0;
	private double annualInterestRate = 0;
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	public double getBalance() 
	{
		return this.balance;
	}
	public String getFormatedBalance()
	{
		this.FormatedBalance = String.format("%.2f", balance);
		return this.FormatedBalance;
	}
	public double getAnnualInterestRate()
	{
		return this.annualInterestRate;
	}
	public double getWithdrawalFee()
	{
		return this.withdrawalFee;
	}
	/**public BankAccount(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	public BankAccount(String accountNumber, double balance)
	{
		this.accountNumber = accountNumber;
		this.balance = balance  + this.balance;
	}**/
	public BankAccount(String accountNumber,  double balance, double withdrawalFee, double annualInterestRate)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.withdrawalFee = withdrawalFee;
		this.annualInterestRate = annualInterestRate;
	}
	
	public String deposit(double amount)
	{
		this.balance = balance + amount;
		this.FormatedBalance = String.format("%.2f", balance);
		return this.FormatedBalance;
	}
	public String withdraw(double amount)//----------------------------------------------------------?????????????????
	{
		this.balance = balance - (amount + withdrawalFee);
		this.FormatedBalance = String.format("%.2f", balance);
		return this.FormatedBalance;
	}
	public boolean isOverDrawn()
	{
		if (this.balance < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString()
	{
		String stringGiveBalance = new String("BankAccount " + accountNumber + ":");
		String balanceFormat = String.format("%.2f", balance);
		if (isOverDrawn()) {
			balanceFormat = balanceFormat.replace("-", "");
			return stringGiveBalance + " ($" + balanceFormat + ")";
		}
		else {
			return stringGiveBalance + " $" + balanceFormat;
		}
	}
	public void setAnnualInterestRate(double amount) 
	{
		this.annualInterestRate = amount;
		
	}
	public void setWithdrawalFee(double withdrawalFee)
	{
			this.withdrawalFee = withdrawalFee;
	}
	public void setBalance(double amount) {
		this.balance = amount; 
	}
}