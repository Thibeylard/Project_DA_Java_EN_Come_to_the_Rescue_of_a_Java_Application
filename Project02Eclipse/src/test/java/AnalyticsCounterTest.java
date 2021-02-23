import main.java.com.hemebiotech.analytics.AnalyticsCounter;
import main.java.com.hemebiotech.analytics.ISymptomReader;
import main.java.com.hemebiotech.analytics.Symptom;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsCounterTest {


    @Test
    void Given_OrderedStringList_When_createSymptomList_Then_GetSymptomsListWithStringsAsNamesAndStringOccurrencesAsOccurrences() {
        ISymptomReader mockReader = new ISymptomReader() {
            @Override
            public List<String> getSymptoms() {
                List<String> symptomNames = new ArrayList<String>();
                symptomNames.add("symptomA");
                symptomNames.add("symptomA");
                symptomNames.add("symptomB");
                symptomNames.add("symptomC");
                symptomNames.add("symptomC");
                symptomNames.add("symptomC");
                return symptomNames;
            }
        };

        List<Symptom> symptomsExpected = new ArrayList<Symptom>();
        symptomsExpected.add(new Symptom("symptomA", 2));
        symptomsExpected.add(new Symptom("symptomB", 1));
        symptomsExpected.add(new Symptom("symptomC", 3));

        AnalyticsCounter analytics = new AnalyticsCounter(mockReader,null);
        analytics.countSymptoms();

        assertEquals(3, analytics.getSymptomList().size());
        assertEquals(symptomsExpected, analytics.getSymptomList());
    }

    @Test
    void Given_UnorderedStringList_When_createSymptomList_Then_GetSymptomsListWithStringsAsNamesAndStringOccurrencesAsOccurrences() {
        ISymptomReader mockReader = new ISymptomReader() {
            @Override
            public List<String> getSymptoms() {
                List<String> symptomNames = new ArrayList<String>();
                symptomNames.add("symptomC");
                symptomNames.add("symptomA");
                symptomNames.add("symptomB");
                symptomNames.add("symptomC");
                symptomNames.add("symptomA");
                symptomNames.add("symptomC");
                return symptomNames;
            }
        };

        AnalyticsCounter analytics = new AnalyticsCounter(mockReader,null);
        analytics.countSymptoms();

        assertEquals(3, analytics.getSymptomList().size());

        for (Symptom symptom : analytics.getSymptomList()) {
            switch (symptom.getName()){
                case "symptomA" :
                    assertEquals(2, symptom.getOccurrences());
                    break;
                case "symptomB" :
                    assertEquals(1, symptom.getOccurrences());
                    break;
                case "symptomC" :
                    assertEquals(3, symptom.getOccurrences());
                    break;
                default :
                    fail();
                    break;
            }
        }
    }

    @Test
    void Given_emptyStringList_When_createSymptomList_Then_DoNothing() {
        ISymptomReader mockReader = new ISymptomReader() {
            @Override
            public List<String> getSymptoms() {
                return new ArrayList<String>();
            }
        };

        AnalyticsCounter analytics = new AnalyticsCounter(mockReader,null);
        analytics.countSymptoms();

        assertTrue(analytics.getSymptomList().isEmpty());
    }
}