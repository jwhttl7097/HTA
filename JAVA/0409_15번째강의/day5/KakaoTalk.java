package day5;

public class KakaoTalk implements Messenger {
	
	@Override
	public void send(String to, String from, String text) {
		System.out.println("### 카카오톡으로 발송");
		System.out.println("----------------------------------------------");
		System.out.println("보내는 곳 : " + from);
		System.out.println("받는 곳 : " + to);
		System.out.println("내용 : " + text);
		System.out.println("----------------------------------------------");
	}
}
