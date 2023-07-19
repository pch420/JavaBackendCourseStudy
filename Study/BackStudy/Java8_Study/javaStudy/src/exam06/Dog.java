package exam06;

public class Dog {

	String name;
	int age;
	String sex;

	public Dog() {
	}

	public Dog(String name, int age, String sex) {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void eat() {
		System.out.println("Dog.eat");
	}

	public void sleep() {
		System.out.println("Dog.sleep");
	}

}
