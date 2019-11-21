package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Apply to every class that would want to write an ordered Symptom List to a file.
 */
public interface ISymptomWriter {
    /**
     * Create file and write formatted content of each Symptoms from SymptonList. If symptomList is empty, return false.
     * @param symptomList list of Symptom objects.
     * @return true if results.out has been created.
     */
    boolean writeSymptomList(List<Symptom> symptomList);
}
