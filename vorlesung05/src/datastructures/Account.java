package datastructures;

public class Account {

	private String userName;
	private int phoneNumber;
	

	public Account(String userName, int phoneNumber) {
		super();
		this.userName = userName;
		this.phoneNumber = phoneNumber;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	@Override
	public boolean equals(Object obj) {
		if (this.userName == ((Account) obj).getUserName())
			return true;
		if (this.phoneNumber == ((Account)obj).getPhoneNumber())
			return true;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	//TODO du musst auch die hashCode Methode implementieren

}
