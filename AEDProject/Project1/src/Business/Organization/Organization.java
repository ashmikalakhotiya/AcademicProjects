/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Patient.PatientDirectory;
import Business.Pharmacy.MedicalStoreDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue1.WorkQueue1;
import Business.WorkQueue2.WorkQueue2;
import java.util.ArrayList;

/**
 *
 * @author CUTIE
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private WorkQueue1 workQueue1;
    private WorkQueue2 workQueue3;
    private EmployeeDirectory employeeDirectory;
    private PatientDirectory patientDirectory;
    private UserAccountDirectory userAccountDirectory;
    private MedicalStoreDirectory medicalStoreDirectory;
    private int organizationID;
    private static int counter;

    public enum Type {

        Admin("Admin Organization"),
        Doctor("Doctor Organization"),
        Receptionist("Receptionist Organziation"),
        Patient("Patient Organization"),
        Store("Store Organization"),
        Lab("Lab Organization");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        workQueue1 = new WorkQueue1();
        workQueue3 = new WorkQueue2();
        employeeDirectory = new EmployeeDirectory();
        patientDirectory = new PatientDirectory();
        userAccountDirectory = new UserAccountDirectory();
        medicalStoreDirectory = new MedicalStoreDirectory();
        organizationID = counter;
        ++counter;
    }

    public MedicalStoreDirectory getMedicalStoreDirectory() {
        return medicalStoreDirectory;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public WorkQueue2 getWorkQueue3() {
        return workQueue3;
    }

    public void setWorkQueue3(WorkQueue2 workQueue3) {
        this.workQueue3 = workQueue3;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public WorkQueue1 getWorkQueue1() {
        return workQueue1;
    }

    public void setWorkQueue1(WorkQueue1 workQueue1) {
        this.workQueue1 = workQueue1;
    }

    @Override
    public String toString() {
        return name;
    }

}
