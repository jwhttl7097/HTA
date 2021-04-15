package sample4;

public class Order {

	private Product item;
	private int amount;

	public Order(Product item, int amount) {
		super();
		this.item = item;
		this.amount = amount;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product getItem() {
		return item;
	}

	public void setItem(Product item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
