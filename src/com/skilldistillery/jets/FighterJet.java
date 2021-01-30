package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	private int weapons;

	@Override
	public void fly() {
		System.out.println(getModel()+ " is a military fixed-wing aircraft designed primarily "
               	+ "for air-to-air combat against other aircraft" );
		System.out.println();
System.out.println("Its speed is: "+ getSpeed() + " " + "with a range of: "+ getRange());
System.out.println();
System.out.println("The amount of time the jet can fly until it runs out of fuel is approximatly:  "+((double)(getRange() / getSpeed())));
System.out.println();
	}
	
	@Override
	public void Fight() {
     System.out.println("Im a fighter jet and im combat ready!");		
	}

	public FighterJet(String model, double speed, int range, long price, int weapons) {
		super(model, speed, range, price);
		this.weapons = weapons;
	}

	public int getWeapons() {
		return weapons;
	}

	public void setWeapons(int weapons) {
		this.weapons = weapons;
	}

	@Override
	public String toString() {
		return "Fighter Jet " + super.toString() + " |weapons: "+ weapons+ "|";
	}
	
	
	
	
}
