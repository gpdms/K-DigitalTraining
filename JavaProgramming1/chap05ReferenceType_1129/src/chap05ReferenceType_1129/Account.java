package chap05ReferenceType_1129;

public class Account {
	int balance = 0;
	int min_balance = 0;
	int max_balance=1000000;
	

	
	int setBalance(int balance){
		
		if(balance< min_balance || balance > max_balance) {
			return this.balance;
		} else {
			return this.balance += balance;
		}
	}
	
	int getBalance(){
		return this.balance;
	}
}
