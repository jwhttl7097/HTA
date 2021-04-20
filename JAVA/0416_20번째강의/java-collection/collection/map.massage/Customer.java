package collection.map.message;

public class Customer {
	private String name;			// 고객명
	private String[] messages;		// 메세지수신동의 종류, "sms", "kakaotalk", "email"

	public Customer(String name, String[] messages) {
		super();
		this.name = name;
		this.messages = messages;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

}
