/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;
import Business.UserAccount.UserAccount;

/**
 *
 * @author CUTIE
 */
public class Patient{
    private String patientname;
    private String address;
    private Double weight;
    private int age;
    private UserAccount assigneddoctor;
    private String bloodgroup;
    private int patientID;
    private int count = 1001;
    private VitalSignHistorySensor vitalSignHistory;
    
     public Patient() {
        patientID = count;
        count++;
        this.vitalSignHistory = new VitalSignHistorySensor();
    
     
    }

    public VitalSignHistorySensor getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignHistorySensor vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

     
    public UserAccount getAssigneddoctor() {
        return assigneddoctor;
    }

    public void setAssigneddoctor(UserAccount assigneddoctor) {
        this.assigneddoctor = assigneddoctor;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return  patientname ;
    }
     
}
