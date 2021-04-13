package day6;

public class Product {
	
	private String name;
	private String size;
	private int price;
	
	public Product(String name, String size, int price) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public String getSize() {
		return size;
	}
	public int getPrice() {
		return price;
	}

}
