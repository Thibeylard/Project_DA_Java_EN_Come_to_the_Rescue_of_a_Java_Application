package main.java.com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Stream;

public class AnalyticsCounter {

    List<Symptom> symptomList = new ArrayList<Symptom>();

    /**
     * Key method : From symptoms.txt file, write results.out which lists symptoms types and their occurrences.
     */
    public static void main(String args[]) {
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        WriteSymptomListToFile writer = new WriteSymptomListToFile();
        AnalyticsCounter analytics = new AnalyticsCounter();

        List<String> symptomNames = reader.GetSymptoms();
        analytics.initiateSymptomList(symptomNames);

        if (writer.writeSymptomList(analytics.getSymptomList()))
            System.out.println("Processus de comptage des symptômes terminé.");
        else
            System.out.println("Une erreur s'est produite. Le fichier results.out n'a pas pu être crée.");
    }

    /**
     * From an List<String> of symptom names, create a List<Symptom> with no duplication.
     *
     * @param symptomNamesList A List<String> corresponding to symptoms names
     * @return A list of identified Symptoms from symptomNamesList
     */
    public void initiateSymptomList(List<String> symptomNamesList) {
        Stream<String> symptomStream = symptomNamesList.stream();
        symptomStream.distinct().forEach((x) -> this.symptomList.add(new Symptom((x))));

        for (Symptom symptom : this.symptomList) {
            symptomStream = symptomNamesList.stream();
            symptom.addOccurrences((int) symptomStream.filter((x) -> x == symptom.getName()).count());
        }
    }

    public List<Symptom> getSymptomList() {
        return this.symptomList;
    }
}
