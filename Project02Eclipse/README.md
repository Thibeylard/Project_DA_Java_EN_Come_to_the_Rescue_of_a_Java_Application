# AnalyticsCounter
## Description
_AnalyticsCounter_ is a class defined to **store a list of different symptoms** from an **input**, and eventually redirects it to an **output**.

###Reading
The input is read by an _ISymtomReader_ interface. It must **return a String List** for AnalyticsCounter.

###SymptomList
Using a stream on a String List, initiateSymptomList() create a Symptom List instance with an object for each distinct symptom name. Symptom's attribute 'occurrences' is used to store how many times the symptom name is encountered during the process.

###Writing
The output is done through an ISymptomWriter interface. It must **receive a Symptom List as parameter**.