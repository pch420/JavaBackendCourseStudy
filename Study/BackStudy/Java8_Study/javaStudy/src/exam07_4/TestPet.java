package exam07_4;

public class TestPet {

	public static void main(String[] args) {

		Cat c = new Cat("야옹이", 2);
		Dog d = new Dog("망치", 1, "수컷");
		Bird b = new Bird("까치", 1, "블랙");

		c.eat();
		c.sleep();

		d.eat();
		d.sleep();

		b.eat();
		b.sleep();

		// 추상 클래스는 객체생성 불가
//		Pet p = new Pet();

		// 다형성 ( new는 불가능하지만 변수의 데이터타입으로 사용 가능 )
		Pet p = new Cat();

	}

}
