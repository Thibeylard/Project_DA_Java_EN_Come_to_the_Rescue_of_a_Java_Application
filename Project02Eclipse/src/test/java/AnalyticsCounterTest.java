import main.java.com.hemebiotech.analytics.AnalyticsCounter;
import main.java.com.hemebiotech.analytics.Symptom;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsCounterTest {


    @Test
    void Given_OrderedStringList_When_createSymptomList_Then_GetSymptomsListWithStringsAsNamesAndStringOccurrencesAsOccurrences() {
        List<String> symptomNames = new ArrayList<String>();
        symptomNames.add("symptomA");
        symptomNames.add("symptomA");
        symptomNames.add("symptomB");
        symptomNames.add("symptomC");
        symptomNames.add("symptomC");
        symptomNames.add("symptomC");

        List<Symptom> symptomsExpected = new ArrayList<Symptom>();
        symptomsExpected.add(new Symptom("symptomA",2));
        symptomsExpected.add(new Symptom("symptomB",1));
        symptomsExpected.add(new Symptom("symptomC",3));

        AnalyticsCounter analytics = new AnalyticsCounter();
        List<Symptom> symptomsObtained = analytics.createSymptomList(symptomNames);

        assertEquals(3,symptomsObtained.size());
        assertTrue(symptomsExpected.equals(symptomsObtained));
        assertTrue(symptomNames.isEmpty());

    }
}