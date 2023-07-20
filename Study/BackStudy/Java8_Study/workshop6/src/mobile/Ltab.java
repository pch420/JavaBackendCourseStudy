package mobile;

public class Ltab extends Mobile {

	public Ltab() {
		// TODO Auto-generated constructor stub
	}

	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int operate(int time) {
		int operate = getBatterySize() - (time * 10);
		setBatterySize(operate);
		return operate;
	}

	@Override
	public int charge(int time) {
		int charge = getBatterySize() + (time * 10);
		setBatterySize(charge);
		return charge;
	}

}
