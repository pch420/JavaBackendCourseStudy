package exam07_2;

public class Cat extends Pet {

	public void run() {
		System.out.println("Cat.run");
	}

	// 오버라이딩
	@Override
	public void eat() {
		System.out.println("Cat.eat");

	}

	@Override
	public void sleep() {
		System.out.println("Cat.sleep");

	}

	public Cat() {
	}

	public Cat(String name, int age) {
		super(name, age);
	}

	@Override
	public String toString() {
		return String.format("Cat 이름: %s, Cat 나이:%d \n", name, age);
	}

}
