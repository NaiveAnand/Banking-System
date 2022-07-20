

public class Accounts {
	private int accno;
	private static int saccno = 1000;
	private String name;
	private String city;
	private int balance;
	
	public Accounts(String name, String city, int balance) {
		this.name = name;
		this.city = city;
		this.balance = balance;
		this.accno = saccno++;
		//System.out.println("Account opened.. ||");
	}

	@Override
	public String toString() {
		return "[accno=" + accno + ", name=" + name + ", city=" + city + ", balance=" + balance + "]";
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
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getBal() {
		return balance;
	}

	public void setBal(int balance) {
		this.balance = balance;
	}

}