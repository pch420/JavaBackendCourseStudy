package vehicle;

public class VehicleTest {

	public static void main(String[] args) {

		Truck truck = new Truck();
		truck.setMaxWeight(1000);
		truck.setOilTankSize(100);
		truck.setEfficiency(5);
		
		System.out.println("최대적재중량 \t 오일탱크크기 \t 잔여오일량 \t 현재적재중량 \t 연비");
		System.out.println("===========================================================");
		System.out.println(truck.toString()+"\n");
		
		System.out.println("50L 주유 후");
		truck.addOil(50);
		System.out.println(truck.toString()+"\n");
		
		System.out.println("50km 주행 후");
		truck.moving(50);
		System.out.println(truck.toString()+"\n");
		
		System.out.println("100kg 적재 후");
		truck.addWeight(100);
		System.out.println(truck.toString()+"\n");
		
		System.out.println("30km 주행 후");
		truck.moving(30);
		System.out.println(truck.toString()+"\n");
		
		System.out.printf("요금 : %d원\n",truck.getCost(30));

	}

}
