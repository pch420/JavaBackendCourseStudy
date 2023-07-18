package cafe;

public class CafeTest {

	public static void main(String[] args) {

		Cafe cafe = new Cafe();
		cafe.setCoffee(new Coffee("Americano", 4000));
		cafe.setCoffee(new Coffee("Caffelatte", 5000));
		cafe.setCoffee(new Coffee("Macchiato", 6000));
		for (Coffee c : cafe.getCoffeeList()) {
			System.out.println(c.toString());
		}
		System.out.println();
		System.out.println("Coffee 가격의 합 :" + cafe.totalPrice() + "원");

	}

}
