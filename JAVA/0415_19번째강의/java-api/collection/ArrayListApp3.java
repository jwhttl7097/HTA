package collection;

import java.util.ArrayList;
import java.util.Iterator;


public class ArrayListApp3 {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("유관순");
		names.add("안창호");
		names.add("유관순");
		names.add("안중근");
		
		System.out.println("### 이름에 '안'이 포함된 사람을 삭제하기");
//		foreach문 내부에서 ArrayList에 저장된 객체를 순서대로 조회중일 때
//		조회중인 그 객체를 삭제할 수 없다.
//		for (String name : names) {
//			if(name.startsWith("안")) {
//				names.remove(name);		//오류 발생
//			}
//		}
		
//		System.out.println(iter.hasNext() + ", " + iter.next());
//		System.out.println(iter.hasNext() + ", " + iter.next());
//		System.out.println(iter.hasNext() + ", " + iter.next());
//		System.out.println(iter.hasNext() + ", " + iter.next());
//		System.out.println(iter.hasNext() + ", " + iter.next());
//		System.out.println(iter.hasNext() + ", " + iter.next());
//		System.out.println(iter.hasNext() + ", " + iter.next());
		
		// iterator() 메소드는 자료구조의 각 요소를 반복해서 추출해주는 반복자객체를 반환한다.
		// Iterator<E>인터페이스에 담아준다.
		// iterator()메소드는 소모성 일회성이다.
		Iterator<String> iter = names.iterator();	
		while(iter.hasNext()) {		//iterator의 hasNext()메소드는 boolean값으로 값이 존재하는지 알려준다
									//while조건문에 hasNext()를 넣어서 false가 되면 종료되게 만든다.
			String name = iter.next();		
			if(name.startsWith("안")) {		// startsWith()메소드는 매개변수로 시작하는 이라는 뜻
				iter.remove();				// ArrayList 또는 HashSet 안에 저장된 데이터를 삭제하려면 foreach문으로 삭제가 불가능하다
			}								// 반드시Itorator를 생성하여 반복자에 넣어서 iterator참조변수.remove()를 이용해 삭제 할것
		}
		
		System.out.println("Iterator로 사람이름 출력하기");
		iter = names.iterator();	// iterator()메소드는 일회성이기 때문에 또 한번 반복자 로 얻으려면 다시 생성해줘야 한다.
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("foreach문으로 사람이름 출력하기");
		for (String name : names) {
			System.out.println(name);
			
		}
	}

}
