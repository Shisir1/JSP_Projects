 package chapter15;

public class Customer {

	private final String id, firstName, lastName;
	double balance;

	public Customer(String id,
			String firstName,
			String lastName,
			double balance) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public String getFirstName(){
		return(firstName);
	}
	
	public String getLirstName(){
		return(lastName);
	}
	
	public double getBalance(){
		return(balance);
	}
	
	public String getBalanceNoSign() {
		String balanceString =
				String.format("%,.2f", Math.abs(balance));
		return(balanceString);
	}

}
