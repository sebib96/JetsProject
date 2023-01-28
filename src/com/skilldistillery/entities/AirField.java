package com.skilldistillery.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.skilldistillery.app.JetsApp;

public class AirField {
	public ArrayList<Jet> jetList = new ArrayList<>();
	
	public ArrayList<Jet> getJetList() {
		return jetList;
	}

	public void setJetList(ArrayList<Jet> jetList) {
		this.jetList = jetList;
	}

	public AirField(){
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

	public void showListOfJets() {
		System.out.println(jetList);
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

	public void scrambleJets() {
	}
	public void getUserJetToAirField() {
		JetsApp jetsAppObj = new JetsApp();
		//create method that takes in created jet (Jet obj) and adds that obj to fleet (jetList)
		
	}

}