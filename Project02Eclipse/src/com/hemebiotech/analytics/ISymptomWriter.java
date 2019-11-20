package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Apply to every class that would want to write an ordered Symptom List to a file.
 */
public interface ISymptomWriter {
    /**
     * Create file and write formatted content of each Symptoms from SymptonList. Return true if succeed.
     * @param symptomList list of Symptom objects.
     * @return true if write succeed
     * @throws IOException handle writing exceptions
     */
    boolean writeSymptomList(List<Symptom> symptomList) throws IOException;
}
