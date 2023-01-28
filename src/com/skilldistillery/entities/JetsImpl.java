package com.skilldistillery.entities;

public class JetsImpl extends Jet{

	public JetsImpl() {
	}
	
	public JetsImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		int range = this.getRange();
		double topSpeed = this.getSpeed();
		int flightTime = (int) (range / topSpeed);
	System.out.println(this.getModel() + " takes off. Estimated fly time: " + flightTime);
	}

}
