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
		macdill.addUserJet(kb);
	}

	private void removeJetfromFleet() {
	}
}
