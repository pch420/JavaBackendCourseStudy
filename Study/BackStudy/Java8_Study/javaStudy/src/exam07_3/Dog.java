package exam07_3;

public class Dog extends Pet {

	String sex;

	// 오버라이딩은 강제가 아님
	public void eatDog() {
		System.out.println("Dog.eat");
	}

	public void sleepDog() {
		System.out.println("Dog.sleep");
	}

	public Dog() {
	}

	public Dog(String name, int age) {
		super(name, age);
	}

	public Dog(String name, int age, String sex) {
		super(name, age);
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
