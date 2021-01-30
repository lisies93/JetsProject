package com.skilldistillery.jets;

public class PrivateJet extends Jet implements BoardPlane{
    
	private int maxPass;
	
	@Override
	public void fly() {
		System.out.println(getModel()+ " is a jet aircraft designed for transporting small groups of people.  ");
System.out.println("Its speed is: "+ getSpeed() + " " + "with a range of: "+ getRange());
System.out.println("The amount of time the jet can fly until it runs out of fuel is approximatly:  "+((double)(getRange() / getSpeed())));
	}
	
	public PrivateJet(String model, double speed, int range, long price, int maxPass) {
		super(model, speed, range, price);
		this.maxPass = maxPass;
	}

	public int getMaxPass() {
		return maxPass;
	}

	public void setMaxPass(int maxPass) {
		this.maxPass = maxPass;
	}

	@Override
	public String toString() {
		return "PrivateJet [maxPass=" + maxPass + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void boardPassengers() {
		System.out.println("Im a private jet and im boarding all my passengers....");
		
	}

	
	
	
	
	
}
