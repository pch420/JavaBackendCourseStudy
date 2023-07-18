package school;

public class StudentTest {

	public static void main(String[] args) {
		double ageSum = 0.0;
		double heightSum = 0.0;
		double weightSum = 0.0;
		Student studentArray[] = new Student[3];
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);

		System.out.println("이름 나이 신장 몸무게");
		for (Student x : studentArray) {
			System.out.println(x.getName() + " " + x.getAge() + " " + x.getHeight() + " " + x.getWeight());
			ageSum += x.getAge();
			heightSum += x.getHeight();
			weightSum += x.getWeight();
		}
		System.out.println();

		System.out.println("나이의 평균: " + Math.round(ageSum / 3.0 * 100) / 100.0);
		System.out.println("신장의 평균: " + Math.round(heightSum / 3.0 * 100) / 100.0);
		System.out.println("몸무게의 평균: " + Math.round(weightSum / 3.0 * 100) / 100.0);

	}

}
