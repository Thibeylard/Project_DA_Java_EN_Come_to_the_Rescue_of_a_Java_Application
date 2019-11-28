package main.java.com.hemebiotech.analytics;

import java.util.List;

/**
 * Apply to every class that would want to write a Symptom List to a file.
 * It is important that every ISymptomWriter receive a List<Symptom> as parameter
 */
public interface ISymptomWriter {
    /**
     * Create file and write formatted content of each Symptoms from SymptonList. If symptomList is empty, return false.
     *
     * @param symptomList list of Symptom objects.
     * @return true if results.out has been created.
     */
    boolean writeSymptomList(List<Symptom> symptomList);
}
