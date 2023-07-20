package exam07_1;

// Cat is a Pet ==> 상속관계
public class Cat extends Pet {

	// 생성자
	public Cat() {
		// 첫라인에서 super([값,,,]); 사용가능하다.
		super(); // 자동 삽입, 명시적 삽입시 반드시 첫라인에 삽입
		System.out.println("Cat 생성자");
	}

	public Cat(String name, int age) {
		// 부모에서 선언된 변수를 부모에서 초기화함
		super(name, age); // 권장
		System.out.println("Cat 생성자2");

		// 부모에서 선언된 변수를 자식이 초기화함.
//		this.name = name;
//		this.age = age;
	}

	public void run() {
		System.out.println("Cat.run");
	}

	// 메서드 재정의( overriding)
	// 올바른 재정의 가이드 기능
	// 재정의된 메서드임을 표시 기능
	@Override // @으로 시작하는 코드를 어노테이션(annotation) 이라고 부른다.
	public void eat() {
		System.out.println("Cat.eat");
	}

	@Override
	public void sleep() {
		System.out.println("Cat.sleep");
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}

}
