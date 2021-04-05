package day1;

public class LaserPrinter extends Printer{

	@Override
	public void print() {
		System.out.println("레이저 흑백 출력");
		
	}
	
	@Override
	public void refill() {
		System.out.println("토너를 리필 합니다.");
	}
}
