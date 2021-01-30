package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
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
		ja.run();

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
		System.out.println("|   2. Fly all jets                   |");
		System.out.println("|                                     |");
		System.out.println("|   3. View fastest jet               |");
		System.out.println("|                                     |");
		System.out.println("|   4. View jet with longest range    |");
		System.out.println("|                                     |");
		System.out.println("|   5. Load all Cargo Jets            |");
		System.out.println("|                                     |");
		System.out.println("|   6. Dogfight!                      |");
		System.out.println("|                                     |");
		System.out.println("|   7. Board Passengers               |");
		System.out.println("|                                     |");
		System.out.println("|   8. Add a jet to Fleet             |");
		System.out.println("|                                     |");
		System.out.println("|   9. Remove a jet from Fleet        |");
		System.out.println("|                                     |");
		System.out.println("|  10. Quit                           |");
		System.out.println("|                                     |");
		System.out.println("|                                     |");
		System.out.println("|                                     |");
		System.out.println("---------------------------------------");
	}

	private void run() {
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
					makeJetsFly();
					System.out.println();
					System.out.println();
					break;
				case 3:
					System.out.println();
					System.out.println();
					getFastestJet();
					System.out.println();
					System.out.println();
					break;
				case 4:
					System.out.println();
					System.out.println();
					getLongestRange();
					System.out.println();
					System.out.println();
					break;
				case 5:
					System.out.println();
					System.out.println();
					loadCargoJets();
					System.out.println();
					System.out.println();
					break;
				case 6:
					System.out.println();
					System.out.println();
					makeThemFight();
					System.out.println();
					System.out.println();
					break;
				case 7:
					System.out.println();
					System.out.println();
					boardPassengers();
					System.out.println();
					System.out.println();
					break;
				case 8:
					System.out.println();
					System.out.println();
					addJets();
					System.out.println();
					System.out.println();
					break;
				case 9:
					System.out.println();
					System.out.println();
					removeJet();
					System.out.println();
					System.out.println();
					break;
				case 10:
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

	private void listFleet() {
		int index = 1;

		for (Jet jet : af.getJets()) {
			System.out.println(index + ". " + jet);
			System.out.println();
			index++;
		}
	}

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
						System.out.println("Please enter Max Weight: ");
						maxWeight = kb.nextDouble();
						jet = new CargoPlane(model, speed, range, price, maxWeight);
						af.addJet(jet);
						go = false;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Invalid option please try again");
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
						System.out.println("Please enter number of Weapons: ");
						weapons = kb.nextInt();
						kb.nextLine();
						jet = new FighterJet(model, speed, range, price, weapons);
						af.addJet(jet);
						go = false;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Invalid option please try again");
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
						System.out.println("Please enter Max number of Passengers: ");
						numPass = kb.nextInt();
						kb.nextLine();
						jet = new PrivateJet(model, speed, range, price, numPass);
						af.addJet(jet);
						go = false;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Invalid option please try again");
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
						jet = new CommercialJet(model, speed, range, price);
						af.addJet(jet);
						go = false;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Invalid option please try again");
					}
				}

			} catch (InputMismatchException e) {
				System.err.println("Invalid option please try again");
				kb.nextLine();
			}

		}
	}

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
}
