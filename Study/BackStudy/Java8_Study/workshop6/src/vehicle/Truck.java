package vehicle;

public class Truck extends Car {

	public Truck() {
	}

	public Truck(int maxWeight, double oilTankSize, double efficiency) {
		super(maxWeight, oilTankSize, efficiency);

	}

	@Override
	public double getEfficiency() {

		return super.getEfficiency() - 0.2 * (getCurWeight() / 5);
	}

	@Override
	public void moving(int distance) {
		setRestOil(getRestOil() - calcOil(distance));

	}

	private double calcOil(int distance) {
		double calcOil;
		calcOil = distance / getEfficiency();

		return calcOil;
	}

	public int getCost(int distance) {
		int getCost;
		getCost = (int) calcOil(distance) * 3000;
		return getCost;
	}

	@Override
	public String toString() {

		return super.toString() + " \t " + getEfficiency();
	}

}
