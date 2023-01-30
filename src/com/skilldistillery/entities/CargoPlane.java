package com.skilldistillery.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}

	@Override
	public void loadCargo() {
		AirField test = new AirField();
		test.loadCargo();
	}

	@Override
	public void fly() {
		AirField test = new AirField();
		test.fly();
	}
}
