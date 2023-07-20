package mobile;

public class Otab extends Mobile {

	public Otab() {
		// TODO Auto-generated constructor stub
	}

	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int operate(int time) {
		int operate = getBatterySize() - (time * 12);
		setBatterySize(operate);
		return operate;
	}

	@Override
	public int charge(int time) {
		int charge = getBatterySize() + (time * 8);
		setBatterySize(charge);
		return charge;
	}

}
