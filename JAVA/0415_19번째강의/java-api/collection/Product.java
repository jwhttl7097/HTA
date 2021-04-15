package collection;

public class Product implements Comparable<Product> {

	private int no;
	private String name;
	private int price;
	private int point;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int no, String name, int price, int point) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.point = point;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		result = prime * result + point;
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		if (point != other.point)
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	/*
	 * compareTo의 원리 
	 * 값1 - 값2 > 0 -> 값1이 크다
	 * 값1 - 값2 = 0 -> 값이 같다
	 * 값1 - 값2 < 0 -> 값2가 크다
	 * 위와 같은 논리로 크거나 작은값을 구해 정렬 하는 원리이다.
	 * compareTo를 이용해 main클래스에서 Collections.sort를 사용하려면 먼저 해당 객체클래스에
	 * public class Product implements Comparable<Product> 
	 * 위와 같이 implements Comparable<Product>를 선언해줘야 한다.
	 */
	
//	상품번호순 으로 정렬
	@Override
	public int compareTo(Product other) {
		return this.no - other.no;
	}
	
//	상품이름순 으로 정렬 (문자열은 String.comparTo()메소드를 사용하면됨)
//	@Override
//	public int compareTo(Product other) {
//		return this.name.compareTo(other.name) ;
//	}
	
	

}
