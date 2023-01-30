package com.skilldistillery.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AirField {
	private ArrayList<Jet> jetList = new ArrayList<>();

	public ArrayList<Jet> getJetList() {
		return jetList;
	}

	public void setJetList(ArrayList<Jet> jetList) {
		this.jetList = jetList;
	}

	public AirField() {
		readFile();
	}

	public void readFile() {
		try {
			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				String jetType = row[0];
				String jetModel = row[1];
				double jetTopSpeed = Double.parseDouble(row[2]);
				int jetRange = Integer.parseInt(row[3]);
				long jetPrice = Long.parseLong(row[4]);
				switch (jetType) {
				case "FighterJet":
					FighterJet newFighterJet = new FighterJet(jetModel, jetTopSpeed, jetRange, jetPrice);
					jetList.add(newFighterJet);
					break;
				case "CargoPlane":
					CargoPlane newCargoPlane = new CargoPlane(jetModel, jetTopSpeed, jetRange, jetPrice);
					jetList.add(newCargoPlane);
					break;
				case "JetImpl":
					JetsImpl newJetsImpl = new JetsImpl(jetModel, jetTopSpeed, jetRange, jetPrice);
					jetList.add(newJetsImpl);
					break;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.err.println("Problem while reading " + "jets.txt" + ": " + e.getMessage());
			return;
		}
		return;
	}

	public void showFullListOfJets() {
		int i = 1;
		for (Jet jet : jetList) {
			if (jet instanceof Jet) {
				System.out.println(i + ".Model: " + jet.getModel() + "\t Speed: " + jet.getSpeed() + "\t Range: "
						+ jet.getRange() + "\t Price: " + jet.getPrice() + "\n");
				i++;
			}
		}
	}

	public void showSimpleListOfJets() {
		int i = 1;
		for (Jet jet : jetList) {
			if (jet instanceof Jet) {
				System.out.println(i + ". " + jet.getModel());
				i++;
			}
		}
	}

	public Jet getHighestSpeedJet() {
		Jet topSpeedJet = jetList.get(0);
		for (Jet jet : jetList) {
			if (topSpeedJet.getSpeed() < jet.getSpeed()) {
				topSpeedJet = jet;
			}
		}
		System.out.println(topSpeedJet);
		return topSpeedJet;
	}

	public Jet getLongestRange() {
		Jet topRangeJet = jetList.get(0);
		for (Jet jet : jetList) {
			if (topRangeJet.getRange() < jet.getRange()) {
				topRangeJet = jet;
			}
		}
		System.out.println(topRangeJet);
		return topRangeJet;
	}

	public void addUserJet(Scanner kb) {
		try {
			int userChoice = 0;
			System.out.println("Is the Jet to be added: ");
			System.out.println("1. A Fighter Jet");
			System.out.println("2. A Cargo Jet");
			System.out.println("3. A Commercial Jet");
			System.out.println("4. Quit");
			userChoice = kb.nextInt();
			kb.nextLine();
			boolean running = true;
			do {
				switch (userChoice) {
				case 1:
					System.out.println("Enter the model of the Jet");
					String fighterModel = kb.next();
					System.out.println("Enter the top speed of the Jet");
					double fighterSpeed = kb.nextDouble();
					kb.nextLine();
					System.out.println("Enter the range of the Jet");
					int fighterRange = kb.nextInt();
					kb.nextLine();
					System.out.println("Enter the price of the Jet");
					long fighterPrice = kb.nextLong();
					kb.nextLine();
					FighterJet userFighterJet = new FighterJet(fighterModel, fighterSpeed, fighterRange, fighterPrice);
					jetList.add(userFighterJet);
					System.out.println(fighterModel + " has been added to the fleet");
					running = false;
					break;
				case 2:
					System.out.println("Enter the model of the Jet");
					String cargoModel = kb.nextLine();
					System.out.println("Enter the top speed of the Jet");
					double cargoSpeed = kb.nextDouble();
					kb.nextLine();
					System.out.println("Enter the range of the Jet");
					int cargoRange = kb.nextInt();
					kb.nextLine();
					System.out.println("Enter the price of the Jet");
					long cargoPrice = kb.nextLong();
					kb.nextLine();
					CargoPlane userCargoPlane = new CargoPlane(cargoModel, cargoSpeed, cargoRange, cargoPrice);
					jetList.add(userCargoPlane);
					System.out.println(cargoModel + " has been added to the fleet");
					running = false;
					break;
				case 3:
					System.out.println("Enter the model of the Jet");
					String commercialModel = kb.nextLine();
					System.out.println("Enter the top speed of the Jet");
					double commercialSpeed = kb.nextDouble();
					kb.nextLine();
					System.out.println("Enter the range of the Jet");
					int commercialRange = kb.nextInt();
					kb.nextLine();
					System.out.println("Enter the price of the Jet");
					long commercialPrice = kb.nextLong();
					kb.nextLine();
					JetsImpl userCommercialJet = new JetsImpl(commercialModel, commercialSpeed, commercialRange,
							commercialPrice);
					jetList.add(userCommercialJet);
					System.out.println(commercialModel + " has been added to the fleet");
					running = false;
					break;
				case 4:
					System.out.println("Returning you to the main menu...");
					break;
				default:
					System.out.println("Invalid input. Enter a valid input.");
					addUserJet(kb);
					break;
				}
			} while (running);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Returning to the main menu.");
		}
	}

	public void removeJet(Scanner kb) {
		showSimpleListOfJets();
		int jetToRemove = 0;
		System.out.println("Select the number of the Jet you would like to remove from the fleet.");
		try {
			jetToRemove = kb.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Enter a valid input. Returning you to the main menu.");
			return;
		}
		System.out.println("Your selected Jet has been removed.");
		jetList.remove(jetToRemove);
	}

	public void fly() {
		double flightTime = 0;
		for (Jet jet : jetList) {
			flightTime = jet.getRange() / jet.getSpeed();
			System.out.println("Model: " + jet.getModel() + "\n Top Speed: " + jet.getSpeed() + "\n Range: "
					+ jet.getRange() + "\n Price: " + jet.getPrice() + "\n Estimated Flight Time: " + flightTime);
		}
	}

	public void dogFight() {
		for (Jet jet : jetList) {
			if (jet instanceof FighterJet) {
				System.out.println(jet.getModel() + " is engaging.");
			}
		}
	}

	public void loadCargo() {
		for (Jet jet : jetList) {
			if (jet instanceof CargoPlane) {
				System.out.println(jet.getModel() + " is loading cargo...");
			}
		}
	}
}
