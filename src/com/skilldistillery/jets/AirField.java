package com.skilldistillery.jets;

import java.util.ArrayList;

public class AirField {

	private ArrayList<Jet> jets = new ArrayList<Jet>();

	public AirField(ArrayList<Jet> jets) {
		super();
		this.jets = jets;
	}

	public AirField() {
		super();
	}
	
	
	public void addJet(Jet jet) {

		jets.add(jet);	
	}
	
	public ArrayList<Jet> getJets(){
		return jets;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jets == null) ? 0 : jets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirField other = (AirField) obj;
		if (jets == null) {
			if (other.jets != null)
				return false;
		} else if (!jets.equals(other.jets))
			return false;
		return true;
	}
	
//.	
	
}
