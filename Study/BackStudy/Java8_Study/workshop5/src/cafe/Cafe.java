package cafe;

public class Cafe {

	// Cafe has a Coffee 목록
	private Coffee[] coffeeList;
	private int index;

	// 생성자 : 인스턴스 변수 초기화
	public Cafe() {
		coffeeList = new Coffee[3];
	}

	public int totalPrice() {
		int totalPrice = 0;
		for (Coffee coffee : coffeeList) {
			totalPrice += coffee.getPrice();
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
