package cafe;

public class Cafe {
	private Coffee[] coffeeList = new Coffee[3];
	private int index = 0;

	public Cafe() {
		// TODO Auto-generated constructor stub
	}

	public int totalPrice() {
		int totalPrice = 0;
		for (Coffee c : coffeeList) {
			totalPrice += c.getPrice();
		}
		return totalPrice;
	}

	public void setCoffee(Coffee coffee) {
		if (index < 3) {
			coffeeList[index] = coffee;
			index++;
		} else {
			System.out.println("더 이상 저장할 수 없습니다.");
		}

	}

	public Coffee[] getCoffeeList() {
		return coffeeList;
	}
}
