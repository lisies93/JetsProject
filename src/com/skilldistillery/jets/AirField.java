package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.Collection;

public class AirField {

	private Collection<Jet> jets = new ArrayList<Jet>();

	public AirField(Collection<Jet> jets) {
		super();
		this.jets = jets;
	}

	public AirField() {
		super();
	}
	
	

	public void addJet(CargoPlane jet) {

		jets.add(jet);
		
	}

	public void addJet(FighterJet fighterJet) {
		
		jets.add(fighterJet);
	}

	public void addJet(CommercialJet commercialJet) {
		jets.add(commercialJet);
		
	}

	public void addJet(PrivateJet privateJet) {
		jets.add(privateJet);
		
	}
	
	public Collection<Jet> getJets(){
		return jets;
	}
	
	
	
}
