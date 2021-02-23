import main.java.com.hemebiotech.analytics.ISymptomWriter;
import main.java.com.hemebiotech.analytics.Symptom;
import main.java.com.hemebiotech.analytics.WriteSymptomListToFile;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriteSymptomListToFileTest {

    @Test
    void Given_OrderedSymptomList_When_writeSymptomListToFile_Then_GetFormattedFileTextWithEachSymptomsAndOccurrences() throws IOException {
        List<Symptom> symptomList = new ArrayList<Symptom>();
        symptomList.add(new Symptom("symptomA", 2));
        symptomList.add(new Symptom("symptomB", 1));
        symptomList.add(new Symptom("symptomC", 3));

        ISymptomWriter writer = new WriteSymptomListToFile();
        assertTrue(writer.writeSymptomList(symptomList));

        List<String> symptomFileWrittenLine = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/results.out"));
        String line = reader.readLine();

        while (line != null) {
            symptomFileWrittenLine.add(line.replace("\n", ""));
            line = reader.readLine();
        }
        reader.close();

        assertTrue(symptomFileWrittenLine.get(0).equals(symptomList.get(0).toString()));
        assertTrue(symptomFileWrittenLine.get(1).equals(symptomList.get(1).toString()));
        assertTrue(symptomFileWrittenLine.get(2).equals(symptomList.get(2).toString()));

    }
}