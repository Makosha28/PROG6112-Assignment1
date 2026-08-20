
package com.mycompany.mavenproject1;

/**
 *
 * @author Student
 */


public class Inpatient extends Patient {
    private String wardNumber;
    private String bedNumber;

    public Inpatient(String patientId, String firstName, String lastName, int age,
                     String gender, String medicalCondition,
                     String wardNumber, String bedNumber) {
        super(patientId, firstName, lastName, age, gender, medicalCondition, PatientCategory.INPATIENT);
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

    public String getWardNumber() { return wardNumber; }
    public String getBedNumber() { return bedNumber; }
    public void setWardNumber(String wardNumber) { this.wardNumber = wardNumber; }
    public void setBedNumber(String bedNumber) { this.bedNumber = bedNumber; }

    @Override
    public void displayDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Patient ID       : " + getPatientId());
        System.out.println("Name             : " + getFirstName() + " " + getLastName());
        System.out.println("Age              : " + getAge());
        System.out.println("Gender           : " + getGender());
        System.out.println("Medical Condition: " + getMedicalCondition());
        System.out.println("Category         : " + getCategory());
        System.out.println("Ward Number      : " + wardNumber);
        System.out.println("Bed Number       : " + bedNumber);
        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {
        return super.toString() + " | Ward: " + wardNumber + " | Bed: " + bedNumber;
    }
}
