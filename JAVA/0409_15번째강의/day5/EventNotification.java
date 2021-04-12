package day5;

public class EventNotification {

	private Mail mail;
	private Messenger messenger;
	private SNS sns;
	
	// EventNotification객체가 의존하는 객체의 주소값을 전달받아서
	// 멤버변수에 대입하는 Setter메소드 정의
	// Setter메소드는 EventNotification객체가 필요로 하는 객체를
	// 제공하는 측에서 호출하는 메소드
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	
	public void setMessenger(Messenger messenger) {
		this.messenger = messenger;
	}
	
	public void setSns(SNS sns) {
		this.sns = sns;
	}
	
	public void notice(String from, String to, String title, String content) {
		// 메일, 메신저, SNS에 이벤트 내용 발송 및 포스팅하기
		mail.sendMail(from, to, title, content);
		messenger.send(to, from, content);
		sns.post(title, from, content);
	}
	
	
}
