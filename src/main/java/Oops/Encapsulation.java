package Oops;

class Account {  
//private data members  
private long acc_no;  
private String name;  
private float amount;  

//getter and setter methods  
public long getAcc_no() {  
    return acc_no;  
}  
public void setAcc_no(long acc_no) {  
    this.acc_no = acc_no;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  

public float getAmount() {  
    return amount;  
}  
public void setAmount(float amount) {  
    this.amount = amount;  
}}  

public class Encapsulation extends Account{
	public static void main(String[] args) {  

		Encapsulation acc=new Encapsulation();
	    acc.setAcc_no(7560504000L);  
	    acc.setName("Sonoo Jaiswal");  
	    acc.setAmount(50000f);  
	   
	    System.out.println(acc.getAcc_no()+"\n"+acc.getName()+"\n"+acc.getAmount());  
	}  
	}  
