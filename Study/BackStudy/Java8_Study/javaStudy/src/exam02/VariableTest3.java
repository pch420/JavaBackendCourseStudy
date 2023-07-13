package exam02;

public class VariableTest3 {

	public static void main(String[] args) {

		// 변수 특징
		
		// 1. 중복 불가 (식별이 불가능하기 때문에)
		int num = 10;
//		int num = 20;  
		
		// 2. 블록 scope
		{
			int num2 = 100;
			System.out.println(num2);
		}
//		System.out.println(num2);
		
		// 3. 로컬변수 사용시 반드시 초기화해야 한다.
		int num3;
//		System.out.println(num3);
		
		//4. 변수 종류
		
		/*  교안 p82 참조
		 * 
		 *  가. 로컬변수
		 * 	
		 *  나. 인스턴스 변수
		 *  
		 *  다. 클래스 변수(static) 
		 *  
		 */

	}

}
