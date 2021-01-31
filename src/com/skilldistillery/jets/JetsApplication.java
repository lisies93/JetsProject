package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JetsApplication {

	Scanner kb = new Scanner(System.in);
	AirField af = new AirField();

	public static void main(String[] args) {

		JetsApplication ja = new JetsApplication();
		String fileName = "jets.txt";
		ja.readJetsFile(fileName);
		ja.run(fileName);

	}

	private void readJetsFile(String fileName) {

		String model;
		int range;
		double speed;
		long price;
		double maxWeight;
		int weapons;
		int numPass;
		Jet jet = null;

		// Reading text file with jets information

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetsRecord = line.split(",");
				String type = jetsRecord[0];
				switch (type) {
				case "cargo":
					model = jetsRecord[1];
					speed = Double.parseDouble(jetsRecord[2]);
					range = Integer.parseInt(jetsRecord[3]);
					price = Long.parseLong(jetsRecord[4]);
					maxWeight = Double.parseDouble(jetsRecord[5]);
					// adding objects to the list
					jet = new CargoPlane(model, speed, range, price, maxWeight);
					af.addJet(jet);
					break;
				case "fighter":
					model = jetsRecord[1];
					speed = Double.parseDouble(jetsRecord[2]);
					range = Integer.parseInt(jetsRecord[3]);
					price = Long.parseLong(jetsRecord[4]);
					weapons = Integer.parseInt(jetsRecord[5]);
					jet = new FighterJet(model, speed, range, price, weapons);
					af.addJet(jet);
					break;
				case "commercial":
					model = jetsRecord[1];
					speed = Double.parseDouble(jetsRecord[2]);
					range = Integer.parseInt(jetsRecord[3]);
					price = Long.parseLong(jetsRecord[4]);
					jet = new CommercialJet(model, speed, range, price);
					af.addJet(jet);
					break;
				case "private":
					model = jetsRecord[1];
					speed = Double.parseDouble(jetsRecord[2]);
					range = Integer.parseInt(jetsRecord[3]);
					price = Long.parseLong(jetsRecord[4]);
					numPass = Integer.parseInt(jetsRecord[5]);
					jet = new PrivateJet(model, speed, range, price, numPass);
					af.addJet(jet);
					break;
				}
			}

		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private void displayUserMenu() {

		System.out.println("---------------------------------------");
		System.out.println("|                                     |");
		System.out.println("|           Enter an option:          |");
		System.out.println("|                                     |");
		System.out.println("---------------------------------------");
		System.out.println("|                                     |");
		System.out.println("|   1. List fleet                     |");
		System.out.println("|                                     |");
		System.out.println("|   2. Fly jets individually          |");
		System.out.println("|                                     |");
		System.out.println("|   3. Fly all jets                   |");
		System.out.println("|                                     |");
		System.out.println("|   4. View fastest jet               |");
		System.out.println("|                                     |");
		System.out.println("|   5. View jet with longest range    |");
		System.out.println("|                                     |");
		System.out.println("|   6. Load all Cargo Jets            |");
		System.out.println("|                                     |");
		System.out.println("|   7. Dogfight!                      |");
		System.out.println("|                                     |");
		System.out.println("|   8. Board Passengers               |");
		System.out.println("|                                     |");
		System.out.println("|   9. Add a jet to Fleet             |");
		System.out.println("|                                     |");
		System.out.println("|   10. Remove a jet from Fleet       |");
		System.out.println("|                                     |");
		System.out.println("|   11. Create a new file with jets   |");
		System.out.println("|                                     |");
		System.out.println("|   12. Quit                          |");
		System.out.println("|                                     |");
		System.out.println("|                                     |");
		System.out.println("---------------------------------------");
	}

	private void run(String fileName) {
		JetsApplication ja = new JetsApplication();

		boolean option = true;
		int numOption = 0;

		while (option) {
			ja.displayUserMenu();

			try {

				numOption = kb.nextInt();
				kb.nextLine();
				switch (numOption) {
				case 1:
					System.out.println();
					System.out.println();
					listFleet();
					System.out.println();
					System.out.println();
					break;
				case 2:
					System.out.println();
					System.out.println();
					individualJet();
					System.out.println();
					System.out.println();
					break;
				case 3:
					System.out.println();
					System.out.println();
					makeJetsFly();
					break;
				case 4:
					System.out.println();
					System.out.println();
					getFastestJet();
					System.out.println();
					System.out.println();
					break;
				case 5:
					System.out.println();
					System.out.println();
					getLongestRange();
					System.out.println();
					System.out.println();
					break;
				case 6:
					System.out.println();
					System.out.println();
					loadCargoJets();
					System.out.println();
					System.out.println();
					break;
				case 7:
					System.out.println();
					System.out.println();
					makeThemFight();
					System.out.println();
					System.out.println();
					break;
				case 8:
					System.out.println();
					System.out.println();
					boardPassengers();
					System.out.println();
					System.out.println();
					break;
				case 9:
					System.out.println();
					System.out.println();
					addJets();
					System.out.println();
					System.out.println();
					break;
				case 10:
					System.out.println();
					System.out.println();
					removeJet();
					System.out.println();
					System.out.println();
					break;
				case 11:
					System.out.println();
					System.out.println();
					createNewFile(fileName);
					break;
				case 12:
					System.out.println();
					System.out.println("See You Later!");
					option = false;
					break;
				default:
					System.out.println();
					System.out.println();
					System.out.println("Invalid option please try again");
					System.out.println();
					System.out.println();
					break;
				}

			} catch (InputMismatchException e) {
				System.err.println("Invalid input please try again.");
				kb.nextLine();
			}

		}

	}

	// show all the jets
	private void listFleet() {
		int index = 1;

		for (Jet jet : af.getJets()) {
			System.out.println(index + ". " + jet);
			System.out.println();
			index++;
		}
	}

	// fly the jets individually
	private void individualJet() {

		boolean anotherJet = true;
		int selectedJet = 0;

		while (anotherJet) {

			int index = 1;
			System.out.println("Please select the jet that you want to fly today.");
			System.out.println();
			for (Jet jet : af.getJets()) {
				System.out.println(index + ". " + jet.getModel());
				System.out.println();
				index++;
			}

			try {
				selectedJet = kb.nextInt();
				selectedJet = selectedJet - 1;
				kb.nextLine();

				for (Jet jet : af.getJets()) {
					if (af.getJets().indexOf(jet) == selectedJet) {
						jet.fly();
						System.out.println();
						System.out.println();
						System.out.println("Do you want to fly another jet? (Y/N)");

						String yesOrNot = kb.nextLine();
						if ((yesOrNot.toUpperCase().equals("YES")) || (yesOrNot.toUpperCase().equals("Y"))) {
							anotherJet = true;
						} else {
							anotherJet = false;

						}

					}

				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid option please try again");
				kb.nextLine();
			}
		}

	}

// this method will show a short description of the jets
	public void makeJetsFly() {

		for (Jet jet : af.getJets()) {

			System.out.println();
			System.out.println();
			System.out.println(jet.toString());
			System.out.println();
			jet.fly();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

		}
	}

// will print the fastest jet
	public void getFastestJet() {

		Jet fastestJet = null;
		double max = 0;

		for (Jet jet : af.getJets()) {
			if (max < jet.getSpeed()) {
				max = jet.getSpeed();
				fastestJet = jet;
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("The fastest plane is: ");
		System.out.println();
		System.out.println(fastestJet);
	}

// will print the longest rate jet
	private void getLongestRange() {
		Jet longestRange = null;
		double max = 0;

		for (Jet jet : af.getJets()) {
			if (max < jet.getRange()) {
				max = jet.getRange();
				longestRange = jet;
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("The plane with the longest range is: ");
		System.out.println();
		System.out.println(longestRange);

	}

// will display all the cargo jets
	private void loadCargoJets() {

		for (Jet jet : af.getJets()) {
			if (jet instanceof CargoPlane) {
				System.out.println();
				System.out.println(jet.toString());
				System.out.println();
				((CargoPlane) jet).loadCargo();
				System.out.println();
			}
		}

	}

// will display all the fighter jets
	private void makeThemFight() {
		for (Jet jet : af.getJets()) {
			if (jet instanceof FighterJet) {
				System.out.println();
				System.out.println(jet.toString());
				System.out.println();
				((FighterJet) jet).Fight();
				System.out.println();
			}
		}
	}

// will display all the private jets
	private void boardPassengers() {
		for (Jet jet : af.getJets()) {
			if (jet instanceof PrivateJet) {
				System.out.println();
				System.out.println(jet.toString());
				System.out.println();
				((PrivateJet) jet).boardPassengers();
				System.out.println();
			}
		}
	}

// will add new jets to the list
	private void addJets() {
		int option = 0;
		boolean go = true;
		String model;
		int range;
		double speed;
		long price;
		double maxWeight;
		int weapons;
		int numPass;
		Jet jet = null;

		while (go) {
			System.out.println("Please select the type of yet that you want to add: ");
			System.out.println();
			System.out.println("1. Cargo Plane");
			System.out.println();
			System.out.println("2. Fighter Jet");
			System.out.println();
			System.out.println("3. Private Jet");
			System.out.println();
			System.out.println("4. Commertial Jet");

			try {
				option = kb.nextInt();
				kb.nextLine();

				switch (option) {
				case 1:
					try {
						System.out.println("Please enter Model: ");
						model = kb.nextLine();
						System.out.println("Please enter Speed: ");
						speed = kb.nextDouble();
						System.out.println("Please enter Range: ");
						range = kb.nextInt();
						kb.nextLine();
						System.out.println("Please enter Price: ");
						price = kb.nextLong();
						kb.nextLine();
						System.out.println("Please enter Max Weight: ");
						maxWeight = kb.nextDouble();
						jet = new CargoPlane(model, speed, range, price, maxWeight);
						af.addJet(jet);
						go = false;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Invalid option please try again");
						kb.nextLine();
					}
				case 2:
					try {
						System.out.println("Please enter Model: ");
						model = kb.nextLine();
						System.out.println("Please enter Speed: ");
						speed = kb.nextDouble();
						System.out.println("Please enter Range: ");
						range = kb.nextInt();
						kb.nextLine();
						System.out.println("Please enter Price: ");
						price = kb.nextLong();
						kb.nextLine();
						System.out.println("Please enter number of Weapons: ");
						weapons = kb.nextInt();
						kb.nextLine();
						jet = new FighterJet(model, speed, range, price, weapons);
						af.addJet(jet);
						go = false;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Invalid option please try again");
						kb.nextLine();
					}
				case 3:
					try {
						System.out.println("Please enter Model: ");
						model = kb.nextLine();
						System.out.println("Please enter Speed: ");
						speed = kb.nextDouble();
						System.out.println("Please enter Range: ");
						range = kb.nextInt();
						kb.nextLine();
						System.out.println("Please enter Price: ");
						price = kb.nextLong();
						kb.nextLine();
						System.out.println("Please enter Max number of Passengers: ");
						numPass = kb.nextInt();
						kb.nextLine();
						jet = new PrivateJet(model, speed, range, price, numPass);
						af.addJet(jet);
						go = false;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Invalid option please try again");
						kb.nextLine();
					}
				case 4:
					try {
						System.out.println("Please enter Model: ");
						model = kb.nextLine();
						System.out.println("Please enter Speed: ");
						speed = kb.nextDouble();
						System.out.println("Please enter Range: ");
						range = kb.nextInt();
						kb.nextLine();
						System.out.println("Please enter Price: ");
						price = kb.nextLong();
						kb.nextLine();
						jet = new CommercialJet(model, speed, range, price);
						af.addJet(jet);
						go = false;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Invalid option please try again");
						kb.nextLine();
					}
				default:
					System.out.println("Invalid option please try again.");
				}

			} catch (InputMismatchException e) {
				System.err.println("Invalid option please try again");
				kb.nextLine();
			}

		}
	}

// will remove any jet from the list
	private void removeJet() {
		String removeModel = "";
		boolean go = true;
		boolean removed = false;
		while (go) {

			System.out.println("Please select the jet that you want to remove ");
			System.out.println();
			for (Jet jet : af.getJets()) {
				System.out.println(jet.getModel());
				System.out.println();
			}

			try {
				removeModel = kb.nextLine();
				for (Jet jet : af.getJets()) {
					if (jet.getModel().toLowerCase().contains(removeModel)) {
						removed = af.getJets().remove(jet);
						go = false;
						break;
					}
				}

				if (removed) {
					System.out.println();
					System.out.println();
					System.out.println("You successfully removed the jet");
					go = false;
				} else {
					System.out.println("The model you entered was invalid please try again");
				}

			} catch (InputMismatchException e) {
				System.err.println("Invalid option please try again.");
			}
		}
	}
	
// will create a new file with the jets that were added
	private void createNewFile(String fileName) {

		String newFile = "";
		boolean created = true;
		
		while(created) {
			
		System.out.println("Please enter the name of the new file: ");
		newFile = kb.nextLine();
		
             
		if (!newFile.equals(fileName)) {
			try{
				
				FileWriter writer = new FileWriter(newFile); 
				for(Jet jet: af.getJets()) {
				  writer.write(jet.getClass().getSimpleName()+","+jet.getModel()+","+jet.getSpeed()+","+jet.getRange()+","+jet.getPrice() + System.lineSeparator());
				}
				writer.close();
				System.out.println();
				System.out.println();
				System.out.println("You successfully created a new file");
				System.out.println();
				System.out.println();
				created=false;

			}catch (IOException e) {
			    e.printStackTrace();
			}
		} else {
			System.out.println("The name that you entered already exists, please enter another name.");
			created = true;
		}
		}
	}
}
