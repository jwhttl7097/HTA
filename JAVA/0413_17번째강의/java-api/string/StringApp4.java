package string;

public class StringApp4 {

	/*
	 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	   2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	   3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	   4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	   5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	   6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	   7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	 */
	
	public static void main(String[] args) {
//		String src = "...!@BaT#*..y.abcdefghijklm";
		String src = "=.=";
		
		// 1단계, 대문자를 소문자로 변경
		src = src.toLowerCase();
		System.out.println("1단계 : " + src);
		
		// 2단계, 특수문자 제거
		// [^] : 브라켓안에 ^의미는 부정의 의미
		// [a-z] 소문자전부 [0-9] 숫자전부
		// [^a-z0-9-_.] : 영어소문자, 숫자, -, _, . 아닌것
		src = src.replaceAll("[^a-z0-9-_.]", "");
		System.out.println("2단계 : " + src);
		
		// 3단계, 마침표가 2개 이상이면 하나로
		// [.] 점을 의미
		// {min,max} min은 최소등장횟수, max는 최대등장횟수
		// [.]{2,} 점이 2개 이상인 것
		src = src.replaceAll("[.]{2,}", ".");
		System.out.println("3단계 : " + src);
		
		// 4단계, 마침표가 처음이나 끝에 있으면 제거
		// ^[.] 시작문자가 점인것 ^은 시작부분을 의미
		// \s공백의미
		src = src.replaceAll("^[.]", ""); // 맨처음 위치 
		// [.]$ 끝문자가 점인것 &는 끝부분을 의미
		src = src.replaceAll("[.]$", ""); // 마지막 위치
		System.out.println("4단계 : " + src);
		
		// 5단계, 빈문자열이 있으면 a를
		if(src.isEmpty()) {
			src = "a";
		}
		System.out.println("5단계 : " + src);
		
		// 6단계, 길이가 16자 이상이면 15개 이후에 숫자 제거
		if(src.length() >= 16) {
			src = src.substring(0, 15); // 해당 인덱스 문자들만 뽑아내기
			src = src.replaceAll("[.]$", ""); // 마지막 위치
		}
		System.out.println("6단계 : " + src);
		
		// 7단계, 길이가 2이하면 맨마지막글자를 길이가 3이 될떄까지 채운다.
		if(src.length() <= 2) {
			String lastChar = String.valueOf(src.charAt(src.length() -1));
			if (src.length() == 1) {
				src += lastChar;
			} 
			src += lastChar;
		}
		System.out.println("7단계 : " + src);
	}
}
