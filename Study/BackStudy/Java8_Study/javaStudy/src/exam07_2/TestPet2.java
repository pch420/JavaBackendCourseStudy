package exam07_2;

public class TestPet2 {

	public static void main(String[] args) {

		// 다형성 활용

		// 1. 배열
		Pet[] pets = { new Cat("야옹이1", 2), new Dog("망치1", 1, "수컷"), new Dog("망치2", 2, "암컷"), new Cat("야옹이2", 1),
				new Bird("까치", 1, "블랙"), new Cat("야옹이3", 4) };

		// 이름과 나이만 출력
		for (Pet p : pets) {
			System.out.printf("이름: %s, 나이:%d \n", p.getName(), p.getAge());
		}

		// 고양이만 출력==> 배열에서 꺼냈을 때 누군지 식별하는 방법필요 ( 변수 instanceof 타입 연산자 )
		for (Pet p : pets) {
			if (p instanceof Cat) {
				System.out.printf("Cat 이름: %s, 나이:%d \n", p.getName(), p.getAge());
			}
		}

		// 강아지의 이름, 나이 , 성별 출력
		for (Pet p : pets) {
			if (p instanceof Dog) {

				// p타입이 pet에는 getSex() 없음
				// Pet 타입 --> Dog 타입
				Dog d = (Dog) p;

				System.out.printf("Dog 이름: %s, 나이:%d, 성별:%s \n", d.getName(), d.getAge(), d.getSex());
			}
		}

	}

}
