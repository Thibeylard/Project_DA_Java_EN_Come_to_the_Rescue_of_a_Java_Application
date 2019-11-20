package com.hemebiotech.analytics;

public class Symptom {

    private String name;
    private int occurrences;

    public Symptom(String name){
        this.name = name;
    }

    public Symptom(String name, int occurrences){
        this.name = name;
        if (occurrences < 0)
            occurrences = 0;
        this.occurrences = occurrences;
    }

    public void incrementOccurrences(){
        this.occurrences++;
    }

    /*
    ============================================================ GETTERS
     */
    public String getName() {
        return name;
    }

    public int getOccurrences() {
        return occurrences;
    }
}
