
package com.mycompany.mavenproject1;



public class BedManagement {
    //Declarations
    private final String bedNumber;
    private boolean occupied;
    private String patientId;

    public BedManagement(String bedNumber) {
        this.bedNumber = bedNumber;
        this.occupied = false;
        this.patientId = null;
    }

    public String getBedNumber() { 
        return bedNumber; }
    public boolean isOccupied() { 
        return occupied; }
    public String getPatientId() { 
        return patientId; }

    public void allocate(String patientId) {
        this.occupied = true;
        this.patientId = patientId;
    }

    public void release() {
        this.occupied = false;
        this.patientId = null;
    }

    @Override
    public String toString() {
        if (occupied) {
            return bedNumber + " [Occupied by " + patientId + "]";
        }
        return bedNumber + " [Available]";
    }
}
