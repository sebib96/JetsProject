package com.skilldistillery.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.FighterJet;
import com.skilldistillery.entities.JetsImpl;

public class JetsApp {
	Scanner kb = new Scanner(System.in);
	AirField macdill = new AirField();

	ArrayList<String> jetList = new ArrayList<String>();

	public static void main(String[] args) {

		JetsApp run = new JetsApp();
		run.runApp();
	}

	public void runApp() {
		printMenu();
	}

	public void printMenu() {
		boolean running = true;
		do {
			System.out.println("1. List all Jets");
			System.out.println("2. Scramble Jets");
			System.out.println("3. View fastest Jet");
			System.out.println("4. View Jet with longest range");
			System.out.println("5. Load cargo Jets");
			System.out.println("6. Simulate dogfight");
			System.out.println("7. Add Jet to Fleet");
			System.out.println("8. Remove Jet from Fleet");
			System.out.println("9. Quit.");
			int choice = kb.nextInt();

			switch (choice) {
			case 1:
				listJetList();
				break;
			case 2:
				scrambleJets();
				break;
			case 3:
				printFastestJet();
				break;
			case 4:
				printLongestRange();
				break;
			case 5:
				loadCargoJet();
				break;
			case 6:
				dogfight();
				break;
			case 7:
				addJetToFleet();
				break;
			case 8:
				removeJetfromFleet();
				break;
			case 9:
				System.out.println("Exiting program...");
				running = false;
				break;
			}
		} while (running);
	}

	private void listJetList() {
		macdill.showListOfJets();
	}

	private void scrambleJets() {

	}

	private void printFastestJet() {
		macdill.getHighestSpeedJet();
	}

	private void printLongestRange() {
		macdill.getLongestRange();
	}

	private void loadCargoJet() {
		CargoPlane cargoPlane = new CargoPlane();
		cargoPlane.loadCargo();

	}

	private void dogfight() {
	}

	private void addJetToFleet() {
		macdill.getJetList();
		System.out.println("Is the Jet to be added: ");
		System.out.println("1. A Fighter Jet");
		System.out.println("2. A Cargo Jet");
		System.out.println("3. A Commercial Jet");
		System.out.println("4. Quit");
		int userChoice = kb.nextInt();
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
				AirField airField = new AirField();
				jetList.add(userFighterJet.toString());
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
				System.out.println("Enter the price of the Jet");
				long cargoPrice = kb.nextLong();
				CargoPlane userCargoPlane = new CargoPlane(cargoModel, cargoSpeed, cargoRange, cargoPrice);
				System.out.println(cargoModel + " has been added to the fleet");
				break;
			case 3:
				System.out.println("Enter the model of the Jet");
				String commercialModel = kb.nextLine();
				System.out.println("Enter the top speed of the Jet");
				double commercialSpeed = kb.nextDouble();
				System.out.println("Enter the range of the Jet");
				int commercialRange = kb.nextInt();
				System.out.println("Enter the price of the Jet");
				long commercialPrice = kb.nextLong();
				JetsImpl userCommercialJet = new JetsImpl(commercialModel, commercialSpeed, commercialRange,
						commercialPrice);

				System.out.println(commercialModel + " has been added to the fleet");
				break;
			case 4:
				System.out.println("Returning you to the main menu...");
				printMenu();
				break;
			}
		} while (running);
	}

	private void removeJetfromFleet() {
	}
}
