package exam04_1;

public class Cat {
	
	String name;
	int age;
	String sex;
	
	//생성자 ==> 오버로딩(overloading) 생성자라고 부른다.
	public Cat() {} // 기본생성자(default constructor) 인자리스트가 없는 생성자
	public Cat(String n) {}
	public Cat(int a) {}
	public Cat(String n, int a) {}
	public Cat(int a, String n ) {}

	public Cat(String name, int age, String sex) {
		this.name = name; // this.name 은 인스턴스 변수, name은 로컬변수
		this.age = age;
		this.sex = sex;
	}
	
	
}
