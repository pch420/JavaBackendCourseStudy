package exam04_1;

public class Testpet {

	public static void main(String[] args) {

		// 고양이: 야옹이 2 암컷
		Cat c = new Cat("야옹이", 2, "암컷");

		System.out.println(c.name); // 맴버 접근( 권장안함 )
		System.out.println(c.age);
		System.out.println(c.sex);

	}

}
