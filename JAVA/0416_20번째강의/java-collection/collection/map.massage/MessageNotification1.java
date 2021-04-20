package collection.map.message;

public class MessageNotification1 {

	private KakaoTalkMessageSender katalk = new KakaoTalkMessageSender();
	private EmailMessageSender email = new EmailMessageSender();
	private SmsMessageSender sms = new SmsMessageSender();
	
	public void notice(Customer customer, String from, String title, String content) {
		String[] messageTypes = customer.getMessages();
		for (String mt : messageTypes) {
			if("sms".equals(mt)) {
				sms.sendMessage(from, customer.getName(), title, content);
			} else if("katalk".equals(mt)) {
				katalk.sendMessage(from, customer.getName(), title, content);
			} else if("mail".equals(mt)) {
				email.sendMessage(from, customer.getName(), title, content);
			}
		}
	}
}
