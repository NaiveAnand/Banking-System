

public class Accounts {
	private int accno;
	private static int saccno = 20354;
	private String name;
	private String branchCity;
	private int balance;
	
	public Accounts(String name, String city, int balance) {
		this.name = name;
		this.branchCity = city;
		this.balance = balance;
		this.accno = saccno++;
		
	}

	@Override
	public String toString() {
		return "[accno=" + accno + ", name=" + name + ", city=" + branchCity + ", balance=" + balance + "]";
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public static int getSaccno() {
		return saccno;
	}

	public static void setSaccno(int saccno) {
		Accounts.saccno = saccno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return branchCity;
	}

	public void setCity(String city) {
		this.branchCity = city;
	}

	public int getBal() {
		return balance;
	}

	public void setBal(int balance) {
		this.balance = balance;
	}

}