package school;

public class StudentTest {

	public static void main(String[] args) {
		double ageSum = 0.0;
		double heightSum = 0.0;
		double weightSum = 0.0;

		// 1. new 이용
		Student studentArray[] = new Student[3];
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);

		/*
		 * // 2. 리터럴 방법 Student[] studentArray2 = { new Student("홍길동", 15, 171, 81), new
		 * Student("한사람", 13, 183, 72), new Student("임걱정", 16, 175, 65) };
		 * 
		 * // 3. new + 리터럴 Student[] studentArray3 = new Student[] { new Student("홍길동",
		 * 15, 171, 81), new Student("한사람", 13, 183, 72), new Student("임걱정", 16, 175,
		 * 65) };
		 */

		System.out.println("이름 \t 나이 \t 신장 \t 몸무게");
		for (Student x : studentArray) {
			System.out.println(x.getName() + " \t " + x.getAge() + " \t " + x.getHeight() + " \t " + x.getWeight());
			ageSum += x.getAge();
			heightSum += x.getHeight();
			weightSum += x.getWeight();
		}
		System.out.println();

		System.out.println("나이의 평균: " + ageSum / 3);
		System.out.printf("나이의 평균: %.2f \n", ageSum / 3);
		System.out.println(String.format("나이의 평균: %.2f \n", ageSum / 3));

		System.out.printf("신장의 평균: %.2f \n", heightSum / 3);
		System.out.printf("몸무게의 평균: %.2f \n", weightSum / 3);

	}

}
