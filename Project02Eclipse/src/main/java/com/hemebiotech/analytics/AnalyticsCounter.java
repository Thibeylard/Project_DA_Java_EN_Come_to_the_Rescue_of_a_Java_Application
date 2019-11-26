package main.java.com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

    /**
     * Key method : From symptoms.txt file, write results.out which lists symptoms types and their occurrences.
     */
    public static void main(String args[]) {
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        WriteSymptomListToFile writer = new WriteSymptomListToFile();

        List<String> symptomNames = reader.getSymptoms();
        Collections.sort(symptomNames);
        List<Symptom> symptomList = AnalyticsCounter.createSymptomList(symptomNames);

        if (writer.writeSymptomList(symptomList))
            System.out.println("Processus de comptage des symptômes terminé.");
        else
            System.out.println("Une erreur s'est produite. Le fichier results.out n'a pas pu être crée.");
    }

    /**
     * From an ordered List<String> of symptom names, create a List<Symptom> with no duplication.
     *
     * @param symptomNamesList An ordered List<String> corresponding to symptoms names
     * @return A list of identified Symptoms from symptomNamesList
     */
    public static List<Symptom> createSymptomList(List<String> symptomNamesList) {
        String symptonName, previousSymptomName = "";
        Symptom currSympton = null;
        List<Symptom> symptomList = new ArrayList<Symptom>();
        ListIterator<String> symptomNameIterator = symptomNamesList.listIterator();

        // Loop processing at the same time Symptoms creation and counting.
        while (symptomNameIterator.hasNext()) {
            symptonName = symptomNameIterator.next();
            if (!symptonName.equals(previousSymptomName)) { // = New symptom identified
                previousSymptomName = symptonName;
                currSympton = new Symptom(symptonName, 1);
                symptomList.add(currSympton);
            } else { // Same symptom : add occurrence.
                currSympton.incrementOccurrences();
            }
            symptomNameIterator.remove(); // Retrieved symptomName is removed.
        }

        return symptomList;
    }
}
