package day5;

//Value Object -> VO
//Java beans(자바빈즈)라고도 부름
public class Contact {

	int no;
	String name;
	String email;
	String phone;
	
	public Contact() {}
	public Contact(int no, String name, String email, String phone) {
		this.no = no;
		this.name = name;
		this.email= email;
		this.phone = phone;
	}
	
}
