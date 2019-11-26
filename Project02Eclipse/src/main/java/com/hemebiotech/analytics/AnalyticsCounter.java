package main.java.com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Stream;

public class AnalyticsCounter {

    private List<Symptom> symptomList;
    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter() {
        this.symptomList = new ArrayList<Symptom>();
    }

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.symptomList = new ArrayList<Symptom>();
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Key method : From symptoms.txt file, write results.out which lists symptoms types and their occurrences.
     */
    public static void main(String args[]) {
        AnalyticsCounter analytics = new AnalyticsCounter(new ReadSymptomDataFromFile("symptoms.txt"), new WriteSymptomListToFile());

        List<String> symptomNames = analytics.getReader().GetSymptoms();
        analytics.initiateSymptomList(symptomNames);

        if (analytics.getWriter().writeSymptomList(analytics.getSymptomList()))
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

    public ISymptomReader getReader() {
        return reader;
    }

    public ISymptomWriter getWriter() {
        return writer;
    }
}
