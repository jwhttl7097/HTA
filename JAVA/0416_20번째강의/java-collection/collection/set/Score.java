package collection.set;

import java.util.Comparator;

public class Score implements Comparable<Score> {

	private String name;
	private int kor;
	private int eng;
	private int math;

	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {
		return kor + eng + math;
	}

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
	
	
	@Override
	public int compareTo(Score other) {
		return this.getTotal() - other.getTotal();
	}
	

}
