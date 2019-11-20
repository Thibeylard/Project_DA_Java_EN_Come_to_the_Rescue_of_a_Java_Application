package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		WriteSymptomListToFile writer = new WriteSymptomListToFile();
		AnalyticsCounter counter = new AnalyticsCounter();

		List<String> symptomNames = reader.GetSymptoms();
		Collections.sort(symptomNames);
		List<Symptom> symptomList = counter.createSymptomList(symptomNames);

		if(writer.writeSymptomList(symptomList))
			System.out.println("Processus de comptage des symptômes terminé.");
		else
			System.out.println("Une erreur s'est produite. Le fichier result.out n'a pas pu être crée.");
	}

	/**
	 * From a brut List<String> of symptom names, create a List<Symptom> with no duplication.
	 * @param symptomNamesList A list of symptoms names Strings
	 * @return A list of identified Symptoms from symptomNamesList
	 */
	public List<Symptom> createSymptomList(List<String> symptomNamesList){
		String symptonName, previousSymptomName = "";
		Symptom currSympton = null;
		List<Symptom> symptomList = new ArrayList<Symptom>();
		ListIterator<String> symptomNameIterator = symptomNamesList.listIterator();

		while(symptomNameIterator.hasNext()){
			symptonName = symptomNameIterator.next();
			if(!symptonName.equals(previousSymptomName)){
				previousSymptomName = symptonName;
				currSympton = new Symptom(symptonName,1);
				symptomList.add(currSympton);
			} else {
				currSympton.incrementOccurrences();
			}
			symptomNameIterator.remove();
		}

		return symptomList;
	}
}
