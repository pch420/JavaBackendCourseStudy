package com.car;

public class CarTest {

	public static void main(String[] args) {

		// Car type의 객체 배열을 2개 만든다
		Car[] c = new Car[2];
		// 배열에 사용데이터에서 제공된 2개의 Car 객체를 넣는다.
		c[0] = new L3("L3", "1500", 50, 25, 0);
		c[1] = new L5("L5", "2000", 70, 35, 0);
		// 생성된 자동차의 기본 정보 출력
		System.out.println("vehicleName engineSize oilTank oilSize distance temperature");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("%s \t %s \t %d \t %d \t %d \t %d\n", c[0].getName(), c[0].getEngine(), c[0].getOilTank(),
				c[0].getOilSize(), c[0].getDistance(), ((L3) c[0]).getTempGage());
		System.out.printf("%s \t %s \t %d \t %d \t %d \t %d\n", c[1].getName(), c[1].getEngine(), c[1].getOilTank(),
				c[1].getOilSize(), c[1].getDistance(), ((L5) c[1]).getTempGage());

		// 각각의 자동차에 25씩 주유 한다
		System.out.println("25 주유");
		c[0].setOil(25);
		c[1].setOil(25);
		// 25씩 주유한 자동차의 정보를 출력 한다
		System.out.println("vehicleName engineSize oilTank oilSize distance temperature");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("%s \t %s \t %d \t %d \t %d \t %d\n", c[0].getName(), c[0].getEngine(), c[0].getOilTank(),
				c[0].getOilSize(), c[0].getDistance(), ((L3) c[0]).getTempGage());
		System.out.printf("%s \t %s \t %d \t %d \t %d \t %d\n", c[1].getName(), c[1].getEngine(), c[1].getOilTank(),
				c[1].getOilSize(), c[1].getDistance(), ((L5) c[1]).getTempGage());

		// 각각의 자동차에 80씩 주행 한다
		System.out.println("25 주유");
		c[0].go(80);
		c[1].go(80);

		// 80씩 주행한 정보를 출력 하며 엔진온도 정보를 출력 한다
		System.out.println("vehicleName engineSize oilTank oilSize distance temperature");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("%s \t %s \t %d \t %d \t %d \t %d\n", c[0].getName(), c[0].getEngine(), c[0].getOilTank(),
				c[0].getOilSize(), c[0].getDistance(), ((L3) c[0]).getTempGage());
		System.out.printf("%s \t %s \t %d \t %d \t %d \t %d\n", c[1].getName(), c[1].getEngine(), c[1].getOilTank(),
				c[1].getOilSize(), c[1].getDistance(), ((L5) c[1]).getTempGage());
	}

}
