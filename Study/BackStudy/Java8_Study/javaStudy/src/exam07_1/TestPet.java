package exam07_1;

public class TestPet {

	public static void main(String[] args) {

		
		Cat c = new Cat("야옹이", 2);
		
		System.out.println(c); // exam07_1.Cat@15db9742 ( 주소값 ), 패키지명.클래스명@16진수
		System.out.println(c.toString()); // exam07_1.Cat@15db9742 ( 주소값 )
		
	}

}
