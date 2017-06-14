/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Network.Network;
import Business.Patient.Patient;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue1.WorkQueue1;
import Business.WorkQueue2.WorkQueue2;

/**
 *
 * @author CUTIE
 */
public class UserAccount {

    private String username;
    private String password;
    private String mobileNumber;
    private Employee employee;
    private Patient patient;
    private Role role;
    private Network network;
    private WorkQueue workQueue;
    private WorkQueue1 workQueue1;
    private WorkQueue2 workQueue3;

    public UserAccount() {
        workQueue = new WorkQueue();
        workQueue1 = new WorkQueue1();
        workQueue3 = new WorkQueue2();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public WorkQueue2 getWorkQueue3() {
        return workQueue3;
    }

    public void setWorkQueue3(WorkQueue2 workQueue3) {
        this.workQueue3 = workQueue3;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public WorkQueue1 getWorkQueue1() {
        return workQueue1;
    }

    public void setWorkQueue1(WorkQueue1 workQueue1) {
        this.workQueue1 = workQueue1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    @Override
    public String toString() {
        return username;
    }

}
