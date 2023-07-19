package exam06_5;

// Cat is a Pet ==> 상속관계
public class Cat extends Pet {

	public Cat() {
	}

	public Cat(String name, int age) {
		super(name, age);
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

}
