/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Student
 */
import java.util.*;

  public class Mavenproject1{
    private static HospitalSystem system= new HospitalSystem();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (scanner) {
            System.out.println("=================================================");
            System.out.println("   MediCare Hospital - Patient Admission System");
            System.out.println("=================================================");
            
            boolean running = true;
            while (running) {
                displayMainMenu();
                int choice = readInt("Enter your choice: ");
                switch (choice) {
                    case 1 -> patientManagementMenu();
                    case 2 -> bedManagementMenu();
                    case 3 -> reportsMenu();
                    case 4 -> {
                        System.out.println("Thank you for using the system. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n------------- MAIN MENU -------------");
        System.out.println("1. Patient Management");
        System.out.println("2. Bed Management");
        System.out.println("3. Reports");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------");
    }

    private static void patientManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------- PATIENT MANAGEMENT -------");
            System.out.println("1. Register a new patient");
            System.out.println("2. Search for a patient by ID");
            System.out.println("3. Update patient details");
            System.out.println("4. Delete a patient");
            System.out.println("5. Display all registered patients");
            System.out.println("6. Back to Main Menu");
            System.out.println("----------------------------------");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> updatePatient();
                case 4 -> deletePatient();
                case 5 -> system.displayAllPatients();
                case 6 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void registerPatient() {
        System.out.println("\n--- Register New Patient ---");
        String id = readString("Patient ID: ");
        String firstName = readString("First Name: ");
        String lastName = readString("Last Name: ");
        int age = readInt("Age: ");
        String gender = readString("Gender (M/F/Other): ");
        String condition = readString("Medical Condition: ");
        System.out.println("Patient Category:");
        System.out.println("1. Inpatient");
        System.out.println("2. Outpatient");
        System.out.println("3. Emergency");
        int catChoice = readInt("Select category (1-3): ");
        PatientCategory category;
        switch (catChoice) {
            case 1 -> category = PatientCategory.INPATIENT;
            case 2 -> category = PatientCategory.OUTPATIENT;
            case 3 -> category = PatientCategory.EMERGENCY;
            default -> {
                System.out.println("Invalid category. Defaulting to Outpatient.");
                category = PatientCategory.OUTPATIENT;
            }
        }
        system.registerPatient(id, firstName, lastName, age, gender, condition, category);
    }

    private static void searchPatient() {
        String id = readString("Enter Patient ID to search: ");
        Patient p = system.findPatientById(id);
        if (p != null) {
            System.out.println("Patient found:");
            p.displayDetails();
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void updatePatient() {
        String id = readString("Enter Patient ID to update: ");
        Patient p = system.findPatientById(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.println("Current details:");
        p.displayDetails();
        String firstName = readString("New First Name: ");
        String lastName = readString("New Last Name: ");
        int age = readInt("New Age: ");
        String gender = readString("New Gender: ");
        String condition = readString("New Medical Condition: ");
        system.updatePatient(id, firstName, lastName, age, gender, condition);
    }

    private static void deletePatient() {
        String id = readString("Enter Patient ID to delete: ");
        system.deletePatient(id);
    }

    private static void bedManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------- BED MANAGEMENT ---------");
            System.out.println("1. Allocate bed to an inpatient");
            System.out.println("2. Release a bed (discharge)");
            System.out.println("3. Display complete ward layout");
            System.out.println("4. Display available beds");
            System.out.println("5. Display occupied beds");
            System.out.println("6. Back to Main Menu");
            System.out.println("----------------------------------");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> allocateBed();
                case 2 -> releaseBed();
                case 3 -> system.displayWardLayout();
                case 4 -> system.displayAvailableBeds();
                case 5 -> system.displayOccupiedBeds();
                case 6 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void allocateBed() {
        String id = readString("Enter Inpatient Patient ID: ");
        system.allocateBed(id);
    }

    private static void releaseBed() {
        String bedNum = readString("Enter Bed Number to release (e.g. B01): ");
        system.releaseBed(bedNum);
    }

    private static void reportsMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------------ REPORTS -------------");
            System.out.println("1. Display all registered patients");
            System.out.println("2. Display all available beds");
            System.out.println("3. Display all occupied beds");
            System.out.println("4. Display total registered patients");
            System.out.println("5. Display total occupied beds");
            System.out.println("6. Display ward occupancy percentage");
            System.out.println("7. Full Ward Report");
            System.out.println("8. Back to Main Menu");
            System.out.println("----------------------------------");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> system.displayAllPatients();
                case 2 -> system.displayAvailableBeds();
                case 3 -> system.displayOccupiedBeds();
                case 4 -> System.out.println("Total registered patients: " + system.getTotalPatients());
                case 5 -> System.out.println("Total occupied beds: " + system.getOccupiedBedCount());
                case 6 -> System.out.printf("Ward occupancy percentage: %.1f%%%n", system.getOccupancyPercentage());
                case 7 -> system.generateFullReport();
                case 8 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
  }

