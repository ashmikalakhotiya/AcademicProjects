/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author CUTIE
 */
public class PatientDirectory {

    private ArrayList<Patient> patientList;

    public PatientDirectory() {
        patientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public Patient createPatient(String name, int age, Double weight, String bloodgroup, String address, UserAccount assignedDoc) {
        Patient patient = new Patient();
        patient.setPatientname(name);
        patient.setAddress(address);
        patient.setBloodgroup(bloodgroup);
        patient.setAge(age);
        patient.setWeight(weight);
        patient.setAssigneddoctor(assignedDoc);
        patientList.add(patient);
        return patient;
    }
}
