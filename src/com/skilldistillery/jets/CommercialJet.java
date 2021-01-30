package com.skilldistillery.jets;

public class CommercialJet extends Jet{

	private int passCapacity;
	
	@Override
	public void fly() {
		
		System.out.println(getModel()+ " is a type of aircraft for transporting passengers and air cargo.  ");
		System.out.println();
		System.out.println("Its speed is: "+ getSpeed() + "/mph " + "with a range of: "+ getRange()+"/km");
		System.out.println();
		System.out.println("The amount of time the jet can fly until it runs out of fuel is approximatly:  "+Math.round((double)(getRange() / getSpeed()))+ "hrs.");
		System.out.println();
	}
	public CommercialJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}


	public int getPassCapacity() {
		return passCapacity;
	}

	public void setPassCapacity(int passCapacity) {
		this.passCapacity = passCapacity;
	}

	public CommercialJet() {
		super();
	}


	@Override
	public String toString() {
		return "Commercial Jet " + super.toString();
	}
	
	
	
	
}
