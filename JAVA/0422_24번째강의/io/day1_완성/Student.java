package day1;

public class Student implements Comparable<Student> {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int average;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
	    this.average = this.total/3;

	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compareTo(Student other) {
		return this.total - other.total;
	}
	

}
