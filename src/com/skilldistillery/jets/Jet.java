package com.skilldistillery.jets;

public abstract class Jet {

	private String model;
	private double speed;
	private int range;
	private long price;
	private double machSpeed;
	private String type;
	
	public String getModel() {
		return model;
		}
	
	public void fly() {}
	
	public Jet() {}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
	public double getMachSpeed() {
		return machSpeed;
	}

	public void setMachSpeed(double machSpeed) {
		this.machSpeed = machSpeed;
	}

	public double getSpeedInMach(){
		this.machSpeed = speed * 0.001303;
		return machSpeed;
	}

	@Override
	public String toString() {
		return "|Model: " + model + "|, |speed/Mph: " + speed +" |machSpeed: " 
				+ getSpeedInMach()+ "|, |range: " + range + "|, |price: " + price + "|";
	}
	
	//.
	
	
}
