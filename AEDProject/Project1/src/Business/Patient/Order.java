
package Business.Patient;

import Business.Pharmacy.MedicalStore;
import Business.Pharmacy.Medicine;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author CUTIE
 */

public class Order {

    private static int count = 0;
    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private Patient patient;
    private MedicalStore medicalStore;
    private Double orderTotal;
    private Date orderDate;
    private Date estimatedDelivery;
  
     
    
    public Order() {
        count++;
        orderNumber = count;
        orderItemList = new ArrayList<>();
        orderDate= new Date();
    }

    @Override
    public String toString() {
        return "Order" + orderNumber ;
    }

    public Date getEstimatedDelivery() {
        return estimatedDelivery;
    }

    
    public void setEstimatedDelivery(Date estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }
    
    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void removeOrderItem(OrderItem o) {
        orderItemList.remove(o);
    }
    
    public OrderItem addOrderItem(Medicine m, Double price, int qty) {
        OrderItem o = new OrderItem();
        o.setMedicine(m);
        o.setPrice(price);
        o.setQuantity(qty);
        orderItemList.add(o);
        return o;
    }
    
    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }
    
    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicalStore getMedicalStore() {
        return medicalStore;
    }

    public void setMedicalStore(MedicalStore medicalStore) {
        this.medicalStore = medicalStore;
    }
    
    
}
