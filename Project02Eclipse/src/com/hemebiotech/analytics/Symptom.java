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

    @Override
    public boolean equals(Object obj){
        if(obj == null || !Symptom.class.isAssignableFrom(obj.getClass()))
            return false;

        final Symptom otherSymptom = (Symptom)obj;

        if(this.getName() == otherSymptom.getName() && this.getOccurrences() == otherSymptom.getOccurrences())
            return true;
        else
            return false;
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
