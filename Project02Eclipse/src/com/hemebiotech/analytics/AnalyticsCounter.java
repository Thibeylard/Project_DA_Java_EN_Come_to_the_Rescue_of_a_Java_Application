package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		//TODO
	}

	/**
	 * From a brut List<String> of symptom names, create a List<Symptom> with no duplication.
	 * @param symptomNamesList A list of symptoms names Strings
	 * @return A list of identified Symptoms from symptomNamesList
	 */
	public List<Symptom> createSymptomList(List<String> symptomNamesList){
		String symptonName = "", newSymptomName = "";
		Symptom currSympton = null;
		List<Symptom> symptomList = new ArrayList<Symptom>();
		ListIterator<String> symptomNameIterator = symptomNamesList.listIterator();

		while(symptomNameIterator.hasNext()){
			symptonName = symptomNameIterator.next();
			if(symptonName != newSymptomName){
				newSymptomName = symptonName;
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
