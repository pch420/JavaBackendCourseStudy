package school2;

public class StudentTest {

	public static void main(String[] args) {

		Student studentArray[] = new Student[3];
		studentArray[0] = new Student("홍길동", 15, 170, 80);
		studentArray[1] = new Student("한사람", 13, 180, 70);
		studentArray[2] = new Student("임걱정", 16, 175, 65);

		double ageSum = 0;
		double heightSum = 0;
		double weightSum = 0;

		int max = 0;
		int min = 0;
		int searchMax = 0;
		int searchMin = 0;

		System.out.println("이름 나이 신장 몸무게");
		for (Student x : studentArray) {
			ageSum += x.getAge();
			heightSum += x.getHeight();
			weightSum += x.getWeight();
			System.out.println(x.studentInfo());
		}
		System.out.println();
		System.out.printf("나이 평균: %.3f", (Math.round(ageSum / 3 * 10000) / 10000.0));
		System.out.println();
		System.out.printf("신장 평균: %.3f", (Math.round(heightSum / 3 * 10000) / 10000.0));
		System.out.println();
		System.out.printf("몸무게 평균: %.3f", (Math.round(weightSum / 3 * 10000) / 10000.0));
		System.out.println();
		System.out.println();

		max = studentArray[0].getAge();
		min = studentArray[0].getAge();
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getAge() >= max) {
				max = studentArray[i].getAge();
				searchMax = i;
			}
			if (studentArray[i].getAge() <= min) {
				min = studentArray[i].getAge();
				searchMin = i;
			}

		}
		System.out.println("나이가 가장 많은 학생: " + studentArray[searchMax].getName());
		System.out.println("나이가 가장 적은 학생: " + studentArray[searchMin].getName());

		searchMax = 0;
		searchMin = 0;
		max = studentArray[0].getHeight();
		min = studentArray[0].getHeight();
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getHeight() >= max) {
				max = studentArray[i].getHeight();
				searchMax = i;
			}
			if (studentArray[i].getHeight() <= min) {
				min = studentArray[i].getHeight();
				searchMin = i;
			}

		}
		System.out.println("신장이 가장 큰 학생: " + studentArray[searchMax].getName());
		System.out.println("신장이 가장 작은 학생: " + studentArray[searchMin].getName());

		searchMax = 0;
		searchMin = 0;
		max = studentArray[0].getWeight();
		min = studentArray[0].getWeight();
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getWeight() >= max) {
				max = studentArray[i].getWeight();
				searchMax = i;
			}
			if (studentArray[i].getWeight() <= min) {
				min = studentArray[i].getWeight();
				searchMin = i;
			}

		}
		System.out.println("몸무게가 가장 많이 나가는 학생: " + studentArray[searchMax].getName());
		System.out.println("몸무게가 가장 적게 나가는 학생: " + studentArray[searchMin].getName());

	}

}
