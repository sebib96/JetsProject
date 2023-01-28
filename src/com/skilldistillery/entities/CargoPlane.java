package com.skilldistillery.entities;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(){
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}

	@Override
	public void loadCargo() {
	System.out.println(this.getModel()+ " Is loading cargo...");
	}

	@Override
	public void fly() {
		int range = this.getRange();
		double topSpeed = this.getSpeed();
		int flightTime = (int) (range / topSpeed);
	System.out.println(this.getModel() + " takes off. Estimated fly time: " + flightTime);
		
	}
}
