package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * 학생 데이터에 대한 CRUD 기능을 제공한다.
 * 
 * 파일 데이터 로드 -> ArrayList에 저장
 * 학생데이터(ArrayList에 저장된)를 파일에 저장
 * 학생데이터에 대한 CRUD기능을 제공한다.
 * 		- Create
 * 			새로운 학생정보를 ArrayList에 저장한다.
 * 			void insertStudent(Student student)
 * 		- Read
 * 			ArrayList에 저장된 학생정보를 찾아서 반환한다.
 * 			ArrayList<Student> getAllStudents()
 * 			Student getStudentByName(String name)
 * 		- Update
 * 			AttauList에 저장된 학생정보를 변경한다.
 * 		- Delete
 * 			ArrayList에 저장된 학생정보를 삭제한다.
 * 			void removeStudentByName(String name)
 *  
 */

public class StudentRepository {
	
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public StudentRepository() {
		//객체 생성 직후에 생성자 메소드가 실행되기 때문에, 
		//StudentRepository객체가 생성된 후 loadData() 메소드를 실행함
		//따라서, StudentRepository객체가 생성된 후 텍스트파일의 내용을 읽어서
		//Student객체에 담고, 그 Student객체를 ArrayList객체에 추가한다.
		loadData();
	}
	
	// 텍스트데이터를 읽어서 students가 참조하는 ArrayList객체에 추가한다.
	private void loadData() {
		try (
				FileReader filereader = new FileReader("src/day1/students.txt");
				BufferedReader reader = new BufferedReader(filereader);
				){
			String text = null;
			while((text = reader.readLine()) != null) {
				// text <-- "김유신,100,100,100"
				// 1.text변수에 저장된 문자열을 ,를 구분자로 자른다 ->String[]이 획득됨
				String[] strs = text.split(",");
				// strs <-- {"김유신,100,100,100"}
				// 2. String[] 배열의 0번째부터 3번쨰 까지 값을 가져와서 적절한 변수에 대입한다.
				String name = strs[0];					// name <-- "김유신"
				int kor = Integer.parseInt(strs[1]);	// kor <-- 100 <-- Interger.parseInt("100")
				int eng = Integer.parseInt(strs[2]);	// eng <-- 100 <-- Interger.parseInt("100")
				int math = Integer.parseInt(strs[3]);	// math <-- 100 <-- Interger.parseInt("100")
				// 3. 2번에서 획득한 이름, 국어, 영어, 수학점수를 Student객체를 생성해서 담는다.
				Student st = new Student(name, kor, eng, math); //Student객체 <-- name : "김유신", kor:100, eng:100, math:100, total:300, average:100
				// 4. 학생성적정보가 들어있는 Student객체를 students참조변수가 참조하는 ArrayList객체에 추가한다.
				students.add(st);
				//블록내 코드가 한번 실행될 때마다 students가 참조하는 ArrayList객체에 Student객체주소값이 계속 저장된다.
	            //students <-- [Student객체주소값]
	            //students <-- [Student객체주소값, student 객체주소값]
	            //students <-- [Student객체주소값, student 객체주소값, student 객체주소값]
	            //students <-- [Student객체주소값, student 객체주소값, student 객체주소값, student 객체주소값]
	            //students <-- [Student객체주소값, student 객체주소값, student 객체주소값, student 객체주소값, student 객체주소값]

				
				
			}
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	// students가 참조하는 ArrayList객체에 저장된 학생정보를 파일로 저장한다.
	public void saveData() {
		try (PrintWriter writer = new PrintWriter("src/day1/students.txt");) {
			
			for (Student student : students) {
				// Student객체 <-- name:"김유신",kor:100, eng:100, math:100, total:300, average:100
				// 학생정보를 하나씩 StringBuilder객체의 내부저장소에 추가한다.
				StringBuilder sb = new StringBuilder();
				// sb -> []
				sb.append(student.getName())
				// sb -> ["김유신"]
					.append(",")
					// sb -> ["김유신", ",",]
					.append(student.getKor())
					// sb -> ["김유신", ",", 100]
					.append(",")
					// sb -> ["김유신", ",", 100, ","]
					.append(student.getEng())
					// sb -> ["김유신", ",", 100, ",", 100]
					.append(",")
					// sb -> ["김유신", ",", 100, ",", 100, ","]
					.append(student.getMath());
					// sb -> ["김유신", ",", 100, ",", 100, ",", 100]
				// StringBuilder객체의 내부저장소에 추가된 값을 하나의 문자열로 획득한다.
				String text = sb.toString();
				// text <-- "김유신,100,100,100"
				// PrintWriter객체의 println()메소드를 사용해서 text변수에 저장된 문자열을 파일로 내보낸다.
				writer.println(text);
				// text에 저장된 학생정보를 파일에 기록한다.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 모든 학생정보를 반환한다.
	public ArrayList<Student> getAllStudents(){
		// Student객체를 모두 저장하고 있는 ArrayList객체의 참조값을 반환한다.
		// students 참조변수가 그 참조값을 가지고 있으므로, students변수의 값을 반환한다. 
		return students;
	}
	
	// 모든 학생정보를 추가한다.
	public void insertStudent(Student student){
		students.add(student);
	}
	
	// 지정된 이름의 학생정보를 반환한다.
	public Student getStudentByName(String name) {
		for (Student student : students) {
			if(student.getName().equals(name)) {	// 이름이 일치하는 학생정보를 반환한다.
				return student;
			}
		}
		// 이름이 일치하는 학생정보가 존재하지 않으면 null이 반환된다.
		return null;
	}

	// 지정된 이름의 학생정보를 삭제한다.
	public void removeStudentByName(String name) {
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			if(student.getName().equals(name)) {
				iterator.remove();
				break;
			}
		}
	}
}
