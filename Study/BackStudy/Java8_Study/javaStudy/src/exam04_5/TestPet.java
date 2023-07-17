package exam04_5;

// 하나의 클래스에서 여러개의 클래스 정의 가능 ==> 개인적으로 실습할 때 사용한다. <실무에서 사용하면 안됨>
// public은 하나의 클래스만 사용가능(main)
class Cat {

	String name;
	int age;
	String sex;

	public Cat() {
	}

	public Cat(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

} // end Cat

public class TestPet {

	// PDT ( call by value )
	public static void pdt(int x) {
		x = 20;
	}

	// RDT ( call by value reference)
	public static void rdt(Cat x) {
		x.setAge(10);
	}

	public static void main(String[] args) {

		// 기본형
		int n = 10;
		System.out.println("호출전:" + n);
		pdt(n); // call by value
		System.out.println("호출후:" + n);

		// 참조형
		Cat c = new Cat("야옹이", 2, "암컷");
		System.out.println("호출전 나이:" + c.getAge());
		rdt(c); // call by value reference
		System.out.println("호출후 나이:" + c.getAge());

	}

} // end TestPet
