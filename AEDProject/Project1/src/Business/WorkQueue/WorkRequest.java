/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author CUTIE
 */
public class WorkRequest {

    private String message;
    private String symDetail;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
   
    private String testResult;
    private UserAccount patient;
    private String medicine1;
    private String medicine2;
    private String medicine3;
    private String medicine4;
    private String dosage1;
    private String dosage2;
    private String dosage3;
    private String dosage4;
    private Date timestamp;
    
    
    
//    private int requestID;
//    private static int count = 3000;
    
    public WorkRequest(){
//        requestID = count;
//        count++;
        requestDate = new Date();
    }

    public String getSymDetail() {
        return symDetail;
    }

    public void setSymDetail(String symDetail) {
        this.symDetail = symDetail;
    }
    
    
    
    
    

//    public int getRequestID() {
//        return requestID;
//    }
//
//    public void setRequestID(int requestID) {
//        this.requestID = requestID;
//    }
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public UserAccount getPatient() {
        return patient;
    }

    public void setPatient(UserAccount patient) {
        this.patient = patient;
    }

    public String getMedicine1() {
        return medicine1;
    }

    public void setMedicine1(String medicine1) {
        this.medicine1 = medicine1;
    }

    public String getMedicine2() {
        return medicine2;
    }

    public void setMedicine2(String medicine2) {
        this.medicine2 = medicine2;
    }

    public String getMedicine3() {
        return medicine3;
    }

    public void setMedicine3(String medicine3) {
        this.medicine3 = medicine3;
    }

    public String getMedicine4() {
        return medicine4;
    }

    public void setMedicine4(String medicine4) {
        this.medicine4 = medicine4;
    }

    public String getDosage1() {
        return dosage1;
    }

    public void setDosage1(String dosage1) {
        this.dosage1 = dosage1;
    }

    public String getDosage2() {
        return dosage2;
    }

    public void setDosage2(String dosage2) {
        this.dosage2 = dosage2;
    }

    public String getDosage3() {
        return dosage3;
    }

    public void setDosage3(String dosage3) {
        this.dosage3 = dosage3;
    }

    public String getDosage4() {
        return dosage4;
    }

    public void setDosage4(String dosage4) {
        this.dosage4 = dosage4;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    
    
    
    

    @Override
    public String toString() {
        return message;
    }
    
}
