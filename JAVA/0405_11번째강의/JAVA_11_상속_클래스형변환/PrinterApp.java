package day1;

public class PrinterApp {

	public static void main(String[] args) {
		
		System.out.println("### Printer객체 사용하기");
		Printer p1 = new Printer();
		p1.refill();
		p1.print();
		
		System.out.println("### ColorPrinter객체 사용하기");
		ColorPrinter p2 = new ColorPrinter();
		p2.refill();
		p2.print();
		
		System.out.println("### LaserPrinter객체 사용하기");
		LaserPrinter p3 = new LaserPrinter();
		p3.refill();
		p3.print();
	}
}
