/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue1;


import Business.Patient.Order;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author CUTIE
 */
public class WorkRequest1 {

    private String message;
    private String symDetail;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private int requestID;
    private UserAccount patient;
    private Order order;
    private Date estimatedDelivery;
    private Date estDel;
    
    private static int count = 3000;
    
    public WorkRequest1(){
        requestID = count;
        count++;
        requestDate = new Date();
    }

    public UserAccount getPatient() {
        return patient;
    }

    public void setPatient(UserAccount patient) {
        this.patient = patient;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

//   public String getEstimatedDelivery() {
//       return new SimpleDateFormat("MM-dd-yyyy").format(estimatedDelivery);
//    }

    public Date getEstimatedDelivery() {
        return estimatedDelivery;
    }
    

    public void setEstimatedDelivery(Date estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }


    public Date getEstDel() {
        return estDel;
    }

    public void setEstDel(Date estDel) {
        this.estDel = estDel;
    }

    
    public String getSymDetail() {
        return symDetail;
    }

    public void setSymDetail(String symDetail) {
        this.symDetail = symDetail;
    }
    

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }
    

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

//    @Override
//    public String toString() {
//        return message;
//    }

    @Override
    public String toString() {
        return  ""+ order ;
    }
    
    
}
