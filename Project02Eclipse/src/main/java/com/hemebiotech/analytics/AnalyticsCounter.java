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
     * Demonstration method : From symptoms.txt file, write results.out which lists symptoms types and their occurrences.
     */
    public static void main(String args[]) {
        AnalyticsCounter analytics = new AnalyticsCounter(new ReadSymptomDataFromFile("src/main/resources/symptoms.txt"), new WriteSymptomListToFile());

        if (analytics.getWriter().writeSymptomList(analytics.countSymptoms()))
            System.out.println("Processus de comptage des symptômes terminé.");
        else
            System.out.println("Une erreur s'est produite. Le fichier results.out n'a pas pu être crée.");
    }

    /**
     * From its reader's returned List<String>, store according List<Symptom> with no duplication and return it.
     * @return A list of identified Symptoms
     */
    public List<Symptom> countSymptoms() {
        List<String> symptomNamesList = this.getReader().getSymptoms();
        Stream<String> symptomStream = symptomNamesList.stream();
        symptomStream.distinct().sorted().forEach((x) -> this.symptomList.add(new Symptom((x))));

        for (Symptom symptom : this.symptomList) {
            symptomStream = symptomNamesList.stream();
            symptom.addOccurrences((int) symptomStream.filter((x) -> x.equals(symptom.getName())).count());
        }

        return this.symptomList;
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
