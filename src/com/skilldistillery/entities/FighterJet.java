package com.skilldistillery.entities;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet() {
	}
	
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println(this.getModel()+ " is engaging.");
	}

	@Override
	public void fly() {
		int range = this.getRange();
		double topSpeed = this.getSpeed();
		int flightTime = (int) (range / topSpeed);
	System.out.println(this.getModel() + " takes off. Estimated fly time: " + flightTime);
	}
	
	
}
