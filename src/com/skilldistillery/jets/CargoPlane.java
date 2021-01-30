package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	private double maxWeight;

	@Override
	public void fly() {
		System.out.println(getModel()
				+ " is a fixed-wing aircraft that is designed or converted for the carriage of cargo rather than passengers.  ");
		System.out.println();
		System.out.println("Its speed is: "+ getSpeed() + "/mph " + "with a range of: "+ getRange()+"/km");
		System.out.println();
		System.out.println("The amount of time the jet can fly until it runs out of fuel is approximatly:  "
				+ Math.round((double)(getRange() / getSpeed()))+ "hrs.");
		System.out.println();
	}

	@Override
	public void loadCargo() {
		System.out.println("Im a cargo plane... I am loading cargo");

	}

	public CargoPlane(String model, double speed, int range, long price, double maxWeight) {
		super(model, speed, range, price);
		this.maxWeight = maxWeight;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public String toString() {
		return "Cargo Plane " + super.toString() + " |maxWeight: " + maxWeight + "|";
	}
}
