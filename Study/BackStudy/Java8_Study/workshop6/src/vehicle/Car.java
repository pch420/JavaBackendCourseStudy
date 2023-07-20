package vehicle;

public class Car extends Vehicle {
	private double restOil;
	private int curWeight;

	public Car() {
	}

	public Car(int maxWeight, double oilTankSize, double efficiency) {
		super(maxWeight, oilTankSize, efficiency);
	}

	public void addOil(int oil) {
		if (restOil + oil <= getOilTankSize()) {
			restOil += oil;
		} else {
			System.out.println("오일탱크크기를 초과합니다.");
		}
	}

	public void moving(int distance) {
		restOil -= (distance / getEfficiency());
	}

	public void addWeight(int weight) {
		if (curWeight + weight <= getMaxWeight()) {
			curWeight += weight;
		} else {
			System.out.println("최대적재중량을 초과합니다.");
		}
	}

	@Override
	public String toString() {
		return super.toString() + " \t " + restOil + " \t " + curWeight;
	}

	public double getRestOil() {
		return restOil;
	}

	public void setRestOil(double restOil) {
		this.restOil = restOil;
	}

	public int getCurWeight() {
		return curWeight;
	}

	public void setCurWeight(int curWeight) {
		this.curWeight = curWeight;
	}

}
