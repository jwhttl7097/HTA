package collection.set;

import java.util.HashSet;
import java.util.Random;

public class HashSetApp3 {		//HashSet -> 중복허용 안함.

	public static void main(String[] args) {
		HashSet<Contact> contacts = new HashSet<Contact>();
		contacts.add(new Contact("홍길동", "010-1111-1111", "hong@gmail.com"));
		contacts.add(new Contact("홍길동", "010-1211-1111", "hong@gmail.com"));
		contacts.add(new Contact("김길동", "010-1111-1112", "kim@gmail.com"));
		contacts.add(new Contact("이길동", "010-1111-1113", "lee@gmail.com"));
		contacts.add(new Contact("박길동", "010-1111-1114", "park@gmail.com"));
		
		System.out.println("### 연락처 정보 출력하기");
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println("이름 : " + contact.getName());
			System.out.println("전화 : " + contact.getTel());
			System.out.println("메일 : " + contact.getEmail());
			System.out.println();
		}
		
	}

}
