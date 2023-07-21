package exam08_1;

import java.util.Random;

public class WrapperTest3 {

	public static void main(String[] args) {

		// 랜덤값 얻기
		Random r = new Random();

		// 랜덤값 고정 ==> seed 고정
		r.setSeed(1234);

		System.out.println("1. 임의의 정수값:" + r.nextInt());

		System.out.println("2. 지정된 범위내의 정수값:" + r.nextInt(3)); // 0,1,2
		System.out.println("2. 지정된 범위내의 정수값:" + (r.nextInt(10) + 1)); // 1 ~ 10

		System.out.println("3. 임의의 논리값:" + r.nextBoolean());

		System.out.println("4. 임의의 실수값(double):" + r.nextDouble());
		System.out.println("4. 임의의 실수값(float):" + r.nextFloat());

	}
}
