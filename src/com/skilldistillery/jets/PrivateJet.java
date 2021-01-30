package com.skilldistillery.jets;

public class PrivateJet extends Jet implements BoardPlane{
    
	private int maxPass;
	
	@Override
	public void fly() {
		System.out.println(getModel()+ " is a jet aircraft designed for transporting small groups of people.  ");
		System.out.println();
		System.out.println("Its speed is: "+ getSpeed() + "/mph " + "with a range of: "+ getRange()+"/km");
System.out.println();
System.out.println("The amount of time the jet can fly until it runs out of fuel is approximatly:  "+Math.round((double)(getRange() / getSpeed()))+ "hrs.");
System.out.println();
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
		return "Private Jet " + super.toString() + " |maxPass: "+maxPass + "|";
	}

	@Override
	public void boardPassengers() {
		System.out.println("Im a private jet and im boarding all my passengers....");
		
	}
	
	
}
