

package com.mycompany.mavenproject1;

/**
 *
 * @author Student
 */
import java.util.ArrayList;
import java.util.List;

public class HospitalSystem {
    private final List<Patient> patients;
    private final BedManagement[] beds;
    private static final int TOTAL_BEDS = 20;
    private static final String WARD_NUMBER = "Ward-1";

    public HospitalSystem() {
        patients = new ArrayList<>();
        beds = new BedManagement[TOTAL_BEDS];
        for (int i = 0; i < TOTAL_BEDS; i++) {
            String bedNum = String.format("B%02d", i + 1);
            beds[i] = new BedManagement(bedNum);
        }
    }

    // ===== PATIENT MANAGEMENT =====
    public boolean registerPatient(String patientId, String firstName, String lastName,
                                   int age, String gender, String medicalCondition,
                                   PatientCategory category) {
        if (findPatientById(patientId) != null) {
            System.out.println("Error: Patient ID already exists.");
            return false;
        }
        Patient patient;
        if (category == PatientCategory.INPATIENT) {
            patient = new Inpatient(patientId, firstName, lastName, age, gender,
                    medicalCondition, WARD_NUMBER, "Not Allocated");
        } else {
            patient = new Patient(patientId, firstName, lastName, age, gender,
                    medicalCondition, category);
        }
        patients.add(patient);
        System.out.println("Patient registered successfully.");
        return true;
    }

    public Patient findPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientId().equalsIgnoreCase(patientId)) return p;
        }
        return null;
    }

    public boolean updatePatient(String patientId, String firstName, String lastName,
                                 int age, String gender, String medicalCondition) {
        Patient p = findPatientById(patientId);
        if (p == null) {
            System.out.println("Error: Patient not found.");
            return false;
        }
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        p.setGender(gender);
        p.setMedicalCondition(medicalCondition);
        System.out.println("Patient details updated successfully.");
        return true;
    }

    public boolean deletePatient(String patientId) {
        Patient p = findPatientById(patientId);
        if (p == null) {
            System.out.println("Error: Patient not found.");
            return false;
        }
        if (p instanceof Inpatient ip) {
            if (!"Not Allocated".equals(ip.getBedNumber())) {
                releaseBed(ip.getBedNumber());
            }
        }
        patients.remove(p);
        System.out.println("Patient deleted successfully.");
        return true;
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("\n========== ALL REGISTERED PATIENTS ==========");
        for (Patient p : patients) p.displayDetails();
    }

    public int getTotalPatients() { return patients.size(); }
    public List<Patient> getPatients() { return patients; }

    // ===== BED MANAGEMENT =====
    public boolean allocateBed(String patientId) {
        Patient p = findPatientById(patientId);
        if (p == null) {
            System.out.println("Error: Patient not found.");
            return false;
        }
        if (p.getCategory() != PatientCategory.INPATIENT) {
            System.out.println("Error: Only Inpatients may be allocated a hospital bed.");
            return false;
        }
        Inpatient ip = (Inpatient) p;
        if (!"Not Allocated".equals(ip.getBedNumber())) {
            System.out.println("Error: Patient already has bed " + ip.getBedNumber() + " allocated.");
            return false;
        }
        BedManagement freeBed = findFirstAvailableBed();
        if (freeBed == null) {
            System.out.println("Error: No beds available. Cannot allocate a bed.");
            return false;
        }
        freeBed.allocate(patientId);
        ip.setBedNumber(freeBed.getBedNumber());
        System.out.println("Bed " + freeBed.getBedNumber() + " allocated to patient " + patientId);
        return true;
    }

    public boolean releaseBed(String bedNumber) {
        BedManagement bed = findBedByNumber(bedNumber);
        if (bed == null) {
            System.out.println("Error: Invalid bed number.");
            return false;
        }
        if (!bed.isOccupied()) {
            System.out.println("Error: Bed " + bedNumber + " is already available.");
            return false;
        }
        String patientId = bed.getPatientId();
        bed.release();
        Patient p = findPatientById(patientId);
        if (p instanceof Inpatient inpatient) {
            inpatient.setBedNumber("Not Allocated");
        }
        System.out.println("Bed " + bedNumber + " released successfully.");
        return true;
    }

    public BedManagement findBedByNumber(String bedNumber) {
        for (BedManagement b : beds) {
            if (b.getBedNumber().equalsIgnoreCase(bedNumber)) return b;
        }
        return null;
    }

    public BedManagement findFirstAvailableBed() {
        for (BedManagement b : beds) {
            if (!b.isOccupied()) return b;
        }
        return null;
    }

    public void displayWardLayout() {
        System.out.println("\n========== WARD LAYOUT (4 x 5) ==========");
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int index = row * 5 + col;
                BedManagement b = beds[index];
                String status = b.isOccupied() ? "OCC" : "AVL";
                System.out.printf("%-6s(%s)  ", b.getBedNumber(), status);
            }
            System.out.println();
        }
        System.out.println("=========================================");
    }

    public void displayAvailableBeds() {
        System.out.println("\n========== AVAILABLE BEDS ==========");
        boolean any = false;
        for (BedManagement b : beds) {
            if (!b.isOccupied()) {
                System.out.println(b.getBedNumber());
                any = true;
            }
        }
        if (!any) System.out.println("No beds currently available.");
    }

    public void displayOccupiedBeds() {
        System.out.println("\n========== OCCUPIED BEDS ==========");
        boolean any = false;
        for (BedManagement b : beds) {
            if (b.isOccupied()) {
                System.out.println(b.getBedNumber() + " - Patient ID: " + b.getPatientId());
                any = true;
            }
        }
        if (!any) System.out.println("No beds currently occupied.");
    }

    public int getOccupiedBedCount() {
        int count = 0;
        for (BedManagement b : beds) if (b.isOccupied()) count++;
        return count;
    }

    public int getAvailableBedCount() { return TOTAL_BEDS - getOccupiedBedCount(); }

    public double getOccupancyPercentage() {
        return (getOccupiedBedCount() * 100.0) / TOTAL_BEDS;
    }

    // ===== REPORTS =====
    public void generateFullReport() {
        System.out.println("\n*************** WARD REPORT ***************");
        System.out.println("Total registered patients : " + getTotalPatients());
        System.out.println("Total occupied beds       : " + getOccupiedBedCount());
        System.out.println("Total available beds      : " + getAvailableBedCount());
        System.out.printf("Ward occupancy percentage : %.1f%%%n", getOccupancyPercentage());
        System.out.println("*******************************************");
        displayAllPatients();
        displayAvailableBeds();
        displayOccupiedBeds();
    }
}
