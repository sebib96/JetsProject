package com.skilldistillery.entities;
//JetsImpl exists as a Generic Jet Class meaning a Jet object that does not fall into Fighter or Cargo category.

public class JetsImpl extends Jet {
	public JetsImpl() {
	}

	public JetsImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		AirField test = new AirField();
		test.fly();
	}

}
