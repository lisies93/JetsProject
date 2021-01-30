package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
					af.addJet(new CargoPlane(model, speed, range, price, maxWeight));
					break;
				case "fighter":
					model = jetsRecord[1];
					speed = Double.parseDouble(jetsRecord[2]);
					range = Integer.parseInt(jetsRecord[3]);
					price = Long.parseLong(jetsRecord[4]);
					weapons = Integer.parseInt(jetsRecord[5]);
					af.addJet(new FighterJet(model, speed, range, price, weapons));
					break;
				case "commercial":
					model = jetsRecord[1];
					speed = Double.parseDouble(jetsRecord[2]);
					range = Integer.parseInt(jetsRecord[3]);
					price = Long.parseLong(jetsRecord[4]);
					af.addJet(new CommercialJet(model, speed, range, price));
					break;
				case "private":
					model = jetsRecord[1];
					speed = Double.parseDouble(jetsRecord[2]);
					range = Integer.parseInt(jetsRecord[3]);
					price = Long.parseLong(jetsRecord[4]);
					numPass = Integer.parseInt(jetsRecord[5]);
					af.addJet(new PrivateJet(model, speed, range, price, numPass));
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
		Collection<Jet> listFleet = new ArrayList<Jet>();
		listFleet.addAll(af.getJets());

		boolean option = true;
		int numOption = 0;

		while (option) {
			ja.displayUserMenu();

			try {

				numOption = kb.nextInt();
				kb.nextLine();
				switch (numOption) {
				case 1:
					listFleet(listFleet);
					break;
				case 2:
					makeJetsFly(listFleet);
					break;
				case 3:
					getFastestJet(listFleet);
					break;
				case 4:
					getLongestRange(listFleet);
					break;
				case 5:
					loadCargoJets(listFleet);
					break;
				case 6:
					makeThemFight(listFleet);
					break;
				case 7:
					boardPassengers(listFleet);
					break;
				case 8:
					removeJet(listFleet);

				}

			} catch (InputMismatchException e) {
				System.err.println("Invalid input please try again.");
			}

		}

	}

	private void listFleet(Collection<Jet> listFleet) {
		int index = 1;

		for (Jet jet : listFleet) {
			System.out.println(index + ". " + jet);
			System.out.println();
			index++;
		}
	}

	public void makeJetsFly(Collection<Jet> listFleet) {

		for (Jet jet : listFleet) {

			System.out.println(jet.toString());
			jet.fly();
			System.out.println();
			System.out.println();
			System.out.println();

		}
	}

	public void getFastestJet(Collection<Jet> listFleet) {

		Jet fastestJet = null;
		double max = 0;

		for (Jet jet : listFleet) {
			if (max < jet.getSpeed()) {
				max = jet.getSpeed();
				fastestJet = jet;
			}
		}

		System.out.println("The fastest plane is: ");
		System.out.println();
		System.out.println(fastestJet);
	}

	private void getLongestRange(Collection<Jet> listFleet) {
		Jet longestRange = null;
		double max = 0;

		for (Jet jet : listFleet) {
			if (max < jet.getRange()) {
				max = jet.getRange();
				longestRange = jet;
			}
		}

		System.out.println("The plane with the longest range is: ");
		System.out.println();
		System.out.println(longestRange);

	}

	private void loadCargoJets(Collection<Jet> listFleet) {

		for (Jet jet : listFleet) {
			if (jet instanceof CargoPlane) {
				System.out.println(jet.toString());
				((CargoPlane) jet).loadCargo();
				System.out.println();
			}
		}

	}

	private void makeThemFight(Collection<Jet> listFleet) {
		for (Jet jet : listFleet) {
			if (jet instanceof FighterJet) {
				System.out.println(jet.toString());
				((FighterJet) jet).Fight();
				System.out.println();
			}
		}
	}


	private void boardPassengers(Collection<Jet> listFleet) {
		for (Jet jet : listFleet) {
			if (jet instanceof PrivateJet) {
				System.out.println(jet.toString());
				((PrivateJet) jet).boardPassengers();
				System.out.println();
			}
		}
	}
	
	private void removeJet(Collection<Jet> listFleet) {
		int remove=0;
		int i = 1;
		System.out.println("Please select the jet that you want to remove ");
		for (Jet jet : listFleet) {
			System.out.println(i + ". " + jet.getClass().getSimpleName() + " "+ jet.getModel());
			i++;
		}
		try {
		remove = kb.nextInt();
		kb.nextLine();
//		remove = remove -1;
//		Boolean removed = listFleet.remove();
//		System.out.println("You successfully removed " + removed);
		System.out.println();
		} catch (InputMismatchException e) {
			System.err.println("Invalid option please try again.");
		}
	}
}
