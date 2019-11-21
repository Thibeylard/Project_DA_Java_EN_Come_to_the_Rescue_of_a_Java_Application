package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class WriteSymptomListToFile implements ISymptomWriter {

    /**
     * @see ISymptomWriter
     */
    @Override
    public boolean writeSymptomList(List<Symptom> symptomList)  {

        if(symptomList.isEmpty())
            return false;

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.out"));
            ListIterator<Symptom> symptomListIterator = symptomList.listIterator();

            while(symptomListIterator.hasNext())
                writer.write(symptomListIterator.next().toString() + "\n");

            writer.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
