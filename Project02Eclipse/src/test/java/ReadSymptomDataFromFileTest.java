import main.java.com.hemebiotech.analytics.ISymptomReader;
import main.java.com.hemebiotech.analytics.ReadSymptomDataFromFile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadSymptomDataFromFileTest {

    @Test
    void Given_symptomFile_When_ReadSymptomData_Then_createArrayListString() {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptomsSample.txt");

        List<String> symptomsExpected = new ArrayList<String>();
        symptomsExpected.add("fever");
        symptomsExpected.add("dialated pupils");
        symptomsExpected.add("dry mouth");
        symptomsExpected.add("inflamation");
        symptomsExpected.add("tremor");
        symptomsExpected.add("stomach pain");

        List<String> symptoms = reader.getSymptoms();

        assertTrue(symptomsExpected.equals(symptoms));
    }
}