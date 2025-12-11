package JavaConcepts.Oops;

//It is a process of wrapping code(methods) and data(fields) together into a single unit (class)
// and restricting direct access to some of the object's components.
class Account {
	//private data members
	private long acc_no;
	private String name;
	private float amount;

	//public getter and setter methods
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
}

public class Encapsulation extends Account{
	public static void main(String[] args) {  
		//if we dont have setter methods, others cant access/manipulate those data members
		Encapsulation acc=new Encapsulation();
	    acc.setAcc_no(7560504000L);  
	    acc.setName("Sonoo Jaiswal");
	   
	    System.out.println(acc.getAcc_no()+"\n"+acc.getName()+"\n"+acc.getAmount());  
	}  
}
