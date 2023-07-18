package book;

public class TestBook {

	public static void main(String[] args) {
		Book b1 = new Book("SQL Plus", 50000, 5.0);
		Book b2 = new Book("Java 2.0", 40000, 3.0);
		Book b3 = new Book("JSP Servlet", 60000, 6.0);
		
		System.out.println("책이름 가격 할인율 할인후금액");
		System.out.println("---------------------------------------------------------------");
		System.out.println(b1.getBookName() + " " + b1.getBookPrice() + "원 " + b1.getBookDiscountRate() + "% " + b1.getDiscountBookPrice() + "원");
		System.out.println(b2.getBookName() + " " + b2.getBookPrice() + "원 " + b2.getBookDiscountRate() + "% " + b2.getDiscountBookPrice() + "원");
		System.out.println(b3.getBookName() + " " + b3.getBookPrice() + "원 " + b3.getBookDiscountRate() + "% " + b3.getDiscountBookPrice() + "원");
	}

}
