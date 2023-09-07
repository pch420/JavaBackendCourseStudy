package stu3;

public class Product {
	
	private int id;
	private boolean isSale;
	private String name;
	private int price;
	
	public Product(int id, boolean isSale, String name, int price) {
		super();
		this.id = id;
		this.isSale = isSale;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isSale() {
		return isSale;
	}
	public void setSale(boolean isSale) {
		this.isSale = isSale;
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
	@Override
	public String toString() {
		return name+" 가격 : "+price;
	}
}
