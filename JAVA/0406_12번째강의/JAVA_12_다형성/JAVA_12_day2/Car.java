package day2;

public class Car {
	
	private String color;
	
	
	// Getter/Setter 메소드
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void drive() {
		System.out.println("Driving....");
	}
	
	public void stop() {
		System.out.println("Stop!");
	}

}
