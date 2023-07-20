package exam07_2;

public class TestPet {

	public static void main(String[] args) {

		// 1. 일반 객체 생성
		Cat c = new Cat("야옹이", 2);
		Dog d = new Dog("망치", 1, "수컷");
		Bird b = new Bird("까치", 1, "블랙");

		System.out.println(c); // 자동으로 c.toString() 호출된다.
		System.out.println(d); // 자동으로 d.toString() 호출된다.
		System.out.println(b); // 자동으로 b.toString() 호출된다.

//		System.out.printf("Cat 이름: %s, Cat 나이:%d \n", c.getName(), c.getAge());
//		System.out.printf("Dog 이름: %s, Dog 나이:%d, Dog 성별:%s \n", d.getName(), d.getAge(), d.getSex());
//		System.out.printf("Bird 이름: %s, Bird 나이:%d, Bird 색상:%s \n", b.getName(), b.getAge(), b.getColor());

	}

}
