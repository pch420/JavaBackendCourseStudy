package com.car;

public class L3 extends Car implements Temp {

	public L3() {
		// TODO Auto-generated constructor stub
	}

	public L3(String name, String engine, int oilTank, int oilSize, int distance) {
		super(name, engine, oilTank, oilSize, distance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void go(int distance) {
		int oil = getOilSize();
		int load = getDistance();
		oil -= distance / 10;

		setOilSize(oil);
		setDistance(load + distance);

	}

	@Override
	public void setOil(int oilSize) {
		int oil = getOilSize();
		oil += oilSize;
		setOilSize(oil);

	}

	@Override
	public int getTempGage() {
		int temp = 0;
		temp += getDistance() / 10;
		return temp;
	}

}
