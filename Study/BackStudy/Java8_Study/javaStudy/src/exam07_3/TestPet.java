package exam07_3;

public class TestPet {

	public static void main(String[] args) {

		Cat c = new Cat("야옹이", 2);
		Dog d = new Dog("망치", 1, "수컷");
		Bird b = new Bird("까치", 1, "블랙");

		// 다음 코드의 문제는 관리할 메서드의 양이 많아진다.
		c.eat();
		c.sleep();

		d.eatDog();
		d.sleepDog();

		b.eatBird();
		b.sleepBird();

	}

}
